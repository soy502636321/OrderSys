package order.hq.basic.dao;

import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;


public interface SysUserDAO extends BaseDAO {

	public PaginatedList querySysUser(PaginatedList paginatedList,
			SysUserVO sysUserVO, SysUserVO loginVO);
	
}
