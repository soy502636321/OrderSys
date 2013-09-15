package order.hq.web.service.impl;

import java.util.List;

import order.hq.basic.dao.SysFunctionDAO;
import order.hq.basic.dao.SysSectionDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.database.entity.SysSection;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;
import order.hq.web.service.SysUserService;

import org.apache.commons.lang.SystemUtils;
import org.hibernate.hql.ast.tree.UpdateStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SysUserServiceImp implements SysUserService {
	private static final Logger log = LoggerFactory
			.getLogger(SysUserServiceImp.class);

	// DAO
	private SysUserDAO sysUserDAO;
	private SysFunctionDAO sysFunctionDAO;
	private SysSectionDAO sysSectionDAO;

	@Override
	public SysUserVO findByPK(String userId) {
		SysUserVO sysUserVO = null;
		if (!StringUtil.isNull(userId)) {
			SysUser sysUser = (SysUser) getSysUserDAO().findByPK(userId,
					SysUser.class);
			if (sysUser != null) {
				sysUserVO = new SysUserVO(sysUser);
			}
		}
		return sysUserVO;
	}

	@Override
	public SysUserVO addSysUser(SysUserVO obj, SysUserVO loginVO) {
		SysUserVO vo = null;
		if (obj != null) {
			try {
				SysUser sysUser = new SysUser();
				
				String sysSectionPid = obj.getSysSectionPid();
				if (!StringUtil.isNull(sysSectionPid)) {
					SysSection sysSection = (SysSection) getSysSectionDAO().findByPK(sysSectionPid, SysSection.class);
					sysUser.setSysSection(sysSection); //角色
				}
				sysUser.setUserPid(obj.getUserPid()); // 用户帐号
				sysUser.setUserName(obj.getUserName()); // 用户名称
				sysUser.setPassword(obj.getPassword()); //用户密码
				sysUser.setCustNo(obj.getCustNo()); //客户编号
				sysUser.setRemark(obj.getRemark()); // 备注

				getSysUserDAO().save(sysUser);
				vo = new SysUserVO(sysUser);
			} catch (Exception e) {
				log.error("SERVICE:增加用户失败", e);
				vo = null;
			}
		}
		return vo;
	}

	@Override
	public int deleteSysUser(String[] userIds) {
		int size = 0;
		if (!SystemUtil.isNull(userIds)) {
			for (String id : userIds) {
				try {
					SysUser sysUser = (SysUser) getSysUserDAO().findByPK(id, SysUser.class);
					if (sysUser != null) {
						getSysUserDAO().delete(sysUser);
						size++;
					}
				} catch (Exception e) {
					log.error("删除用户失败", e);
				}
			}
		}
		return size;
	}

	@Override
	public List<SysUserVO> findByUserName(String userName) {
		// Unrealized
		return null;
	}

	@Override
	public SysUserVO updateSysUser(SysUserVO obj, SysUserVO loginVO) {
		SysUserVO vo = null;
		if (obj != null && !StringUtil.isNull(obj.getUserPid())) {
			SysUser sysUser = (SysUser) getSysUserDAO().findByPK(obj.getUserPid(), SysUser.class);
			if (sysUser != null) {
				try {
					String sysSectionPid = obj.getSysSectionPid();
					if (!StringUtil.isNull(sysSectionPid)) {
						SysSection sysSection = (SysSection) getSysSectionDAO().findByPK(sysSectionPid, SysSection.class);
						sysUser.setSysSection(sysSection); //角色
					}
					sysUser.setUserPid(obj.getUserPid()); // 用户帐号
					sysUser.setUserName(obj.getUserName()); // 用户名称
					sysUser.setPassword(obj.getPassword()); //用户密码
					sysUser.setCustNo(obj.getCustNo()); //客户编号
					sysUser.setRemark(obj.getRemark()); // 备注
					
					getSysUserDAO().update(sysUser);
					vo = new SysUserVO(sysUser);
				} catch (Exception e) {
					log.error("修改用户信息失败", e);
					vo = null;
				}
			}
		}
		return vo;
	}

	@Override
	public void updatePassword(String userId, String newPassword) {
		log.debug("用户名:" + userId + ",新密码:" + newPassword);
		try {
			SysUser sysUser = (SysUser) getSysUserDAO().findByPK(userId,
					SysUser.class);
			sysUser.setPassword(newPassword);
			getSysUserDAO().update(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public PaginatedList querySysUser(PaginatedList paginatedList,
			SysUserVO sysUserVO, SysUserVO loginVO) {
		return getSysUserDAO().querySysUser(paginatedList, sysUserVO, loginVO);
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

	public SysSectionDAO getSysSectionDAO() {
		return sysSectionDAO;
	}

	public void setSysSectionDAO(SysSectionDAO sysSectionDAO) {
		this.sysSectionDAO = sysSectionDAO;
	}

}
