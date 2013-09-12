package order.hq.web.service;

import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.vo.SysOrderVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface SysOrderService {
	/**
	 * 查询订单，可以根据订单状态、订单对象、下单人来准确查询
	 * @param paginatedList
	 * @param vo
	 * @param configSysOrderState
	 * @param sysUserVO
	 * @return
	 */
	public PaginatedList querySysOrder(PaginatedList paginatedList, SysOrderVO vo, ConfigSysOrderState configSysOrderState,SysUserVO sysUserVO);
}
