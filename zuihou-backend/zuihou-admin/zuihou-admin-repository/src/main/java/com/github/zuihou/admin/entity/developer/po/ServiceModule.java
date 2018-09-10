package com.github.zuihou.admin.entity.developer.po;

import com.github.zuihou.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ServiceModule extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 图标
     *
     * @mbggenerated
     */
    private String logo;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String describe;

    /**
     * 状态： 0、正常使用中   1、已过时（有新版本取代）     2、停止使用
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 模块类型 数据字典取
     *
     * @mbggenerated
     */
    private String type;

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

    /**
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    private Boolean publicIs;

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    private Boolean publicLook;

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    private String apiUrl;

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    private Integer resourceNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

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
     * 图标
     *
     * @mbggenerated
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 功能编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * 状态： 0、正常使用中   1、已过时（有新版本取代）     2、停止使用
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态： 0、正常使用中   1、已过时（有新版本取代）     2、停止使用
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 联系人邮箱
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 模块类型 数据字典取
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 模块类型 数据字典取
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    /**
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    public Boolean getPublicIs() {
        return publicIs;
    }

    /**
     * 是否公有模块 所有人可调用(无需申请)
     *
     * @mbggenerated
     */
    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
    }

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    public Boolean getPublicLook() {
        return publicLook;
    }

    /**
     * 是否公开模块   需要登陆才可以看到。
     *
     * @mbggenerated
     */
    public void setPublicLook(Boolean publicLook) {
        this.publicLook = publicLook;
    }

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * API接口文档地址
     *
     * @mbggenerated
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    public Integer getResourceNum() {
        return resourceNum;
    }

    /**
     * 资源数量（接口数量）
     *
     * @mbggenerated
     */
    public void setResourceNum(Integer resourceNum) {
        this.resourceNum = resourceNum;
    }
}