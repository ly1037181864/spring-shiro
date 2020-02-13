package com.topideal.cn.springbootshiro.shiro;

import com.topideal.cn.springbootshiro.entity.User;
import com.topideal.cn.springbootshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-12 23:17
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User)principalCollection.getPrimaryPrincipal();
        info.addStringPermission(user.getPermissions());
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.findByName(token.getUsername());
        if(user == null) return null;
        return new SimpleAuthenticationInfo(user,user.getPassword(),"userRealm");
    }
}
