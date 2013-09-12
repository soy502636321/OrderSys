package order.hq.basic.dao.impl;

import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.ConfigSysOrderStateDAO;
import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.util.SystemUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ConfigSysOrderStateDAOImpl extends AbstractBaseDAO implements ConfigSysOrderStateDAO {
	private static final Logger log = LoggerFactory.getLogger(ConfigSysOrderStateDAOImpl.class);
	
	@Override
	public ConfigSysOrderState findInitate() {
		log.debug("DAO:返回新订单状态");
		try {
			String hql = "from ConfigSysOrderState c where c.stateName = '新订单'";
			List<ConfigSysOrderState> orderStates = getHibernateTemplate().find(hql);
			if (!SystemUtil.isNull(orderStates)) {
				return orderStates.get(0);
			}
		} catch (DataAccessException e) {
			log.error("获得新订单状态失败", e);
		}
		return null;
	}
	
	@Override
	public ConfigSysOrderState findAccept() {
		log.debug("DAO:返回已接受状态");
		try {
			String hql = "from ConfigSysOrderState c where c.stateName = '已接受'";
			List<ConfigSysOrderState> orderStates = getHibernateTemplate().find(hql);
			if (!SystemUtil.isNull(orderStates)) {
				return orderStates.get(0);
			}
		} catch (DataAccessException e) {
			log.error("获得已接受状态失败", e);
		}
		return null;
	}
	
	@Override
	public ConfigSysOrderState findTurnover() {
		log.debug("DAO:返回已成交状态");
		try {
			String hql = "from ConfigSysOrderState c where c.stateName = '已成交'";
			List<ConfigSysOrderState> orderStates = getHibernateTemplate().find(hql);
			if (!SystemUtil.isNull(orderStates)) {
				return orderStates.get(0);
			}
		} catch (DataAccessException e) {
			log.error("获得已成交状态失败", e);
		}
		return null;
	}
	
	@Override
	public ConfigSysOrderState findComplete() {
		log.debug("DAO:返回已完成状态");
		try {
			String hql = "from ConfigSysOrderState c where c.stateName = '已完成'";
			List<ConfigSysOrderState> orderStates = getHibernateTemplate().find(hql);
			if (!SystemUtil.isNull(orderStates)) {
				return orderStates.get(0);
			}
		} catch (DataAccessException e) {
			log.error("获得已完成状态失败");
		}
		return null;
	}
	
	@Override
	public ConfigSysOrderState findCancel() {
		log.debug("DAO:返回已作废状态");
		try {
			String hql = "from ConfigSysOrderState c where c.stateName = '已作废'";
			List<ConfigSysOrderState> orderStates = getHibernateTemplate().find(hql);
			if (!SystemUtil.isNull(orderStates)) {
				return orderStates.get(0);
			}
		} catch (DataAccessException e) {
			log.error("获得已作废状态失败", e);
		}
		return null;
	}

	@Override
	public List<?> findAll() {
		log.debug("DAO:返回所有的订单状态");
		try {
			return getHibernateTemplate().loadAll(ConfigSysOrderState.class);
		} catch (DataAccessException e) {
			log.error("返回全部订单状态失败", e);
		}
		return null;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
	
	
}