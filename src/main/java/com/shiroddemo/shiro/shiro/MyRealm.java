package com.shiroddemo.shiro.shiro;

import com.shiroddemo.shiro.service.iml.AccountServiceIml;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import com.shiroddemo.shiro.model.Account;

import java.util.HashSet;
import java.util.Set;

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

        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();

        Set<String> roles = new HashSet<>();
        roles.add(account.getRole());

        /*角色*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        /*权限*/
        info.addStringPermission(account.getPerms());

        return info;
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
        try {

            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            Account account = accountServiceIml.getByName(token.getUsername());
            if (account != null) {
                return new SimpleAuthenticationInfo(account, account.getPasswd(), getName());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}