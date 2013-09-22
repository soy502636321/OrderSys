package order.hq.basic.dao;

import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface BaseMasterFileDAO extends BaseDAO {

	public PaginatedList queryBaseMasterFile(PaginatedList paginatedList, BaseMasterFileVO baseMasterFileVO,
			SysUserVO sysUserVO);
	
}
