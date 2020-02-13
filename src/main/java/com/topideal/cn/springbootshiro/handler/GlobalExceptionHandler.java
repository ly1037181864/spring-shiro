package com.topideal.cn.springbootshiro.handler;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-13 11:21
 **/
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    /**
     * 解决未授权错误的第二种方案，通过定义全局的异常来捕获并重定向到未授权提示页面
     * @param e
     * @param response
     * @throws IOException
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void credentials(UnauthorizedException e, HttpServletResponse response) throws IOException {
        response.sendRedirect("/noAuth");
    }

}
