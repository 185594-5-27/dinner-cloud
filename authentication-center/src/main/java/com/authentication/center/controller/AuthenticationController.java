package com.authentication.center.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* 类描述：鉴权中心业务处理类controller
* @auther linzf
* @create 2018/1/24 0024
*/
@RestController
public class AuthenticationController {

    @RequestMapping(value = "/identify", method= RequestMethod.POST)
    public String identify(String token){
        System.out.println("鉴权中心收到的token的值是："+token);
        return token;
    }

}
