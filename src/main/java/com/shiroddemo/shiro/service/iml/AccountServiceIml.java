package com.shiroddemo.shiro.service.iml;


import com.shiroddemo.shiro.mapper.AccountDao;
import com.shiroddemo.shiro.model.Account;
import com.shiroddemo.shiro.service.AccountSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName com.shiro.shirodemo.service.iml
 * @ProjectName shirodemo
 * @ClassNmae AccountServiceIml
 * @Author Administrator
 * @Date 2021/4/9 14:08
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description AccountSevice 实现类
 */
@Service
public class AccountServiceIml implements AccountSevice {

    @Autowired
    AccountDao accountDao;

    @Override
    public Account getByName(String userName) {
        return accountDao.getByName(userName);
    }
}
