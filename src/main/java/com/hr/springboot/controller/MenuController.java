package com.hr.springboot.controller;

import com.hr.springboot.domain.AdminMenu;
import com.hr.springboot.service.AdminMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 18:02
 * @Description:
 */
@RestController
public class MenuController {

    @Resource
    private AdminMenuService adminMenuService;

    @CrossOrigin
    @GetMapping("/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }
}
