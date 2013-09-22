package order.hq.basic.dao.impl;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.vo.SysOrderVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.DateUtil;
import order.hq.util.HibernateUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

public class SysOrderDAOImpl extends AbstractBaseDAO implements SysOrderDAO {
	private static final Logger log = LoggerFactory.getLogger(SysOrderDAOImpl.class);

	@Override
	public List<?> findAll() {
		log.debug("DAO:返回所有的订单");
		try {
			return getHibernateTemplate().loadAll(SysOrder.class);
		} catch (DataAccessException e) {
			log.error("返回所有的订单失败", e);
			throw e;
		}
	}
	
	@Override
	public PaginatedList querySysOrder(final PaginatedList paginatedList,
			SysOrderVO vo, final ConfigSysOrderState configSysOrderState,
			final SysUserVO sysUserVO) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

				@Override
				public PaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer hql = new StringBuffer("from SysOrder obj where 1 = 1");
					
					//订单状态
					if (configSysOrderState != null) {
						hql.append(" and (obj.orderState.statePid = '")
							.append(configSysOrderState.getStatePid()).append("')");
					}
					//根据下单用户
					if (sysUserVO != null) {
						hql.append(" and (obj.operUser.userPid = '").
							append(sysUserVO.getUserPid()).append("')");
					}
					
					//查询集合
					Query query = session.createQuery("select distinct obj " + hql.toString());
					query.setMaxResults(paginatedList.getObjectsPerPage()).
						setFirstResult(paginatedList.getStartNumber());
					List<?> list = HibernateUtil.parseToVO(query.list(), SysOrderVO.class);
					paginatedList.setList(list);
					
					//统计数量
					Query countQuery = session.createQuery("select count(obj) " + hql.toString());
					int count = ((Number) countQuery.uniqueResult()).intValue();
					paginatedList.setFullListSize(count);
					
					return paginatedList;
				}
			});
		} catch (DataAccessException e) {
			log.error("查询订单集合失败", e);
			throw e;
		}
	}
	
	@Override
	public int changeState(final String[] cbIds, final ConfigSysOrderState before,
			final ConfigSysOrderState after) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sql = new StringBuffer("update sys_order as obj set obj.ORDER_STATE_PID = '").append(after.getStatePid()).append("' where (1 = 2");
				if (!SystemUtil.isNull(cbIds)) {
					for (String cbId: cbIds) {
						sql.append(" or obj.ORDER_PID = '").append(cbId).append("'");
					}
				}
				sql.append(")");
				if (before != null) {
					sql.append(" and (obj.ORDER_STATE_PID = '").append(before.getStatePid()).append("')");
				}
				SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
				return sqlQuery.executeUpdate();
			}
		});
	}
	
	@Override
	public String createOrderNo() {
		String hql = "select count(*) from SysOrder s where s.operTime > '" + DateUtil.getDate() + "'";
		int todayCount = ((Number) getHibernateTemplate().find(hql).listIterator().next()).intValue();
		return DateUtil.getDateNumber() + "-" + String.valueOf(todayCount + 1);
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
