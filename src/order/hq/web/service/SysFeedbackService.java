package order.hq.web.service;

import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface SysFeedbackService {
	public PaginatedList querySysFeedback(PaginatedList paginatedList, ConfigSysFeedbackState state, SysFeedbackVO sysFeedbackVO, SysUserVO sysUserVO, SysUserVO sysUserVO2);

	public int changeState(String[] cbId,
			ConfigSysFeedbackState initateFeedback,
			ConfigSysFeedbackState handleFeedback, SysUserVO loginVO);

	public SysFeedbackVO findByPK(String string);
}
