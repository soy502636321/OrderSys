package order.hq.common.tag;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.GlobalUtil;
import order.hq.util.StringUtil;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class PowerButtonService extends Component {
	private int index;
	private String name;
	private String js;
	private String url;
	private String id;
	private String parentId;
	private String mode;
	private String location;
	private String type;
	private String result;

	private HttpServletRequest request;
	private HttpServletResponse response;

	public PowerButtonService(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack);
		this.request = request;
		this.response = response;
	}

	@Override
	public boolean start(Writer writer) {
		SysUserVO userVO = (SysUserVO) request.getSession().getAttribute(GlobalUtil.LOGINUSER);
		List<SysFunction> functions = userVO.getFunctionList();
		//获得登录除菜单之外的所有功能
		List<SysFunction> otherFunctionList = userVO.getOtherFunctionList();
		boolean b = false;
		SysFunction parent = null;
		for (SysFunction function : functions) {
			if (function.getFunctionPid().toString().equals(getParentId())) {
				parent = function;
				b = true;
			}
		}
		if (b) {
			functions = new ArrayList<SysFunction>();
			functions.addAll(parent.getChildren());

			for (SysFunction child : functions) {
				if ((child.getFunctionName().equals(getName()) && otherFunctionList.contains(child)) 
						|| "close".equals(getMode()) || "reset".equals(getType())) {
					StringBuffer start = new StringBuffer();
					start.append("<td>").append("<input ");
					// 判断按钮类型，默认是submit
					if (StringUtil.isNull(getType())) {
						start.append("type=\"submit\" ");
					} else {
						if ("reset".equals(getType())) {
							start.append("type=\"reset\" value=\"重  置\" onclick=\"return true;\" ");
						} else {
							start.append("type=\"").append(getType())
									.append("\" ");
						}
					}

					if (!StringUtil.isNull(getName())) {
						start.append("value=\"").append(getName())
								.append("\" ");
					}

					// 判断按钮处理方式
					if (!StringUtil.isNull(getMode())) {
						if ("dialog".equals(getMode())) {
							// 预留处理
						} else if ("close".equals(getMode())) {
							// 关闭按钮
							start.append("onclick=\"return closeWindow(this);\" value=\"关  闭\" ");
						} else if ("single".equals(getMode())) {
							// 至少选择一条记录操作
							if ("this".equals(getLocation())) {
								start.append("onclick=\"return powerSingleSelect(this)\" ");
							} else {
								start.append("onclick=\"return powerSingleSelect(this, true)\" ");
							}
						} else if ("more".equals(getMode())) {
							if ("this".equals(getLocation())) {
								start.append("onclick=\"return powerMoreSelect(this)\" ");
							} else {
								start.append("onclick=\"return powerMoreSelect(this, true)\" ");
							}
						} else if ("all".equals(getMode())) {
							if ("this".equals(getLocation())) {
								start.append("onclick=\"return openThis(this);\" ");
							} else {
								start.append("onclick=\"return openBlank(this);\" ");
							}
						} else if ("del".equals(getMode())) {
							start.append("onclick=\"return deleteDialog(this);\"");
						} else if ("clear".equals(getMode())) {
							start.append("oncilck=\"return clrearForm(this);\"");
						}
					}
					if (!StringUtil.isNull(child.getFunctionUrl())) {
						start.append("name=\"action:")
								.append(child.getFunctionUrl()).append("\" ");
					}

					start.append(" /></td>");
					setResult(start.toString());
				}
			}
		}
		return super.start(writer);
	}

	@Override
	public boolean end(Writer writer, String body) {
		return super.end(writer, body);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
