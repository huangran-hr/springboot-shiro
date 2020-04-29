package com.hr.springboot.mapper;

import com.hr.springboot.domain.AdminRolePermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.BitSet;
import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
public interface AdminRolePermissionMapper extends Mapper<AdminRolePermission> {
    List<AdminRolePermission> findAllByRid(List<Integer> rids);
}
