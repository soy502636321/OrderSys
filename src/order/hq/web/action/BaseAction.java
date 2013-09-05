package order.hq.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware {
	
	private Map<String, Object> session;
	private HttpServletRequest request;
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public boolean isNull(String obj){
		if(obj == null || obj.equals("")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isNotNull(String obj){
		return !isNull(obj);
	}


}
