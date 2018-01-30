package com.produce.sys.controller;


import com.produce.common.base.constant.SystemStaticConst;
import com.produce.common.base.controller.GenericController;
import com.produce.common.base.service.GenericService;
import com.produce.common.util.user.UserInfo;
import com.produce.sys.entity.QueryTree;
import com.produce.sys.entity.Tree;
import com.produce.sys.entity.User;
import com.produce.sys.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 类描述：菜单操作controller
* @auther linzf
* @create 2017/10/10 0010 
*/
@Controller
@RequestMapping("/tree")
public class TreeController extends GenericController<Tree,QueryTree> {

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
    @RequestMapping(value="/mainTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> mainTree(String token){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Tree> trees = UserInfo.loadUserTree(treeService,UserInfo.getUser(token));
        result.put("data",trees);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        return null;
    }


    /**
     * 功能描述：直接加载整个菜单树的数据(且必须要有管理员权限才可以加载该菜单树的数据)
     * @return
     */
    @RequestMapping(value = "/loadUserTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> loadUserTree(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Tree> treeList = treeService.query(null);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG,"加载菜单数据成功！");
        result.put("data",treeList);
        return result;
    }


}