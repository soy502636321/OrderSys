package order.hq.web.action.sysorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysOrderVO;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;
import order.hq.web.action.BaseAction;
import order.hq.web.service.BaseMasterFileService;
import order.hq.web.service.BaseTranslatedFileService;
import order.hq.web.service.ConfigSysOrderStateService;
import order.hq.web.service.SysOrderService;

public class SysOrderAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private final static Logger log = LoggerFactory
			.getLogger(SysOrderAction.class);

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
		return ForwardUtil.FORWARD_SYSSHOW_SHOW_PAGE;
	}

	public String findSysOrder() {
		log.debug("ACTION:查看订单详细");
		return ForwardUtil.FORWARD_SYSORDER_SHOW_PAGE;
	}

	public String queryBaseTranslatedFile() {
		log.debug("ACTION:查看译文列表");
		return ForwardUtil.FORWARD_TRANSLATEDFILE_PAGE;
	}

	public String queryBaseMasterFile() {
		log.debug("ACTION:订单原文件列表");
		PaginatedList paginatedList = new PaginatedList(getPage());
		if (!SystemUtil.isNull(getCbId())) {
			BaseMasterFileVO baseMasterFileVO = new BaseMasterFileVO();
			baseMasterFileVO.setSysOrderPid(getCbId()[0]);
			setBaseMasterFileVO(baseMasterFileVO);
			paginatedList = getBaseMasterFileService().queryBaseMasterFile(
					paginatedList, getBaseMasterFileVO(), getLoginVO());
			setPaginatedList(paginatedList);
		} else {
			addActionError("请先选择一个订单");
		}
		return ForwardUtil.FORWARD_MASTERFILE_PAGE;
	}
	
	/**
	 * 作废订单
	 * @return
	 */
	public String cancelSysOrder() {
		log.debug("ACTION:作废订单");
		if (!SystemUtil.isNull(getCbId())) {
			int i = getSysOrderService().changeState(getCbId(), null, getCancel());
			addActionMessage("成功作废【" + i + "】个订单");
		} else {
			addActionError("请先选择订单记录");
		}
		return query();
	}
}
