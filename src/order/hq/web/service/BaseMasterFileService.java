package order.hq.web.service;

import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface BaseMasterFileService {
	public PaginatedList queryBaseMasterFile(PaginatedList paginatedList, BaseMasterFileVO baseMasterFileVO, SysUserVO sysUserVO);
}