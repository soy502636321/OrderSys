package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.sysorder.SysOrderAction;

public class PublicAcceptSysOrderAction extends SysOrderAction{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PublicAcceptSysOrderAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:查询已接受的订单");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList, getSysOrderVO(), getAccept(), null);
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String turnoverSysOrder() {
		if (!SystemUtil.isNull(getCbId())) {
			int i = getSysOrderService().changeState(getCbId(), getAccept(), getTurnover());
			addActionError("成功成交【" + i + "】个订单");
		} else {
			addActionError("请先选择订单记录");
		}
		return query();
	}
}
