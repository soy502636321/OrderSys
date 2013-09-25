package order.hq.web.action.sysfeedback.state;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysfeedback.SysFeedbackAction;

public class PrivateHandleSysFeedbackAction extends SysFeedbackAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PrivateHandleSysFeedbackAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysFeedbackService().querySysFeedback(paginatedList, getHandleFeedback(), getSysFeedbackVO(), getLoginVO(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
