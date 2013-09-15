package order.hq.web.action.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.util.ForwardUtil;
import order.hq.web.action.BaseAction;

public class BaseLanguageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BaseLanguageAction.class);
	
	public String query() {
		log.debug("ACTION:语种列表查询");
		
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
}
