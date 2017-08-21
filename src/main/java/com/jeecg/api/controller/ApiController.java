package com.jeecg.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.api.dao.ApiDao;

/**
* @ClassName: ApiController
* @Description: TODO api接口测试
* @author wmm
* @date 2017年8月18日 下午4:22:31
*
*/ 
@Controller
@RequestMapping("/api/v3/indexController")
public class ApiController extends BaseController{
	@Autowired
	private ApiDao apiDao;
	
	@RequestMapping(params="list",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getList(HttpServletRequest req){
		String id = req.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map_data = new HashMap<String,Object>();   //data里面放数据       可以是list或者字典   
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		try{
			List<Map<String, Object>> list=apiDao.getProCity(id);
			if(list != null && list.size() > 0){
				for(Map<String, Object> m : list ){
					Map<String, Object> map_m = new LinkedHashMap<String, Object>();
					map_m.put("phone", m.get("mobilePhone"));
					listMap.add(map_m);
				}
			}
			map_data.put("list", listMap);
			map.put("status", "true");
			map.put("msg", "获取成功");
		}catch (Exception e) {
			map.put("status", "false");
			map.put("msg", "获取失败");
		}
		map.put("data", map_data.size() > 0 ? map_data : "");
		return map;
	}
}
