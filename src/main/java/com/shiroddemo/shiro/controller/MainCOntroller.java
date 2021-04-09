package com.shiroddemo.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public Object login(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        return null;
    }
}
