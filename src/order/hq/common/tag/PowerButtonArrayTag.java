package order.hq.common.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class PowerButtonArrayTag extends ComponentTagSupport {
	private String function;
	private String id;
	private List buttons;

	@Override
	public int doStartTag() throws JspException {
		setButtons(new ArrayList());
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		PowerButtonArrayService powerButtonArrayService = (PowerButtonArrayService) getComponent();
		powerButtonArrayService.setButtons(getButtons());
		return super.doEndTag();
	}

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		return new PowerButtonArrayService(stack, request, response);
	}

	@Override
	protected void populateParams() {
		PowerButtonArrayService powerButtonArrayService = (PowerButtonArrayService) getComponent();
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List getButtons() {
		return buttons;
	}

	public void setButtons(List buttons) {
		this.buttons = buttons;
	}
}
