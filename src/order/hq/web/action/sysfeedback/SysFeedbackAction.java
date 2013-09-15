package order.hq.web.action.sysfeedback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.util.ForwardUtil;
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
