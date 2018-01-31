package com.dinner.entity;

import java.io.Serializable;

/**
 *@author linzf
 **/
public class UserRole implements Serializable {

	private static final long serialVersionUID = -7314462528191718525L;

	private long id;
	private String name;
	private String roleName;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
