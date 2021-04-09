package com.shiroddemo.shiro.model;

import java.io.Serializable;

/**
 * @PackageName com.shiro.shirodemo.bean
 * @ProjectName shirodemo
 * @ClassNmae Account
 * @Author Administrator
 * @Date 2021/4/9 11:51
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description Accountbean
 */
public class Account implements Serializable {
    public static final Long serialVersionUID = -7432478349823489L;
    /*用户id*/
    private Integer id;
    /*用户名*/
    private String username;
    /*用户密码*/
    private String passwd;
    /*用户权限*/
    private String perms;
    /*用户角色*/
    private String role;

    public Account(){}

    public Account(Integer id, String username, String passwd, String perms, String role) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
        this.perms = perms;
        this.role = role;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", usernmae='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", perms='" + perms + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
