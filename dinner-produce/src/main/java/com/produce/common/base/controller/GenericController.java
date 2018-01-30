package com.produce.common.base.controller;


import com.produce.common.base.constant.SystemStaticConst;
import com.produce.common.base.entity.Page;
import com.produce.common.base.entity.QueryBase;
import com.produce.common.base.service.GenericService;
import com.produce.common.util.json.JsonHelper;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class GenericController<T, Q extends QueryBase> {

	// 抽象方法
	protected abstract GenericService<T, Q> getService();


	/**
	 * 功能描述：保存数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public Map<String,Object> save(@RequestBody T entity) throws Exception{
		boolean success = getService().save(entity);
		Map<String,Object> result = new HashMap<String, Object>();
		if(success==true){
			result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG,"增加数据成功！");
			result.put("entity",entity);
		}else{
			result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG,"增加数据失败！");
		}
		return result;
	}

	/**
	 * 功能描述：更新数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Map<String,Object> update(@RequestBody T entity)  throws Exception{
		boolean success  = getService().update(entity);
		Map<String,Object> result = new HashMap<String, Object>();
		if(success==true){
			result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG,"更新数据成功！");
			result.put("entity",entity);
		}else{
			result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG,"更新数据失败！");
		}
		return result;
	}

	/**
	 * 功能描述：实现删除数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	public Map<String,Object> remove(@RequestBody T entity) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		getService().delete(entity);
		result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
		result.put(SystemStaticConst.MSG,"删除数据成功！");
		return result;
	}


	/**
	 * 功能描述：实现批量删除的记录
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/removeBath",method = RequestMethod.POST)
	public Map<String,Object> removeBath(String json) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		getService().removeBath((List<T>) JsonHelper.toList(json,(Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		result.put(SystemStaticConst.MSG,"删除数据成功！");
		return result;
	}

	/**
	 * 功能描述：获取分页的数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public Map<String,Object> list(@RequestBody Q entity){
		Map<String,Object> result = new HashMap<String, Object>();
		Page page = getService().findByPage(entity);
		result.put("totalCount",page.getTotal());
		result.put("result",page.getRows());
		return result;
	}

	/**
	 * 功能描述：判断当前的元素是否已经存在
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/isExist",method = RequestMethod.POST)
	public Map<String,Object> isExist(@RequestBody Q entity){
		Map<String,Object> result = new HashMap<String, Object>();
		if(getService().query(entity).size()>0){
			result.put("valid",false);
		}else{
			result.put("valid",true);
		}
		return result;
	}

}
