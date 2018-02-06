package com.dinner.sys.controller;

import com.base.entity.UserRole;
import com.dinner.common.config.base.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 类描述：
* @auther linzf
* @create 2018/2/6 0006 
*/
@Controller
@RequestMapping("/role")
public class RoleController  extends GenericController<UserRole> {
}
