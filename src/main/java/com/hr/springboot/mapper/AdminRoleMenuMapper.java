package com.hr.springboot.mapper;

import com.hr.springboot.domain.AdminRoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
public interface AdminRoleMenuMapper extends Mapper<AdminRoleMenu> {
    List<AdminRoleMenu> selectAllByRid(List<Integer> rids);
}
