package com.dinner.controller;

import com.base.entity.Dict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dict")
public class DictController {


    @RequestMapping(value = "/updatePage",method = RequestMethod.GET)
    public String updatePage(Dict entity,Model model){
        model.addAttribute("entity",entity);
        return "/sys/dict/update";
    }

}
