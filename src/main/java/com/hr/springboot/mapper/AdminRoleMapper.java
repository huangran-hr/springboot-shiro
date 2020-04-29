package com.hr.springboot.mapper;

import com.hr.springboot.domain.AdminRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:42
 * @Description:
 */
public interface AdminRoleMapper extends Mapper<AdminRole> {
    List<AdminRole> selectRolesByIds(List<Integer> rids);
}
