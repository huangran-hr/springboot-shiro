package com.hr.springboot.service.impl;

import com.hr.springboot.domain.AdminPermission;
import com.hr.springboot.domain.AdminRole;
import com.hr.springboot.domain.AdminRolePermission;
import com.hr.springboot.mapper.AdminRolePermissionMapper;
import com.hr.springboot.service.AdminRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.AdminPermissionMapper;
import com.hr.springboot.service.AdminPermissionService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
@Service
public class AdminPermissionServiceImpl implements AdminPermissionService{

    @Resource
    private AdminPermissionMapper adminPermissionMapper;

    @Resource
    private AdminRoleService adminRoleService;

    @Resource
    private AdminRolePermissionMapper adminRolePermissionMapper;

    /**
     * 根据用户获取所有权限
     * @param username
     * @return
     */
    @Override
    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());

        List<Integer> pids = adminRolePermissionMapper.findAllByRid(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionMapper.findAllById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

        return URLs;
    }

    /**
     * 用于判断用户请求接口的是否在权限列表中。如果没有对应权限，说明不需要维护
     * @param requestAPI
     * @return
     */
    @Override
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionMapper.selectAll();
        for (AdminPermission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }
}
