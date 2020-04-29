package com.hr.springboot.service;

import com.hr.springboot.domain.AdminRoleMenu;

import java.util.BitSet;
import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
public interface AdminRoleMenuService{

        List<AdminRoleMenu> findAllByRid(List<Integer> rids);
}
