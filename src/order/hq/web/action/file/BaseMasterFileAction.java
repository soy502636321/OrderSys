package order.hq.web.action.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.BaseAction;
import order.hq.web.service.BaseMasterFileService;

public class BaseMasterFileAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(BaseMasterFileAction.class);

	private BaseMasterFileService baseMasterFileService;
	
	private BaseMasterFileVO baseMasterFileVO;

	public String query() {
		log.debug("ACTION:订单原文件列表");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getBaseMasterFileService().queryBaseMasterFile(paginatedList, getBaseMasterFileVO(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_MASTERFILE_PAGE;
	}

	public BaseMasterFileService getBaseMasterFileService() {
		return baseMasterFileService;
	}

	public void setBaseMasterFileService(
			BaseMasterFileService baseMasterFileService) {
		this.baseMasterFileService = baseMasterFileService;
	}

	public BaseMasterFileVO getBaseMasterFileVO() {
		return baseMasterFileVO;
	}

	public void setBaseMasterFileVO(BaseMasterFileVO baseMasterFileVO) {
		this.baseMasterFileVO = baseMasterFileVO;
	}

	
}