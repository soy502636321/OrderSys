package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.SysOrder;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysorder.SysOrderAction;
import sun.print.PageableDoc;

public class PrivateInitateSysOrderAction extends SysOrderAction {
	private static final Logger log = LoggerFactory.getLogger(PrivateInitateSysOrderAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:查询个人的新订单");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList, getSysOrderVO(), getConfigSysOrderStateService().findInitate(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
