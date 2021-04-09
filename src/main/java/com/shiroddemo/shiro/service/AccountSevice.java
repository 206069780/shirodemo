package com.shiroddemo.shiro.service;

import com.shiroddemo.shiro.model.Account;

/**
 * @PackageName com.shiroddemo.shiro.service
 * @ProjectName shiro
 * @ClassNmae AccountSevice
 * @Author Administrator
 * @Date 2021/4/9 16:43
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description TODO
 */
public interface AccountSevice {

    public Account getByName(String userName);
}
