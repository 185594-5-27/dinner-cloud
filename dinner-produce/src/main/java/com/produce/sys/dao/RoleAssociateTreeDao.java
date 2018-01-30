package com.produce.sys.dao;


import com.produce.common.base.dao.GenericDao;
import com.produce.sys.entity.QueryRoleAssociateTree;
import com.produce.sys.entity.RoleAssociateTree;
import com.produce.sys.entity.Tree;
import com.produce.sys.entity.UserRole;

/**
 *@author linzf
 **/
public interface RoleAssociateTreeDao extends GenericDao<RoleAssociateTree, QueryRoleAssociateTree> {

    /**
     * 功能描述：根据菜单ID来删除关联的菜单数据
     * @param tree
     * @return
     */
    int removeTreeByTreeId(Tree tree);

    /**
     * 功能描述：根据角色ID来删除关联的菜单数据
     * @param userRole
     * @return
     */
    int removeTreeByRoleId(UserRole userRole);
	
}