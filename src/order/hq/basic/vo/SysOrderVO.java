package order.hq.basic.vo;

import java.util.Date;

import order.hq.basic.database.entity.BaseLanguage;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.database.entity.SysUser;

public class SysOrderVO {
	private SysOrder sysOrder;

	private String orderPid; // 订单主键
	private String orderNo; // 订单编号
	private BaseLanguage startLanguage; // 原文语种
	private BaseLanguage endLanguage; // 译文语种

	private Date submitTime; // 交稿时间
	private Date operTime = new Date(); // 订单增加时间
	private SysUser operUser; // 订单增加人
	private int baseMasterFileCount;

	public SysOrderVO() {
	}

	public SysOrderVO(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public SysOrder getSysOrder() {
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public String getOrderPid() {
		if (getSysOrder() != null && orderPid == null) {
			orderPid = getSysOrder().getOrderPid();
		}
		return orderPid;
	}

	public void setOrderPid(String orderPid) {
		this.orderPid = orderPid;
	}

	public String getOrderNo() {
		if (getSysOrder() != null && orderNo == null) {
			orderNo = getSysOrder().getOrderNo();
		}
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOperTime() {
		if (getSysOrder() != null && operTime == null) {
			operTime = getSysOrder().getOperTime();
		}
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public SysUser getOperUser() {
		if (getSysOrder() != null && operUser == null) {
			operUser = getSysOrder().getOperUser();
		}
		return operUser;
	}

	public void setOperUser(SysUser operUser) {
		this.operUser = operUser;
	}

	public BaseLanguage getStartLanguage() {
		if (getSysOrder() != null && startLanguage == null) {
			startLanguage = getSysOrder().getStartLanguage();
		}
		return startLanguage;
	}

	public void setStartLanguage(BaseLanguage startLanguage) {
		this.startLanguage = startLanguage;
	}

	public BaseLanguage getEndLanguage() {
		if (getSysOrder() != null && endLanguage == null) {
			endLanguage = getSysOrder().getEndLanguage();
		}
		return endLanguage;
	}

	public void setEndLanguage(BaseLanguage endLanguage) {
		this.endLanguage = endLanguage;
	}

	public Date getSubmitTime() {
		if (getSysOrder() != null && submitTime == null) {
			submitTime = getSysOrder().getSubmitTime();
		}
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getBaseMasterFileCount() {
		if (getSysOrder() != null) {
			baseMasterFileCount = getSysOrder().getBaseMasterFileCount();
		}
		return baseMasterFileCount;
	}

	public void setBaseMasterFileCount(int baseMasterFileCount) {
		this.baseMasterFileCount = baseMasterFileCount;
	}

}
