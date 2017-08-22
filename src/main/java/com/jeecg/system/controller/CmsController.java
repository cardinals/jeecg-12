package com.jeecg.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.system.dao.CmsDao;

/**
* @ClassName: CmsController
* @Description: cms
* @author lugang
* @date 2017年8月21日 下午18:30:31
*
*/ 
@Controller
@RequestMapping("/cmsController")
public class CmsController extends BaseController{
	@Autowired
	private CmsDao cmsDao;
	
	@RequestMapping(params="getInfoUrl",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getInfoUrl(HttpServletRequest req){
		String id = req.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map_data = new HashMap<String,Object>();   //data里面放数据       可以是list或者字典   
		try{
			String url=cmsDao.getInfoUrl(id);
			map_data.put("url", url);
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
