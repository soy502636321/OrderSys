package order.hq.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import order.hq.basic.vo.SysUserVO;
import order.hq.util.GlobalUtil;
import order.hq.util.PaginatedList;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private Map<String, Object> session;
	private HttpServletRequest request;

	private PaginatedList paginatedList;
	private int page = 1;
	private String[] cbId;

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

	public SysUserVO getLoginVO() {
		SysUserVO sysUserVO = (SysUserVO) getSession()
				.get(GlobalUtil.LOGINUSER);
		return sysUserVO;
	}

	public PaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(PaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String[] getCbId() {
		return cbId;
	}

	public void setCbId(String[] cbId) {
		this.cbId = cbId;
	}

}
