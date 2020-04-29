package com.hr.springboot.service;

import com.hr.springboot.domain.AdminMenu;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:35
 * @Description:
 */
public interface AdminMenuService{

    List<AdminMenu> getMenusByCurrentUser();

}
