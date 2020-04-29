package com.hr.springboot.service.impl;

import com.hr.springboot.domain.AdminRoleMenu;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.AdminRoleMenuMapper;
import com.hr.springboot.service.AdminRoleMenuService;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService{

    @Resource
    private AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public List<AdminRoleMenu> findAllByRid(List<Integer> rids) {
        return adminRoleMenuMapper.selectAllByRid(rids);
    }
}
