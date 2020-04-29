package com.hr.springboot.service;

import java.util.Set;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
public interface AdminPermissionService{

    Set<String> listPermissionURLsByUser(String username);

    boolean needFilter(String requestAPI);
}
