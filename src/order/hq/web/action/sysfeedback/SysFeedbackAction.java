package order.hq.web.action.sysfeedback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.BaseTranslatedFileVO;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.BaseAction;
import order.hq.web.service.SysFeedbackService;

public class SysFeedbackAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(SysFeedbackAction.class);

	// 反馈状态
	private ConfigSysFeedbackState initateFeedback;
	private ConfigSysFeedbackState handleFeedback;
	private ConfigSysFeedbackState completeFeedback;
	
	private SysFeedbackService sysFeedbackService;

	private SysFeedbackVO sysFeedbackVO;

	public String query() {
		log.debug("ACTION:查询反馈列表");
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String add() {
		log.debug("ACTION:");
		return "sysFeedback_Add";
	}
	
	public String show() {
		log.debug("ACTON:");
		if (!SystemUtil.isNull(getCbId())) {
			SysFeedbackVO sysFeedbackVO = getSysFeedbackService().findByPK(getCbId()[0]);
			if (sysFeedbackVO != null) {
				setSysFeedbackVO(sysFeedbackVO);
			} else {
				addActionError("未能找到你所选择的反馈记录，请刷新一次再进行操作");
			}
		} else {
			addActionError("请先选择反馈记录");
		}
		return "sysFeedback_Show";
	}
	
	public String queryBaseTranslatedFile() {
		log.debug("ACTION;");
		if (!SystemUtil.isNull(getCbId())) {
			SysFeedbackVO sysFeedbackVO = getSysFeedbackService().findByPK(getCbId()[0]);
			if (sysFeedbackVO != null) {
				BaseTranslatedFileVO translatedFileVO = new BaseTranslatedFileVO();
				translatedFileVO.setSysOrderPid(sysFeedbackVO.getSysOrderPid());
				PaginatedList paginatedList = new PaginatedList(1);
				setBaseTranslatedFileVO(translatedFileVO);
				paginatedList = getBaseTranslatedFileService().queryBaseTranslatedFile(paginatedList, getBaseTranslatedFileVO(), getLoginVO());
				setPaginatedList(paginatedList);
			} else {
				addActionError("未能找到你所选择的反馈记录，请刷新一遍在进行操作");
			}
		} else {
			addActionError("请先选择反馈记录");
		}
		return ForwardUtil.FORWARD_TRANSLATEDFILE_SHOW_PAGE;
	}
	
	public String queryBaseMasterFile() {
		log.debug("ACTION:");
		if (!SystemUtil.isNull(getCbId())) {
			SysFeedbackVO sysFeedbackVO = getSysFeedbackService().findByPK(getCbId()[0]);
			if (sysFeedbackVO != null) {
				BaseMasterFileVO masterFileVO = new BaseMasterFileVO();
				masterFileVO.setSysOrderPid(sysFeedbackVO.getSysOrderPid());
				setBaseMasterFileVO(masterFileVO);
				PaginatedList paginatedList = new PaginatedList(1);
				paginatedList = getBaseMasterFileService().queryBaseMasterFile(paginatedList, getBaseMasterFileVO(), getLoginVO());
				setPaginatedList(paginatedList);
			} else {
				addActionError("未能找到你所选择的反馈记录，请刷新一遍再进行操作");
			}
		} else {
			addActionError("请先选择反馈记录");
		}
		return ForwardUtil.FORWARD_MASTERFILE_SHOW_PAGE;
	}

	public ConfigSysFeedbackState getInitateFeedback() {
		return initateFeedback;
	}

	public void setInitateFeedback(ConfigSysFeedbackState initateFeedback) {
		this.initateFeedback = initateFeedback;
	}

	public ConfigSysFeedbackState getHandleFeedback() {
		return handleFeedback;
	}

	public void setHandleFeedback(ConfigSysFeedbackState handleFeedback) {
		this.handleFeedback = handleFeedback;
	}

	public ConfigSysFeedbackState getCompleteFeedback() {
		return completeFeedback;
	}

	public void setCompleteFeedback(ConfigSysFeedbackState completeFeedback) {
		this.completeFeedback = completeFeedback;
	}

	public SysFeedbackService getSysFeedbackService() {
		return sysFeedbackService;
	}

	public void setSysFeedbackService(SysFeedbackService sysFeedbackService) {
		this.sysFeedbackService = sysFeedbackService;
	}

	public SysFeedbackVO getSysFeedbackVO() {
		return sysFeedbackVO;
	}

	public void setSysFeedbackVO(SysFeedbackVO sysFeedbackVO) {
		this.sysFeedbackVO = sysFeedbackVO;
	}

	
}
