package xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xiao.dao.UserDaoI;
import xiao.model.Tuser;
import xiao.service.UserServiceI;

@Service(value="userService")
public class UserServiceImpl implements UserServiceI{
	private UserDaoI userDao;
	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Override
	public void say() {
		System.out.println("测试成功了！");
	}

	@Override
	public void save(Tuser t) {
		userDao.save(t);
	}
	
	
}
