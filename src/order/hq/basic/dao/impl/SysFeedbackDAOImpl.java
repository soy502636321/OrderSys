package order.hq.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.SysFeedbackDAO;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.database.entity.SysFeedback;
import order.hq.basic.vo.SysFeedbackVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.HibernateUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;

public class SysFeedbackDAOImpl extends AbstractBaseDAO implements SysFeedbackDAO {
	private static final Logger log = LoggerFactory.getLogger(SysFeedbackDAOImpl.class);

	@Override
	public List<?> findAll() {
		try {
			return getHibernateTemplate().loadAll(SysFeedback.class);
		} catch (DataException e) {
			log.error("查询全部反馈失败", e);
			throw e;
		}
	}
	
	@Override
	public PaginatedList querySysFeedback(final PaginatedList paginatedList, final ConfigSysFeedbackState state,
			final SysFeedbackVO sysFeedbackVO, final SysUserVO sysUserVO) {
		return getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

			@Override
			public PaginatedList doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from SysFeedback obj where 1 = 1");
				if (state != null) {
					hql.append(" and obj.state.statePid = '").append(state.getStatePid()).append("'");
				}
				
				if (sysFeedbackVO != null) {
					
				}
				
				if (sysUserVO != null) {
					
				}
				
				//查询分页集合
				Query query = session.createQuery("select obj " + hql.toString());
				query.setMaxResults(paginatedList.getObjectsPerPage()).setFirstResult(paginatedList.getStartNumber());
				paginatedList.setList(HibernateUtil.parseToVO(query.list(), SysFeedbackVO.class));
				
				//统计总数
				Query countQuery = session.createQuery("select count(obj) " + hql.toString());
				int count = ((Number) countQuery.uniqueResult()).intValue();
				paginatedList.setFullListSize(count);
				
				return paginatedList;
			}
		});
	}
	
	@Override
	public int changeState(final String[] cbIds,
			final ConfigSysFeedbackState before,
			final ConfigSysFeedbackState after, SysUserVO loginVO) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sql = new StringBuffer("update SYS_FEEDBACK as obj set obj.STATE_PID = '").
							append(after.getStatePid()).append("' where (1 = 2");
				if (!SystemUtil.isNull(cbIds)) {
					for (String cbId : cbIds) {
						sql.append(" or obj.FEEDBACK_PID = '").append(cbId).append("'");
					}
				}
				sql.append(")");
				if (before != null) {
					sql.append(" and (obj.STATE_PID = '").append(before.getStatePid()).append("')");
				}
				
				SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
				return sqlQuery.executeUpdate(); 
			}
		});
	}

	@Override
	public Logger getLogger() {
		return log;
	}
	
}
