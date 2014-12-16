package xiao.pageModel.base;

import java.io.Serializable;

public class Json implements Serializable{
	
	//前台返回标识
	private boolean success= false;
	//前台返回信息
	private String msg="";
	//前台返回对象
	private Object obj = null;
	//前台返回URL
	private String url="";
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMsg() {
		return msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	} 
	
	
}
