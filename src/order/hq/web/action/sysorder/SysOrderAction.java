package order.hq.web.action.sysorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.vo.SysOrderVO;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.BaseAction;
import order.hq.web.service.ConfigSysOrderStateService;
import order.hq.web.service.SysOrderService;

public class SysOrderAction extends BaseAction {
	private final static Logger log = LoggerFactory
			.getLogger(SysOrderAction.class);

	// 服务层
	private SysOrderService sysOrderService;
	private ConfigSysOrderStateService configSysOrderStateService;

	// 订单状态
	private ConfigSysOrderState cancel;
	private ConfigSysOrderState complete;
	private ConfigSysOrderState turnover;
	private ConfigSysOrderState accept;
	private ConfigSysOrderState initate;

	// 属性
	private PaginatedList paginatedList;
	private int page;
	private SysOrderVO sysOrderVO;

	public String query() {
		log.debug("ACTION:分页查询订单");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysOrderService().querySysOrder(paginatedList,
				getSysOrderVO(), null, getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String findSysShow() {
		log.debug("ACTION:查看订单的指示");
		return null;
	}

	public SysOrderService getSysOrderService() {
		return sysOrderService;
	}

	public void setSysOrderService(SysOrderService sysOrderService) {
		this.sysOrderService = sysOrderService;
	}

	public PaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(PaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public SysOrderVO getSysOrderVO() {
		return sysOrderVO;
	}

	public void setSysOrderVO(SysOrderVO sysOrderVO) {
		this.sysOrderVO = sysOrderVO;
	}

	public ConfigSysOrderStateService getConfigSysOrderStateService() {
		return configSysOrderStateService;
	}

	public void setConfigSysOrderStateService(
			ConfigSysOrderStateService configSysOrderStateService) {
		this.configSysOrderStateService = configSysOrderStateService;
	}

	public ConfigSysOrderState getCancel() {
		return cancel;
	}

	public void setCancel(ConfigSysOrderState cancel) {
		this.cancel = cancel;
	}

	public ConfigSysOrderState getComplete() {
		return complete;
	}

	public void setComplete(ConfigSysOrderState complete) {
		this.complete = complete;
	}

	public ConfigSysOrderState getTurnover() {
		return turnover;
	}

	public void setTurnover(ConfigSysOrderState turnover) {
		this.turnover = turnover;
	}

	public ConfigSysOrderState getAccept() {
		return accept;
	}

	public void setAccept(ConfigSysOrderState accept) {
		this.accept = accept;
	}

	public ConfigSysOrderState getInitate() {
		return initate;
	}

	public void setInitate(ConfigSysOrderState initate) {
		this.initate = initate;
	}

}
