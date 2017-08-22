package com.jeecg.system.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface CmsDao {
	
	@Arguments({"info_url", "id"})
 	@Sql("update app_information set info_url=:info_url where id=:id ")
    int updateInfoUrl(String info_url,String id);
	
	@Arguments("id")
 	@Sql("select info_url from app_information where id=:id ")
    String getInfoUrl(String id);

}
