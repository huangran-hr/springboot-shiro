package com.hr.springboot.controller;

import com.hr.springboot.domain.User;
import com.hr.springboot.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/29 14:20
 * @Description:
 */
@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequiresPermissions("/api/admin/user")  //注解的方式控制用户信息查询权限
    @GetMapping("/api/admin/user")
    public List<User> listUsers() throws Exception {
        return userService.list();
    }

}
