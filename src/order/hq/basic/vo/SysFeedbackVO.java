package order.hq.basic.vo;

import order.hq.basic.database.entity.SysFeedback;

public class SysFeedbackVO {
	private SysFeedback sysFeedback;

	private String feedbackPid;
	private String remark;

	public SysFeedbackVO() {
	}

	public SysFeedbackVO(SysFeedback sysFeedback) {
		this.sysFeedback = sysFeedback;
	}

	public SysFeedback getSysFeedback() {
		return sysFeedback;
	}

	public void setSysFeedback(SysFeedback sysFeedback) {
		this.sysFeedback = sysFeedback;
	}

	public String getFeedbackPid() {
		if (getSysFeedback() != null && feedbackPid == null) {
			feedbackPid = getSysFeedback().getFeedbackPid();
		}
		return feedbackPid;
	}

	public void setFeedbackPid(String feedbackPid) {
		this.feedbackPid = feedbackPid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
