package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysorder.SysOrderAction;

public class PublicAcceptSysOrderAction extends SysOrderAction{
	private static final Logger log = LoggerFactory.getLogger(PublicAcceptSysOrderAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:查询已接受的订单");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList, getSysOrderVO(), getAccept(), null);
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
