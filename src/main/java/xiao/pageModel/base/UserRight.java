/**
 * UserRight.java
 * 功能：存储系统内所有权限的请求和权限ID的对象
 * 类名：UserRight
 * 版本：V1.0 2011-04-01 南磊 添加
 * Copyright(c) 2011 Nanlei All Rights Reserved
 */
package xiao.pageModel.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 在权限控制拦截器中获取Spring容器中的该类的实例，通过其中的属性来获取权限信息
 * 
 * @author Nanlei
 * @version 1.0
 * @since hztraining-oa 1.0
 * 
 */
public class UserRight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 系统内的权限
	private List<Map<String, String>> rights;
	// 可以忽略的Action请求
	private List<String> ignoreActions;

	public List<Map<String, String>> getRights() {
		return rights;
	}

	public void setRights(List<Map<String, String>> rights) {
		this.rights = rights;
	}

	public List<String> getIgnoreActions() {
		return ignoreActions;
	}

	public void setIgnoreActions(List<String> ignoreActions) {
		this.ignoreActions = ignoreActions;
	}

}
