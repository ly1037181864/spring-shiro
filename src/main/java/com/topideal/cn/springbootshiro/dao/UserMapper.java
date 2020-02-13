package com.topideal.cn.springbootshiro.dao;

import com.topideal.cn.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-13 00:33
 **/
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from User where name=#{name}")
    User findByName(String name);
}
