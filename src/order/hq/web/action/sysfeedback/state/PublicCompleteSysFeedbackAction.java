package order.hq.web.action.sysfeedback.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysfeedback.SysFeedbackAction;

public class PublicCompleteSysFeedbackAction extends SysFeedbackAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PublicCompleteSysFeedbackAction.class);
	
	@Override
	public String query() {
		log.debug("ACTION:查询处理完成的反馈列表");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysFeedbackService().querySysFeedback(paginatedList, getCompleteFeedback(), getSysFeedbackVO(), null, getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
}
