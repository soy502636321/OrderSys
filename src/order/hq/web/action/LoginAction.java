package order.hq.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import order.hq.basic.dao.BaseOrganDAO;
import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.database.entity.SysSection;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.ForwardUtil;
import order.hq.util.GlobalUtil;
import order.hq.util.PasswordControl;
import order.hq.web.service.SysUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(LoginAction.class);

	private SysUserService sysUserService;
	private BaseOrganDAO baseOrganDAO;
	private String userPid;
	private String password;
	private String userName;

	// 登录：检查用户名跟密码
	public String login() throws Exception {
		log.debug("登录: 用户名:" + getUserPid() + ",密码:" + getPassword());
		
		// 清除session
		this.getSession().remove(GlobalUtil.LOGINUSER);
		// 查询登录的用户名
		SysUserVO loginSysUserVO = sysUserService.findByPK(getUserPid());
		if (loginSysUserVO == null) {
			addActionError("该用户名不存在，请联系客户！");
			return ForwardUtil.FORWARD_FAIL;
		}
		System.out.println("is equals:");
		System.out.println(PasswordControl.EncryptePassword(getPassword()));
		System.out.println(loginSysUserVO.getPassword());
		if (!PasswordControl.EncryptePassword(getPassword()).equals(
				loginSysUserVO.getPassword())) {
			addActionError("密码不正确！");
			return ForwardUtil.FORWARD_FAIL;
		}

		if (isNull(loginSysUserVO.getUserState())
				|| !loginSysUserVO.getUserState().equals(GlobalUtil.isNormal)) {
			addActionError("该用户已被禁用或未启用！");
			return ForwardUtil.FORWARD_FAIL;
		}

		// 获得客户功能
		if (loginSysUserVO.isAdmin()) {
			log.debug("登录的用户是管理员");
			loginSysUserVO.setFunctionList(sysUserService.findSysFunctionAll());
		} else {
			log.debug("登录的用户是普通用户");
			SysSection sysSection = loginSysUserVO.getSysUser().getSysSection();
			List<SysFunction> sysFunctions = new ArrayList<SysFunction>();
			sysFunctions.addAll(sysSection.getSectionFunctions());
			loginSysUserVO.setFunctionList(sysFunctions);
		}

		// 获得客户的列表
		this.getSession().put(GlobalUtil.MENUSTRING, getMenuStr(loginSysUserVO));
		this.getSession().put(GlobalUtil.LOGINUSER, loginSysUserVO);

		return ForwardUtil.FORWARD_SUCCESS;
	}

	// 退出系统
	public String loginOut() throws Exception {
		// 清除用户登录信息
		this.getSession().remove(GlobalUtil.LOGINUSER);
		return ForwardUtil.FORWARD_LOGIN_PAGE;
	}

	// get menu string
	public String getMenuStr(SysUserVO sysUserVO) {
		String contextPath = this.getRequest().getContextPath();
		String nodes = "";
		for (SysFunction function : sysUserVO.getMenuFunctionList()) {
			String functionPid = function.getFunctionPid();
			String parentPid = "0";
			String functionName = function.getFunctionName();
			if (function.getParent() != null) {
				parentPid = function.getParent().getFunctionPid();
			}
			String url = function.getFunctionUrl();
			String nodeUrl = "";
			if (url != null && !url.equals("")) {
				nodeUrl = ",url:\"" + contextPath + url + "\", target:\"I1\"";
			}
			nodes += "{ id:\"" + String.valueOf(functionPid) + "\", pId:\""
					+ String.valueOf(parentPid) + "\", name:\"" + functionName
					+ "\"" + nodeUrl + "},";
		}

		if (nodes.length() > 0)
			nodes = "[ " + nodes.substring(0, nodes.length() - 1) + " ]";

		return nodes;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public BaseOrganDAO getBaseOrganDAO() {
		return baseOrganDAO;
	}

	public void setBaseOrganDAO(BaseOrganDAO baseOrganDAO) {
		this.baseOrganDAO = baseOrganDAO;
	}

	public String getUserPid() {
		return userPid;
	}

	public void setUserPid(String userPid) {
		this.userPid = userPid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// // get new password by email
	// public String sendPassword() throws Exception{
	//
	// log.debug("login: userId:"+getUserId()+",email:"+getEmail());
	//
	// Userprofile userprofile = userService.login(getUserId());
	// if(userprofile==null){
	// addActionError("用户编号不存在！");
	// return ConstantsForward.FORWARD_LOGIN_PAGE;
	// }
	// // check status
	// if(userprofile.getStatus()==null ||
	// userprofile.getStatus().intValue()!=0){
	// addActionError("该用户状态被禁用或未启用！不能发送邮件！");
	// return ConstantsForward.FORWARD_LOGIN_PAGE;
	// }
	// // check email.
	// if(!getEmail().equalsIgnoreCase(userprofile.getEmail())){
	// addActionError("该用户邮件与系统记录邮件不一致！");
	// return ConstantsForward.FORWARD_LOGIN_PAGE;
	// }
	//
	// // get random number
	// String newPassword = PasswordControl.getNewPassword();
	// String subject = "汇泉翻译 - 找回密码邮件(此邮件由系统自动发出!)";
	// String content = "用户名："+ getUserId() + "\n密码为：" + newPassword
	// + "\n申请时间为: " +DateUtil.getTime();
	// log.debug(content);
	// Mail mail = new Mail();
	// mail.notifyOfficer(getEmail(), subject, content);
	//
	// // save new password
	// userService.updatePassword(getUserId(),
	// PasswordControl.EncryptePassword(newPassword));
	//
	// addActionMessage("发送邮件成功！请去邮箱获取随机密码！");
	//
	// // clear all text filed
	// setUserId("");
	// setPassword("");
	// setEmail("");
	//
	// return ConstantsForward.FORWARD_LOGIN_PAGE;
	// }

}
