package com.shiroddemo.shiro;

import com.shiroddemo.shiro.model.Account;
import com.shiroddemo.shiro.service.iml.AccountServiceIml;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Autowired
    AccountServiceIml accountServiceIml;
    @Test
    void contextLoads() {
        Account account = accountServiceIml.getByName("root");
        System.out.println(account.getPasswd());
    }

}
