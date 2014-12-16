package xiao.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import xiao.pageModel.base.Json;
import xiao.service.InitServiceI;


/**
 * 初始化数据库使用
 * 
 * @author 孙宇
 * 
 */
@ParentPackage("basePackage")
@Namespace("/")
@Action
public class InitAction extends BaseAction {

	@Autowired
	private InitServiceI service;

	synchronized public void doNotNeedSessionAndSecurity_initDb() {
		Json j = new Json();
		service.initDb();
		j.setSuccess(true);
		writeJson(j);

		if (getSession() != null) {
			getSession().invalidate();
		}
	}

}
