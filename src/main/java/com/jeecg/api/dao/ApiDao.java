package com.jeecg.api.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface ApiDao {
	
	@Arguments("id")
 	@Sql("select * from t_s_user where id=:id ")
    List<Map<String, Object>> getProCity(String id);

}
