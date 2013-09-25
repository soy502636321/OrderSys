package order.hq.web.action.sysfeedback.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysfeedback.SysFeedbackAction;

public class PrivateCompleteSysFeedbackAction extends SysFeedbackAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PrivateCompleteSysFeedbackAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysFeedbackService().querySysFeedback(paginatedList, getCompleteFeedback(), getSysFeedbackVO(), getLoginVO(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
}
