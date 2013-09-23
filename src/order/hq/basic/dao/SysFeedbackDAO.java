package order.hq.basic.dao;

import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface SysFeedbackDAO extends BaseDAO {

	public PaginatedList querySysFeedback(PaginatedList paginatedList,
			ConfigSysFeedbackState state, SysFeedbackVO sysFeedbackVO, SysUserVO sysUserVO);

	public int changeState(String[] cbId,
			ConfigSysFeedbackState initateFeedback,
			ConfigSysFeedbackState handleFeedback, SysUserVO loginVO);

}
