package com.dinner.sys.controller;

import com.base.entity.Dict;
import com.dinner.common.config.base.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dict")
public class DictController extends GenericController<Dict> {

}
