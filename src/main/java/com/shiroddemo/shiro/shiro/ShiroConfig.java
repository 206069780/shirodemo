package com.shiroddemo.shiro.shiro;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @PackageName com.shiro.shirodemo.shiroconfig
 * @ProjectName shirodemo
 * @ClassNmae ShiroConfig
 * @Author Administrator
 * @Date 2021/4/9 14:19
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description ShiroConfig 配置
 */

@Configuration
public class ShiroConfig {

    private Map<String, String> permsMap;

    /**
     * 实现权限控制
     *      1、authc 必须登录
     *      2、perms 拥有对应的权限
     *      3、roles 拥有对应的角色
     * @param securityManager
     * @return
     */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        permsMap = new HashMap<>();
        permsMap.put("/login","authc");
        permsMap.put("/root","perms[root]");
        permsMap.put("/admin","roles[admin]");
        factoryBean.setFilterChainDefinitionMap(permsMap);
        return factoryBean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }


    @Bean("myRealm")
    public MyRealm myRealm() {
        return new MyRealm();
    }


}
