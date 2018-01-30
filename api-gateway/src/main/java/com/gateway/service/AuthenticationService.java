package com.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
* 类描述：
* @auther linzf
* @create 2018/1/24 0024 
*/
@FeignClient(value="AUTHENTICATION-SERVICE")
public interface AuthenticationService {


    /**
     * 功能描述：调用生产者端的轨迹处理方法
     * @param token
     */
    @RequestMapping(value = "/identify" ,method = RequestMethod.POST)
    String identify(@RequestParam("token") String token);

}
