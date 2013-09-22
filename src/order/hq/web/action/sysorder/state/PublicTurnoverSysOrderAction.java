package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.sysorder.SysOrderAction;

public class PublicTurnoverSysOrderAction extends SysOrderAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(PublicTurnoverSysOrderAction.class);

	@Override
	public String query() {
		log.debug("ACTION:查询已成交的订单");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList,
				getSysOrderVO(), getTurnover(), null);
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String completeSysOrder() {
		if (!SystemUtil.isNull(getCbId())) {
			int i = getSysOrderService().changeState(getCbId(), getTurnover(),
					getComplete());
			addActionError("成功完成【" + i + "】个订单");
		} else {
			addActionError("请先选择订单记录");
		}
		return query();
	}
}
