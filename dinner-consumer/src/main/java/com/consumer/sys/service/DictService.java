package com.consumer.sys.service;

import com.consumer.common.base.service.GenericService;
import com.consumer.common.config.FullLogConfiguration;
import com.consumer.sys.entity.Dict;
import com.consumer.sys.entity.QueryDict;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@FeignClient(value="DINNER-PRODUCE",configuration = FullLogConfiguration.class,path = "/dict")
public interface DictService extends GenericService<Dict,QueryDict> {

    /**
     * 功能描述：将字典数据初始化到前端js中
     * @return
     */
    @RequestMapping(value = "/loadDict",method = RequestMethod.POST)
    Map<String,Object> loadDict();



}
