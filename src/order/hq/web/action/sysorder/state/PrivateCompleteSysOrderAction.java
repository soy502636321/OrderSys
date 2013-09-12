package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysorder.SysOrderAction;

public class PrivateCompleteSysOrderAction extends SysOrderAction {
	private static final Logger log = LoggerFactory.getLogger(PrivateCompleteSysOrderAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:查询个人的已完成订单");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList, getSysOrderVO(), getConfigSysOrderStateService().findComplete(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
