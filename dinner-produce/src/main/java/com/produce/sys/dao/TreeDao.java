package com.produce.sys.dao;



import com.produce.common.base.dao.GenericDao;
import com.produce.sys.entity.QueryTree;
import com.produce.sys.entity.Tree;
import com.produce.sys.entity.User;

import java.util.List;

/**
 *@author linzf
 **/
public interface TreeDao extends GenericDao<Tree, QueryTree> {

    /**
     * 功能描述：加载用户的菜单树的数据
     * @param user
     * @return
     */
	List<Tree> loadUserTree(User user);
}