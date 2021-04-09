package com.shiroddemo.shiro.shiro;

import com.shiroddemo.shiro.service.iml.AccountServiceIml;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.shiroddemo.shiro.model.Account;

/**
 * @PackageName com.shiroddemo.shiro.shiro
 * @ProjectName shiro
 * @ClassNmae MyRealm
 * @Author Administrator
 * @Date 2021/4/9 16:39
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description TODO
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    AccountServiceIml accountServiceIml;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }
    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken.getPrincipal();
        Account account = accountServiceIml.getByName(token.getUsername());
        if (account != null) {
            return new SimpleAuthenticationInfo(account, account.getPasswd(), getName());
        }
        return null;
    }
}