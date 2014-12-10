package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xiao.service.UserServiceI;

public class TestSpring {

	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml","classpath:spring-hibernate.xml"});
		UserServiceI userService = (UserServiceI)ac.getBean("userService");
		userService.say();
	}

}
