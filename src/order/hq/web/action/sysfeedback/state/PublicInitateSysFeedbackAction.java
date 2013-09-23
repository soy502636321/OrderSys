package order.hq.web.action.sysfeedback.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.web.action.sysfeedback.SysFeedbackAction;
import order.hq.web.service.SysFeedbackService;

public class PublicInitateSysFeedbackAction extends SysFeedbackAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(PublicInitateSysFeedbackAction.class);

	/**
	 * 查询新的反馈
	 */
	public String query() {
		log.debug("ACTION:查询新的反馈");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysFeedbackService().querySysFeedback(paginatedList, getInitateFeedback(),getSysFeedbackVO(), null, getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String handleSysFeedback() {
		log.debug("ACTION:");
		int i = getSysFeedbackService().changeState(getCbId(), getInitateFeedback(), getHandleFeedback(), getLoginVO());
		addActionMessage("成功接受【" + i + "】个反馈");
		return query();
	}
}
