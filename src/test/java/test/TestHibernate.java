package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xiao.model.Tuser;
import xiao.service.UserServiceI;


public class TestHibernate {
	@Test
	public void test(){
		 ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml","classpath:spring-hibernate.xml"});
		 UserServiceI userService = (UserServiceI) ac.getBean("userService");
	 	 Tuser user=new Tuser();
	 	 user.setRealname("老肖来也");
	 	 userService.save(user);
	}
}
