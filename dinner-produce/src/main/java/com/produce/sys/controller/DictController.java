package com.produce.sys.controller;


import com.base.entity.Dict;
import com.base.entity.QueryDict;
import com.produce.common.base.constant.SystemStaticConst;
import com.produce.common.base.controller.GenericController;
import com.produce.common.base.service.GenericService;
import com.produce.common.util.dict.DictCache;
import com.produce.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 类描述：
* @auther linzf
* @create 2017/10/9 0009 
*/
@RestController
@RequestMapping("/dict")
public class DictController extends GenericController<Dict,QueryDict> {

    @Autowired
    private DictService dictService;

    @Override
    protected GenericService getService() {
        return dictService;
    }

    /**
     * 功能描述：将字典数据初始化到前端js中
     * @return
     */
    @RequestMapping(value = "/loadDict",method = RequestMethod.POST)
    public Map<String,Object> loadDict(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Dict> dictList = dictService.query(new QueryDict("1"));
        result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
        result.put("data",dictList);
        return result;
    }

    /**
     * 功能描述：重新加载数据字典的数据到内存中
     * @return
     */
    @RequestMapping(value = "/reload",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> reload(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Dict> dictList = dictService.query(null);
        DictCache.reload(dictList);
        result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG,"重新加载数据字典成功！");
        return result;
    }


}
