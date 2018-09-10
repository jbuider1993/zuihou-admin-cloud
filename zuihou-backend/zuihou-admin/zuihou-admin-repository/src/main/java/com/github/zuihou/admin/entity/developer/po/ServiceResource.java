package com.github.zuihou.admin.entity.developer.po;

import com.github.zuihou.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ServiceResource extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    private Long moduleId;

    /**
     * 父id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String describe;

    /**
     * 路径
     *
     * @mbggenerated
     */
    private String basePath;

    /**
     * 资源主机
     *
     * @mbggenerated
     */
    private String host;

    /**
     * api路径
     *
     * @mbggenerated
     */
    private String uri;

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    private String httpMethod;

    /**
     * 状态： 0启用 1禁用
     *
     * @mbggenerated
     */
    private Boolean status;

    /**
     * 是否公有资源 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    private Boolean isPublic;

    /**
     * 序号
     *
     * @mbggenerated
     */
    private Integer orderNo;

    /**
     * 创建人账号
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人账号
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 父id
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父id
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    /**
     * 路径
     *
     * @mbggenerated
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * 路径
     *
     * @mbggenerated
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath == null ? null : basePath.trim();
    }

    /**
     * 资源主机
     *
     * @mbggenerated
     */
    public String getHost() {
        return host;
    }

    /**
     * 资源主机
     *
     * @mbggenerated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * api路径
     *
     * @mbggenerated
     */
    public String getUri() {
        return uri;
    }

    /**
     * api路径
     *
     * @mbggenerated
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod == null ? null : httpMethod.trim();
    }

    /**
     * 状态： 0启用 1禁用
     *
     * @mbggenerated
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 状态： 0启用 1禁用
     *
     * @mbggenerated
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 是否公有资源 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * 是否公有资源 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 创建人账号
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人账号
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人账号
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人账号
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}