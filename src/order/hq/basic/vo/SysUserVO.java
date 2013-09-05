package order.hq.basic.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.database.entity.SysSection;
import order.hq.basic.database.entity.SysUser;
import order.hq.util.GlobalUtil;
import order.hq.util.PropsParser;

public class SysUserVO {
	// 管理员
	public static final String SYSTEMADMIN = "SYSTEM_ADMIN";

	// 用户信息
	private SysUser sysUser;
	// 用户功能集合
	private List<SysFunction> functionList;
	// 用户列表集合
	private List<SysFunction> menuFunctionList;
	// 用户非列表功能集合
	private List<SysFunction> otherFunctionList;

	private String userPid;
	private SysSection sysSection;
	private String userName;
	private String password;
	private String userState;
	private String fastnessTel;
	private String mobileTel;
	private String ipArea;
	private String email;
	private String emailPassword;
	private String emailFooter;
	private String remark;

	public SysUserVO() {
	}

	public SysUserVO(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	/**
	 * 是否是管理员
	 */
	public boolean isAdmin() {
		try {
			Properties props = PropsParser.getProperties();
			if (getSysUser().getUserPid()
					.equals(props.getProperty(SYSTEMADMIN))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void setFunctionList(List<SysFunction> functionList) {
		this.functionList = functionList;
		// 初始化功能集合
		menuFunctionList = new ArrayList<SysFunction>();
		otherFunctionList = new ArrayList<SysFunction>();
		for (SysFunction function : functionList) {
			if (GlobalUtil.isMenu.equals(function.getFunctionType())) {
				menuFunctionList.add(function);
			} else {
				otherFunctionList.add(function);
			}

		}
	}

	public List<SysFunction> getFunctionList() {
		return functionList;
	}

	public List<SysFunction> getMenuFunctionList() {
		return menuFunctionList;
	}

	public List<SysFunction> getOtherFunctionList() {
		return otherFunctionList;
	}

	public void setMenuFunctionList(List<SysFunction> menuFunctionList) {
		this.menuFunctionList = menuFunctionList;
	}

	public void setOtherFunctionList(List<SysFunction> otherFunctionList) {
		this.otherFunctionList = otherFunctionList;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getUserPid() {
		return userPid;
	}

	public void setUserPid(String userPid) {
		this.userPid = userPid;
	}

	public SysSection getSysSection() {
		return sysSection;
	}

	public void setSysSection(SysSection sysSection) {
		this.sysSection = sysSection;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getFastnessTel() {
		return fastnessTel;
	}

	public void setFastnessTel(String fastnessTel) {
		this.fastnessTel = fastnessTel;
	}

	public String getMobileTel() {
		return mobileTel;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public String getIpArea() {
		return ipArea;
	}

	public void setIpArea(String ipArea) {
		this.ipArea = ipArea;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getEmailFooter() {
		return emailFooter;
	}

	public void setEmailFooter(String emailFooter) {
		this.emailFooter = emailFooter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
