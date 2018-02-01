package com.consumer.sys.controller;

import com.base.entity.QueryTree;
import com.base.entity.Tree;
import com.consumer.common.base.controller.GenericController;
import com.consumer.common.base.service.GenericService;
import com.consumer.sys.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tree")
public class TreeController  extends GenericController<Tree,QueryTree> {

    @Autowired
    private TreeService treeService;

    @Override
    protected GenericService<Tree, QueryTree> getService() {
        return treeService;
    }

    /**
     * 功能描述：加载首页菜单节点的数据
     * @return
     */
    @RequestMapping(value = "/mainTree",method = RequestMethod.POST)
    public Map<String,Object> mainTree(String token){
        return treeService.mainTree(token);
    }
}
