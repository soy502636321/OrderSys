package order.hq.basic.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.ConfigSysFeedbackStateDAO;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;

public class ConfigSysFeedbackStateDAOImpl extends AbstractBaseDAO implements ConfigSysFeedbackStateDAO {
	private static final Logger log = LoggerFactory.getLogger(ConfigSysFeedbackStateDAOImpl.class);

	@Override
	public List<?> findAll() {
		try {
			return getHibernateTemplate().loadAll(ConfigSysFeedbackState.class);
		} catch (DataAccessException e) {
			log.error("返回所有的反馈状态失败", e);
			throw e;
		}
	}
	
	@Override
	public ConfigSysFeedbackState findByName(String stateName) {
		ConfigSysFeedbackState state = null;
		if (!StringUtil.isNull(stateName)) {
			String hql = "from ConfigSysFeedbackState obj where obj.stateName = '" + stateName + "'";
			List<?> list = getHibernateTemplate().find(hql);
			if (!SystemUtil.isNull(list)) {
				state = (ConfigSysFeedbackState) list.get(0);
			}
		}
		return state;
	}
	
	@Override
	public Logger getLogger() {
		return log;
	}
}
