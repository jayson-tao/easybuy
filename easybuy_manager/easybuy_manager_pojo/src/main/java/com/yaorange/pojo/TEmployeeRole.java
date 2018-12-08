package com.yaorange.pojo;

import java.io.Serializable;

public class TEmployeeRole implements Serializable {
    private Long id;

    private Long createTime;

    private Long updateIme;

    private Long employeeId;

    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateIme() {
        return updateIme;
    }

    public void setUpdateIme(Long updateIme) {
        this.updateIme = updateIme;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}