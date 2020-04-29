package com.hr.springboot.service;

import com.hr.springboot.domain.AdminRole;

import java.util.BitSet;
import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
public interface AdminRoleService{

    List<AdminRole> listRolesByUser(String username);
}
