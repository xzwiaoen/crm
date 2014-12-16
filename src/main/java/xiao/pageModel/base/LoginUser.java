/**
 * LoginUser.java
 * 功能：用于放置到HttpSession中的用户登录对象
 * 类名：LoginUser
 * 版本：V1.0 2011-03-31 南磊 添加
 * Copyright(c) 2011 Nanlei All Rights Reserved
 */
package xiao.pageModel.base;

import java.io.Serializable;
import java.util.List;

/**
 * 用户登录后在HttpSession中保存的对象，和持久化对象区分开。<br>
 * 仅保存id，用户名，真实名和权限列表和其它用到的属性，内存占用小。
 * 
 * @author Nanlei
 * @version 1.0
 * @since hztraining-oa 1.0
 * 
 */
public class LoginUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户ID，对应数据库中的记录
	private Integer id;
	// 用户登录名，对应数据库中的记录
	private String userName;
	// 用户的真实姓名，用于后台信息显示
	private String realName;
	// 用户的权限列表，用于权限判断
	private List<String> rightList;
	// 用户的职位
	private String position;
	//用户的部门
	private String dept;
	//用户的流程角色
	//private String actRole;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 设置用户所拥有的权限，在登录操作时设置
	 * 
	 * @param rightList
	 *            权限列表
	 */
	public void setRightList(List<String> rightList) {
		this.rightList = rightList;
	}
	
	
	public List<String> getRightList() {
		return rightList;
	}

	/**
	 * 判断用户是否拥有某权限
	 * 
	 * @param rightId
	 *            权限ID
	 * @return true 拥有该权限 <br>
	 *         false 没有权限
	 */
	public boolean hasRight(String rightId) {
		return rightList.indexOf(Integer.valueOf(rightId)) >= 0;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
