package com.hr.springboot.mapper;

import com.hr.springboot.domain.AdminPermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/29 10:47
 * @Description:
 */
public interface AdminPermissionMapper extends Mapper<AdminPermission> {
    List<AdminPermission> findAllById(List<Integer> pids);
}
