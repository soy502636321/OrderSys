package order.hq.web.service.impl;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import order.hq.basic.dao.SysFeedbackDAO;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.database.entity.SysFeedback;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.web.service.SysFeedbackService;

public class SysFeedbackServiceImpl implements SysFeedbackService {
	private static final Logger log = LoggerFactory.getLogger(SysFeedbackServiceImpl.class);
	
	private SysFeedbackDAO sysFeedbackDAO;
	
	@Override
	public PaginatedList querySysFeedback(PaginatedList paginatedList, ConfigSysFeedbackState state,
			SysFeedbackVO sysFeedbackVO, SysUserVO sysUserVO, SysUserVO sysUserVO2) {
		return getSysFeedbackDAO().querySysFeedback(paginatedList, state, sysFeedbackVO, sysUserVO);
	}
	
	@Override
	public SysFeedbackVO findByPK(String string) {
		SysFeedbackVO vo = null;
		if (!StringUtil.isNull(string)) {
			SysFeedback sysFeedback = (SysFeedback) getSysFeedbackDAO().findByPK(string, SysFeedback.class);
			if (sysFeedback != null) {
				vo = new SysFeedbackVO(sysFeedback);
			}
		}
		return vo;
	}
	
	@Override
	public int changeState(String[] cbId,
			ConfigSysFeedbackState initateFeedback,
			ConfigSysFeedbackState handleFeedback, SysUserVO loginVO) {
		return getSysFeedbackDAO().changeState(cbId, initateFeedback, handleFeedback, loginVO);
	}

	public SysFeedbackDAO getSysFeedbackDAO() {
		return sysFeedbackDAO;
	}

	public void setSysFeedbackDAO(SysFeedbackDAO sysFeedbackDAO) {
		this.sysFeedbackDAO = sysFeedbackDAO;
	}
	
	
}
