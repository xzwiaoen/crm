package xiao.dao.impl;

import org.springframework.stereotype.Repository;

import xiao.dao.UserDaoI;
import xiao.model.Tuser;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Tuser> implements UserDaoI{

}
