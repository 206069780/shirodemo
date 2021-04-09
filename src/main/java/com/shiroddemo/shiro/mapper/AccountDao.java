package com.shiroddemo.shiro.mapper;


import com.shiroddemo.shiro.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @PackageName com.shiro.shirodemo.mapper
 * @ProjectName shirodemo
 * @ClassNmae AccountDao
 * @Author Administrator
 * @Date 2021/4/9 11:55
 * @Created by FU Ddopin
 * @Email fudaopin@gmail.com
 * @Description TODO
 */
@Mapper
public interface AccountDao {

    public Account getByName(@Param("usernmae") String usernmae);

}
