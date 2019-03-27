package com.github.zuihou.commons.adapter;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import com.github.zuihou.commons.exception.core.ExceptionCode;
import com.google.common.base.Predicate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
public abstract class Swagger2WebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Value("${authentication.app.header-name:token}")
    protected String tokenHeader;
    @Value("${authentication.user.header-name:user-token}")
    protected String userTokenHeader;
    @Autowired
    protected ServletContext servletContext;

    protected abstract Swagger2BaseProperties getSwagger2BaseProperties();

    @ConfigurationProperties(
            prefix = "swagger2"
    )
    @Data
    public static class Swagger2BaseProperties {
        /**
         * 联系人姓名
         */
        private String contactName;
        /**
         * 联系人地址
         */
        private String contactUrl;
        /**
         * 联系人邮箱
         */
        private String contactEmail;
        /**
         * swagger 地址的前缀 : gateip:gateport
         */
        private String host = "";
        /**
         * 具体的信息
         */
        private Map<String, CloudDocketInfo> docketInfo;
    }

    @Data
    public static class CloudDocketInfo {
        /**
         * 服务标题
         */
        private String title;
        /**
         * 服务描述
         */
        private String description;
        /**
         * 接口地址的统一前缀
         */
        private String basePath;
        /**
         * 子模块
         */
        private Map<String, CloudModule> modules;

    }

    @Data
    public static class CloudModule {
        /**
         * 分组名，对应swagger中，唯一的一个子模块
         */
        private String groupName;
        /**
         * 扫描的子模块对应的包   packages/clazz任选其一，packages优先级大
         */
        private String packages;
        /**
         * 扫描的子模块对应的注解类， 需要完整的路径 eg: com.github.zuihou.xx.XxxModule.  packages/clazz任选其一，packages优先级大
         */
        private String clazz;
    }

    /**
     * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
     * <!--swagger资源配置-->
     * <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     * <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     * 不知道为什么，这也是spring boot的一个缺点（菜鸟觉得的）
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    protected List<ResponseMessage> getResponseMessages() {
        List<ResponseMessage> collect = Arrays.asList(
                ExceptionCode.SUCCESS
                , ExceptionCode.SYSTEM_TIMEOUT
                , ExceptionCode.SYSTEM_BUSY
                , ExceptionCode.PARAM_EX
                , ExceptionCode.SQL_EX
                , ExceptionCode.NULL_POINT_EX
                , ExceptionCode.ILLEGALA_RGUMENT_EX
                , ExceptionCode.MEDIA_TYPE_EX
                , ExceptionCode.BASE_VALID_PARAM
                , ExceptionCode.JWT_TOKEN_EXPIRED
                , ExceptionCode.JWT_SIGNATURE
                , ExceptionCode.JWT_ILLEGAL_ARGUMENT
                , ExceptionCode.JWT_PARSER_TOKEN_FAIL
        ).stream().map((val) ->
                new ResponseMessageBuilder().code(val.getCode()).message(val.getMsg()).build()
        ).collect(Collectors.toList());

        return collect;
    }

    /**
     * 被 MyOperationBuilderPlugin 插件 取代
     *
     * @return
     */
    protected ApiInfo getApiInfo(String title, String description) {
        Contact contact = new Contact(getSwagger2BaseProperties().getContactName(),
                getSwagger2BaseProperties().getContactUrl(),
                getSwagger2BaseProperties().getContactEmail());
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(contact)
                .version("1.0")
                .build();
    }


    protected Docket getDefDocket(String serverName, String moduleName) {
        Map<String, CloudDocketInfo> docketInfos = getSwagger2BaseProperties().getDocketInfo();
        CloudDocketInfo docketInfo = docketInfos.get(serverName);
        CloudModule module = docketInfo.getModules().get(moduleName);
        return getDefDocket(docketInfo, module, getResponseMessages());
    }

    /**
     * 默认的生成docket bean 方法
     *
     * @param docketInfo
     * @param module
     * @param responseMessages
     * @return
     */
    protected Docket getDefDocket(CloudDocketInfo docketInfo, CloudModule module, List<ResponseMessage> responseMessages) {
        Swagger2BaseProperties baseProperties = this.getSwagger2BaseProperties();
        String title = docketInfo.getTitle();
        String description = docketInfo.getDescription();
        Predicate<RequestHandler> selector;
        if (StringUtils.isEmpty(module.getPackages())) {
            Class<? extends Annotation> aClass = null;
            try {
                aClass = (Class<? extends Annotation>) Class.forName(module.getClazz());
            } catch (ClassNotFoundException e) {
                log.error("生成swagger时，解析【clazz】字段出错。请输入完整包名+类名. 如： com.github.commons.servicemodule.annotation.AuthModule. {}", e);
            }
            selector = RequestHandlerSelectors.withClassAnnotation(aClass);
        } else {
            selector = RequestHandlerSelectors.basePackage(module.getPackages());
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .host(baseProperties.getHost())
                .apiInfo(getApiInfo(title, description))
                .groupName(module.getGroupName())  //内部API
                .select()
                .apis(selector)
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                .pathProvider(new ExtRelativePathProvider(servletContext, docketInfo.getBasePath()));

    }


    /**
     * auth-client 中的拦截器需要排除拦截的地址
     *
     * @return
     */
    protected ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/error",
                "/login",
                "/p/login/**",
                "/v2/api-docs",
                "/swagger-resources/**",
                "/webjars/**",

                "/",
                "/csrf",

                "/META-INF/resources/**",
                "/resources/**",
                "/static/**",
                "/public/**",
                "classpath:/META-INF/resources/**",
                "classpath:/resources/**",
                "classpath:/static/**",
                "classpath:/public/**",

                "/cache/**",
                "/swagger-ui.html**",
        };
        Collections.addAll(list, urls);
        return list;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (getHandlerInterceptor() != null) {
            ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
            registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/**")
                    .excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        }
        super.addInterceptors(registry);
    }

    protected HandlerInterceptor getHandlerInterceptor() {
        return null;
    }

    /**
     * 用于根据 是否忽略token的注解来 在swagger页面动态生成 用户 token 和 user-token。
     *
     * @return
     */
    @Bean
    public MyOperationBuilderPlugin getMyOperationBuilderPlugin(@Value("${spring.profiles.active:dev}") String profiles) {
        return new MyOperationBuilderPlugin(getIsIgnoreToken(), profiles);
    }

    /**
     * 整个项目需要忽略token的，请覆盖该方法
     *
     * @return
     */
    public boolean getIsIgnoreToken() {
        return false;
    }


}

