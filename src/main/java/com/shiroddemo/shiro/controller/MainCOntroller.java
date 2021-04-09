package com.shiroddemo.shiro.controller;


import com.fasterxml.jackson.core.JsonToken;
import org.apache.catalina.Session;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @PackageName com.shiroddemo.shiro.controller
 * @ProjectName shiro
 * @ClassNmae MainCOntroller
 * @Author Administrator
 * @Date 2021/4/9 17:28
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description 程序入口 控制器
 */

@Controller
public class MainCOntroller {


    /**
     * 必须登录才可使用
     *
     * @return
     */
    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    @ResponseBody
    public Object loginout() {
        return "loginout";
    }

    /**
     * 必须具有root的权限才可以使用
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/root", method = RequestMethod.GET)
    public Object root() {
        return "root";
    }

    /**
     * 必须具有admin的角色才可以
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public Object admin() {
        return "admin";
    }

    @ResponseBody
    @RequestMapping(value = "/hel", method = RequestMethod.GET)
    public Object user() {
        return "user";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
        try {
            subject.login(token);
            subject.getSession().setAttribute("account", subject.getPrincipal());
            return "登录成功";
        } catch (UnknownAccountException e) {
            return "密码和用户名不正确";
        } catch (IncorrectCredentialsException e) {
            return "密码或用户名不正确";
        } catch (AuthenticationException e) {
            return "Token 认证失败";
        }

    }

    @RequestMapping(value = "/eorr", method = RequestMethod.GET)
    @ResponseBody
    public Object eorr(){
        return "eorr";
    }
}
