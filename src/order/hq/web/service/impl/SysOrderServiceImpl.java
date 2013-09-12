package order.hq.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.vo.SysOrderVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;
import order.hq.web.service.SysOrderService;

public class SysOrderServiceImpl implements SysOrderService {
	private static final Logger log = LoggerFactory
			.getLogger(SysOrderServiceImpl.class);

	// 服务层
	private SysOrderDAO sysOrderDAO;

	@Override
	public PaginatedList querySysOrder(PaginatedList paginatedList,
			SysOrderVO vo, ConfigSysOrderState configSysOrderState,
			SysUserVO sysUserVO) {
		return getSysOrderDAO().querySysOrder(paginatedList, vo, configSysOrderState, sysUserVO);
	}

	public SysOrderDAO getSysOrderDAO() {
		return sysOrderDAO;
	}

	public void setSysOrderDAO(SysOrderDAO sysOrderDAO) {
		this.sysOrderDAO = sysOrderDAO;
	}

}
