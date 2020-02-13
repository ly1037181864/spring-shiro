package com.topideal.cn.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-12 23:05
 **/
@Controller
public class UserController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("UserController.hello");
        return "ok";
    }

    @RequestMapping("/add")
    @RequiresPermissions({"user:add"})
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    @RequiresPermissions({"user:update"})
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/noAuth";
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name","黑马程序员");
        return "test";
    }

    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        Subject subject =
                SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try{
            subject.login(token);
            return "redirect:/testThymeleaf";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
