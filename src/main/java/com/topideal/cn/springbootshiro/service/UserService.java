package com.topideal.cn.springbootshiro.service;

import com.topideal.cn.springbootshiro.entity.User;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-13 00:38
 **/
public interface UserService {

    User findByName(String name);
}
