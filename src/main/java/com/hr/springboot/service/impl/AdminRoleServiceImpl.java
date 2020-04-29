package com.hr.springboot.service.impl;

import com.hr.springboot.domain.AdminRole;
import com.hr.springboot.domain.AdminRolePermission;
import com.hr.springboot.domain.AdminUserRole;
import com.hr.springboot.domain.User;
import com.hr.springboot.mapper.UserMapper;
import com.hr.springboot.service.AdminUserRoleService;
import com.hr.springboot.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.AdminRoleMapper;
import com.hr.springboot.service.AdminRoleService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Resource
    private UserService userService;

    @Resource
    private AdminUserRoleService adminUserRoleService;

    @Override
    public List<AdminRole> listRolesByUser(String username) {
        User user = userService.getByUserName(username);
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        List<AdminRole> adminRoles = adminRoleMapper.selectRolesByIds(rids);
        return adminRoles;
    }
}
