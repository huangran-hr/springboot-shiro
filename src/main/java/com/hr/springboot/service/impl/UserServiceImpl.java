package com.hr.springboot.service.impl;

import com.hr.springboot.domain.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.UserMapper;
import com.hr.springboot.service.UserService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/23 10:44
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean isExist(String username) {
        Example e = new Example(User.class);
        e.createCriteria().andEqualTo("username",username);
        List<User> users = userMapper.selectByExample(e);
        if(users != null && users.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public User getByUserName(String userName) {
        Example e = new Example(User.class);
        e.createCriteria().andEqualTo("username",userName);
        return userMapper.selectOneByExample(e);
    }

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }
}
