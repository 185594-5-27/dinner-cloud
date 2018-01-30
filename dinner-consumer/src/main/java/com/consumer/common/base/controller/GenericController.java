package com.consumer.common.base.controller;



import com.consumer.common.base.constant.SystemStaticConst;
import com.consumer.common.base.entity.Page;
import com.consumer.common.base.entity.QueryBase;
import com.consumer.common.base.service.GenericService;
import com.consumer.common.util.json.JsonHelper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class GenericController<T, Q extends QueryBase> {

	// 抽象方法
	protected abstract GenericService<T, Q> getService();


	/**
	 * 功能描述：保存数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> save(T entity) throws Exception{
		return getService().save(entity);
	}

	/**
	 * 功能描述：更新数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> update(T entity)  throws Exception{
		return getService().update(entity);
	}

	/**
	 * 功能描述：实现删除数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/remove",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> remove(T entity) throws Exception{;
		return getService().remove(entity);
	}


	/**
	 * 功能描述：实现批量删除的记录
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/removeBath",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> removeBath(String json) throws Exception{
		return getService().removeBath(json);
	}

	/**
	 * 功能描述：获取分页的数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> list(Q entity){
		return getService().list(entity);
	}

	/**
	 * 功能描述：判断当前的元素是否已经存在
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/isExist",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Object> isExist(Q entity){
		return getService().isExist(entity);
	}

}
