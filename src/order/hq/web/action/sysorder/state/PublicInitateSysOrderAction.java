package order.hq.web.action.sysorder.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.sysorder.SysOrderAction;

public class PublicInitateSysOrderAction extends SysOrderAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PublicInitateSysOrderAction.class);

	@Override
	public String query() {
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList, getSysOrderVO(), getConfigSysOrderStateService().findInitate(), null);
		setPaginatedList(paginatedList);
		System.out.println("验证状态是否为空:" + getCancel());
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	
	/**
	 * 接受订单
	 * @return
	 */
	public String acceptSysOrder() {
		log.debug("ACTION:");
		if (!SystemUtil.isNull(getCbId())) {
			int i = getSysOrderService().changeState(getCbId(), getInitate(), getAccept());
			addActionError("成功接受【" + i + "】个订单");
		} else {
			addActionError("请先选择订单记录");
		}
		return query();
	}
}
