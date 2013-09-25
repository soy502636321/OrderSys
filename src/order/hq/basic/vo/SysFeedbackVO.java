package order.hq.basic.vo;

import order.hq.basic.database.entity.SysFeedback;
import order.hq.basic.database.entity.SysOrder;

public class SysFeedbackVO {
	private SysFeedback sysFeedback;

	private String feedbackPid;
	private String remark;

	private SysOrder sysOrder;
	private String sysOrderPid;

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

	public SysOrder getSysOrder() {
		if (getSysFeedback() != null && sysOrder == null) {
			sysOrder = getSysFeedback().getSysOrder();
		}
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public String getSysOrderPid() {
		if (getSysOrder() != null && sysOrderPid == null) {
			sysOrderPid = getSysOrder().getOrderPid();
		}
		return sysOrderPid;
	}

	public void setSysOrderPid(String sysOrderPid) {
		this.sysOrderPid = sysOrderPid;
	}

}
