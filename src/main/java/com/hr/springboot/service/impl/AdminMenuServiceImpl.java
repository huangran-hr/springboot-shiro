package com.hr.springboot.service.impl;

import com.hr.springboot.domain.AdminMenu;
import com.hr.springboot.domain.AdminRoleMenu;
import com.hr.springboot.domain.AdminUserRole;
import com.hr.springboot.domain.User;
import com.hr.springboot.mapper.AdminMenuMapper;
import com.hr.springboot.service.AdminMenuService;
import com.hr.springboot.service.AdminRoleMenuService;
import com.hr.springboot.service.AdminUserRoleService;
import com.hr.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:35
 * @Description:
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService{

    @Resource
    private AdminMenuMapper adminMenuMapper;

    @Resource
    private UserService userService;

    @Resource
    private AdminUserRoleService adminUserRoleService;

    @Resource
    private AdminRoleMenuService adminRoleMenuService;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        // 从数据库中获取当前用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByUserName(username);

        // 获得当前用户对应的所有角色的 id 列表
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        // 查询出这些角色对应的所有菜单项
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuMapper.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // 处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    public void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
    }

    private List<AdminMenu> getAllByParentId(Integer id) {
        Example e = new Example(AdminMenu.class);
        e.createCriteria().andEqualTo("parentId", id);
        return adminMenuMapper.selectByExample(e);
    }

}
