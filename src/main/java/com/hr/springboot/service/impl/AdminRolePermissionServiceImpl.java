package com.hr.springboot.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.AdminRolePermissionMapper;
import com.hr.springboot.service.AdminRolePermissionService;
/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
@Service
public class AdminRolePermissionServiceImpl implements AdminRolePermissionService{

    @Resource
    private AdminRolePermissionMapper adminRolePermissionMapper;

}
