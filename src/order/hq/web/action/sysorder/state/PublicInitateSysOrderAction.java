package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysorder.SysOrderAction;

public class PublicInitateSysOrderAction extends SysOrderAction {
	private static final Logger log = LoggerFactory.getLogger(PublicInitateSysOrderAction.class);

	@Override
	public String query() {
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList, getSysOrderVO(), getConfigSysOrderStateService().findInitate(), null);
		setPaginatedList(paginatedList);
		System.out.println("验证状态是否为空:" + getCancel());
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
