package com.produce.common.util.user;



import com.produce.common.util.node.NodeUtil;
import com.produce.sys.entity.Tree;
import com.produce.sys.entity.User;
import com.produce.sys.service.TreeService;

import java.util.*;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class UserInfo {


    /**
     * 功能描述：加载菜单节点的数据
     * @return
     */
    public static List<Tree> loadUserTree(TreeService treeService, User user){
        Map<Long,Tree> treeMap = new HashMap<Long,Tree>();
        for(Tree tree:treeService.loadUserTree(user)){
            treeMap.put(tree.getId(),tree);
        }
        List<Tree> treeList = NodeUtil.getChildNodes(new ArrayList<Tree>(treeMap.values()),0l);
        return treeList;
    }





}
