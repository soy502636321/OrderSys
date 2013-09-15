package order.hq.basic.database.entity;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private String userPid;
	private SysSection sysSection;
	private String userName;
	private String password;
	private String userState;
	private String custNo;
	private String fastnessTel;
	private String mobileTel;
	private String ipArea;
	private String email;
	private String emailPassword;
	private String emailFooter;
	private String remark;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	// Property accessors

	public SysSection getSysSection() {
		return this.sysSection;
	}

	public void setSysSection(SysSection sysSection) {
		this.sysSection = sysSection;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getFastnessTel() {
		return this.fastnessTel;
	}

	public void setFastnessTel(String fastnessTel) {
		this.fastnessTel = fastnessTel;
	}

	public String getMobileTel() {
		return this.mobileTel;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public String getIpArea() {
		return this.ipArea;
	}

	public void setIpArea(String ipArea) {
		this.ipArea = ipArea;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailPassword() {
		return this.emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getEmailFooter() {
		return this.emailFooter;
	}

	public void setEmailFooter(String emailFooter) {
		this.emailFooter = emailFooter;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserPid() {
		return userPid;
	}

	public void setUserPid(String userPid) {
		this.userPid = userPid;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

}