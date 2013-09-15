package order.hq.basic.database.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SysOrder {
	private String orderPid; // 订单主键
	private String orderNo; // 订单编号
	private BaseLanguage startLanguage; // 原文语种
	private BaseLanguage endLanguage; // 译文语种

	private Date submitTime; // 交稿时间
	private Date operTime = new Date(); // 订单增加时间
	private SysUser operUser; // 订单增加人

	private SysShow sysShow;
	private Set masterFiles = new HashSet(0);
	private Set translatedFiles = new HashSet(0);
	private Set feedbacks = new HashSet(0);

	// 虚拟字段
	private int baseMasterFileCount;

	private ConfigSysOrderState orderState;

	public String getOrderPid() {
		return orderPid;
	}

	public void setOrderPid(String orderPid) {
		this.orderPid = orderPid;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public SysUser getOperUser() {
		return operUser;
	}

	public void setOperUser(SysUser operUser) {
		this.operUser = operUser;
	}

	public ConfigSysOrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(ConfigSysOrderState orderState) {
		this.orderState = orderState;
	}

	public BaseLanguage getStartLanguage() {
		return startLanguage;
	}

	public void setStartLanguage(BaseLanguage startLanguage) {
		this.startLanguage = startLanguage;
	}

	public BaseLanguage getEndLanguage() {
		return endLanguage;
	}

	public void setEndLanguage(BaseLanguage endLanguage) {
		this.endLanguage = endLanguage;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getBaseMasterFileCount() {
		return baseMasterFileCount;
	}

	public void setBaseMasterFileCount(int baseMasterFileCount) {
		this.baseMasterFileCount = baseMasterFileCount;
	}

	public Set getMasterFiles() {
		return masterFiles;
	}

	public void setMasterFiles(Set masterFiles) {
		this.masterFiles = masterFiles;
	}

	public Set getTranslatedFiles() {
		return translatedFiles;
	}

	public void setTranslatedFiles(Set translatedFiles) {
		this.translatedFiles = translatedFiles;
	}

	public SysShow getSysShow() {
		return sysShow;
	}

	public void setSysShow(SysShow sysShow) {
		this.sysShow = sysShow;
	}

	public Set getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set feedbacks) {
		this.feedbacks = feedbacks;
	}

}
