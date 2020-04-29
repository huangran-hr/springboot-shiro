package com.hr.springboot.service.impl;

import com.hr.springboot.domain.AdminUserRole;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.AdminUserRoleMapper;
import com.hr.springboot.service.AdminUserRoleService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService{

    @Resource
    private AdminUserRoleMapper adminUserRoleMapper;

    @Override
    public List<AdminUserRole> listAllByUid(Integer uid) {
        Example example = new Example(AdminUserRole.class);
        example.createCriteria().andEqualTo("uid", uid);
        return adminUserRoleMapper.selectByExample(example);
    }
}
