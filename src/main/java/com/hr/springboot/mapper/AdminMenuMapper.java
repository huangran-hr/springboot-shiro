package com.hr.springboot.mapper;

import com.hr.springboot.domain.AdminMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.BitSet;
import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/26 17:35
 * @Description:
 */
public interface AdminMenuMapper extends Mapper<AdminMenu> {
    List<AdminMenu> findAllById(List<Integer> menuIds);
}
