package com.github.zuihou.admin.entity.authority.po;

import com.github.zuihou.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class RoleResource extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 权限Id 角色id(a_role)
     *
     * @mbggenerated
     */
    private Long roleId;

    /**
     * 资源id a_resources表
     *
     * @mbggenerated
     */
    private Long resourceId;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 权限Id 角色id(a_role)
     *
     * @mbggenerated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 权限Id 角色id(a_role)
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 资源id a_resources表
     *
     * @mbggenerated
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 资源id a_resources表
     *
     * @mbggenerated
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}