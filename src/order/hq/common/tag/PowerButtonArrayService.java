package order.hq.common.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.hq.util.StringUtil;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class PowerButtonArrayService extends Component {
	private String function;
	private String id;
	private List buttons;

	public PowerButtonArrayService(ValueStack stack) {
		super(stack);
	}

	public PowerButtonArrayService(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack);
	}

	@Override
	public boolean start(Writer writer) {
		StringBuffer start = new StringBuffer("<table ");
		if (!StringUtil.isNull(getId())) {
			start.append("id=\"").append(getId()).append("\" ");
		}
		if (!StringUtil.isNull(getFunction())) {
			start.append("function=\"").append(getFunction()).append("\" ");
		}
		start.append(">");
		try {
			writer.write(start.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.start(writer);
	}

	@Override
	public boolean end(Writer writer, String body) {
		StringBuffer end = new StringBuffer();
		int i = getButtons().size();

		int count = (i / 9) + 1;
		for (int j = 0; j < count; j++) {
			end.append("<tr>");
			for (int k = (j * 9); k < (j * 9 + 9); k++) {
				if (k < i) {
					PowerButtonService powerButtonService = (PowerButtonService) getButtons().get(k);
					end.append(powerButtonService.getResult());
				}
			}
			end.append("</tr>");
			end.append("</table>");
		}
		try {
			writer.write(end.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.end(writer, body);
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
