package order.hq.web.service.impl;

import java.util.List;

import order.hq.basic.dao.SysFunctionDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.StringUtil;
import order.hq.web.service.SysUserService;

import org.apache.commons.lang.SystemUtils;
import org.hibernate.hql.ast.tree.UpdateStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SysUserServiceImp implements SysUserService {
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImp.class);

	//DAO
	private SysUserDAO sysUserDAO;
	private SysFunctionDAO sysFunctionDAO;

	@Override
	public SysUserVO findByPK(String userId) {
		SysUserVO sysUserVO = null;
		if (!StringUtil.isNull(userId)) {
			SysUser sysUser = (SysUser) getSysUserDAO().findByPK(userId, SysUser.class);
			if (sysUser != null) {
				sysUserVO = new SysUserVO(sysUser);
			}
		}
		return  sysUserVO;
	}
	
	@Override
	public void addSysUser(SysUserVO obj) {
		//Unrealized
	}
	@Override
	public void delteSysUser(String userId) {
		//Unrealized
	}
	
	@Override
	public List<SysUserVO> findByUserName(String userName) {
		//Unrealized
		return null;
	}

	@Override
	public void updateSysUser(SysUserVO obj) {
		//Unrealized
	}

	@Override
	public void updatePassword(String userId,String newPassword) {
		log.debug("用户名:"+userId+",新密码:"+newPassword);
		try {
			SysUser sysUser = (SysUser) getSysUserDAO().findByPK(userId, SysUser.class);
			sysUser.setPassword(newPassword);
			getSysUserDAO().update(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SysFunction> findSysFunctionAll() {
		return (List<SysFunction>) sysFunctionDAO.findAll();
	}

	public void setSysFunctionDAO(SysFunctionDAO sysFunctionDAO) {
		this.sysFunctionDAO = sysFunctionDAO;
	}

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}

	public SysUserDAO getSysUserDAO() {
		return sysUserDAO;
	}

	public SysFunctionDAO getSysFunctionDAO() {
		return sysFunctionDAO;
	}

	
}
