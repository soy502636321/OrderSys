package order.hq.web.action.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.web.action.BaseAction;

public class SysFeedbackFileAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(SysFeedbackFileAction.class);
	
	public String query() {
		log.debug("ACTION:");
		return ForwardUtil.FORWARD_SYSFEEDBACKFILE_PAGE;
	}
	
	public String queryShow() {
		log.debug("ACTION:");
		return ForwardUtil.FORWARD_SYSFEEDBACKFILE_SHOW_PAGE;
	}
}
