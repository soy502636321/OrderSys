package order.hq.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

public class SysFeedback {
	private String feedbackPid;
	private String remark;

	private SysOrder sysOrder;
	private ConfigSysFeedbackState state;
	private Set translatedFiles = new HashSet(0);

	public String getFeedbackPid() {
		return feedbackPid;
	}

	public void setFeedbackPid(String feedbackPid) {
		this.feedbackPid = feedbackPid;
	}

	public SysOrder getSysOrder() {
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public ConfigSysFeedbackState getState() {
		return state;
	}

	public void setState(ConfigSysFeedbackState state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTranslatedFiles() {
		return translatedFiles;
	}

	public void setTranslatedFiles(Set translatedFiles) {
		this.translatedFiles = translatedFiles;
	}

	
}
