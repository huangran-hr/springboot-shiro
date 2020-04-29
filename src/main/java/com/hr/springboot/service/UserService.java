package com.hr.springboot.service;

import com.hr.springboot.domain.User;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/23 10:44
 * @Description:
 */
public interface UserService{
    void add(User user);

    boolean isExist(String username);

    User getByUserName(String userName);

    List<User> list();
}
