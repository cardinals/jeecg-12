package com.jeecg.javainter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.online.util.FreemarkerHelper;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jeecg.system.dao.CmsDao;

import test.CreateFileUtil;

@Service("appInfoInter")
public class AppInfoInterServiceImpl implements CgformEnhanceJavaInter {
	@Autowired
	private CmsDao cmsDao;
	
	@Override
	public void execute(String tableName, Map map) throws BusinessException {
		// TODO Auto-generated method stub
		FreemarkerHelper viewEngine = new FreemarkerHelper();
		String id=map.get("id").toString();
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("info_content", map.get("info_content"));
		paras.put("info_title", map.get("info_title"));
		paras.put("create_name", map.get("create_name"));
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		String create_date=datetimeFormat.format(map.get("create_date"));
		paras.put("create_date", create_date);
		String content = viewEngine.parseTemplate("cms/template/content.ftl", paras);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String realPath=request.getSession().getServletContext().getRealPath("/");
		String url="cms/static";
		//创建目录
		String dirName=realPath+url;
        CreateFileUtil.createDir(dirName);
        //创建文件
        String fileName = dirName + "/"+id+".html";
        CreateFileUtil.createFile(fileName);
		File file = new File(fileName);
		try (FileOutputStream fop = new FileOutputStream(file)) {
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//更新静态cms地址
		cmsDao.updateInfoUrl(url+"/"+id+".html", id);
		
	}

}
