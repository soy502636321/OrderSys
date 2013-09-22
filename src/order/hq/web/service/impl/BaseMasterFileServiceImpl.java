package order.hq.web.service.impl;

import order.hq.basic.dao.BaseMasterFileDAO;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;
import order.hq.web.service.BaseMasterFileService;

public class BaseMasterFileServiceImpl implements BaseMasterFileService {
	private BaseMasterFileDAO baseMasterFileDAO;

	@Override
	public PaginatedList queryBaseMasterFile(PaginatedList paginatedList, BaseMasterFileVO baseMasterFileVO,
			SysUserVO sysUserVO) {
		return getBaseMasterFileDAO().queryBaseMasterFile(paginatedList, baseMasterFileVO, sysUserVO);
	}

	public BaseMasterFileDAO getBaseMasterFileDAO() {
		return baseMasterFileDAO;
	}

	public void setBaseMasterFileDAO(BaseMasterFileDAO baseMasterFileDAO) {
		this.baseMasterFileDAO = baseMasterFileDAO;
	}

}
