package com.topideal.cn.springbootshiro.service.impl;

import com.topideal.cn.springbootshiro.dao.UserMapper;
import com.topideal.cn.springbootshiro.entity.User;
import com.topideal.cn.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-13 00:39
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
