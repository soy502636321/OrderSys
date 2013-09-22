package order.hq.common.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import order.hq.util.StringUtil;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class PowerButtonTag extends ComponentTagSupport {

	private String name;
	private String js;
	private String url;
	private String id;
	private String mode;
	private String location;
	private String type;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		return new PowerButtonService(stack, request, response);
	}

	@Override
	protected void populateParams() {
		PowerButtonService powerButtonService = (PowerButtonService) getComponent();
		PowerButtonArrayTag powerButtonArrayTag = (PowerButtonArrayTag) getParent();
		powerButtonService.setParentId(powerButtonArrayTag.getFunction());
		powerButtonService.setId(getId());
		powerButtonService.setName(getName());
		powerButtonService.setJs(getJs());
		powerButtonService.setUrl(getUrl());
		powerButtonService.setMode(getMode());
		powerButtonService.setLocation(getLocation());
		powerButtonService.setType(getType());
	}

	@Override
	public int doEndTag() throws JspException {
		PowerButtonService powerButtonService = (PowerButtonService) getComponent();
//		ButtonsTag buttonsTag = (ButtonsTag) getParent();
		PowerButtonArrayTag powerButtonArrayTag = (PowerButtonArrayTag) getParent();
		if (!StringUtil.isNull(powerButtonService.getResult())) {
			powerButtonArrayTag.getButtons().add(powerButtonService);
		}
		return super.doEndTag();
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
