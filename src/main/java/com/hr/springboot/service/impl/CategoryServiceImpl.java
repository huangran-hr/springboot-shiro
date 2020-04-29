package com.hr.springboot.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.CategoryMapper;
import com.hr.springboot.service.CategoryService;
/**
 * @Auther: HR
 * @Date: 2020/4/22 15:08
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

}
