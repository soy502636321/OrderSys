package order.hq.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.dao.SysSectionDAO;
import order.hq.basic.database.entity.SysSection;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.SysSectionVO;
import order.hq.util.HibernateUtil;
import order.hq.web.service.SysSectionService;

public class SysSectionServiceImpl implements SysSectionService {
	private static final Logger log = LoggerFactory
			.getLogger(SysSectionServiceImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<SysSectionVO> findAll() {
		List<SysSection> sysSections = (List<SysSection>) getSysSectionDAO().findAll();
		System.out.println("查看集合状态:" + sysSections);
		return (List<SysSectionVO>) HibernateUtil.parseToVO(sysSections, SysSectionVO.class);
	}
	
	private SysSectionDAO sysSectionDAO;

	public SysSectionDAO getSysSectionDAO() {
		return sysSectionDAO;
	}

	public void setSysSectionDAO(SysSectionDAO sysSectionDAO) {
		this.sysSectionDAO = sysSectionDAO;
	}

}
