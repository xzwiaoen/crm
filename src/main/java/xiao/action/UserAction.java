package xiao.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xiao.model.Tuser;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "userAction", results = {
		@Result(name = "go", location = "/xiao/Test.html")})
public class UserAction extends BaseAction<Tuser>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String go(){
		return "go";
	}
}
