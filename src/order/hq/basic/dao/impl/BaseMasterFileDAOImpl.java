package order.hq.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.BaseMasterFileDAO;
import order.hq.basic.database.entity.BaseMasterFile;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.HibernateUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;

public class BaseMasterFileDAOImpl extends AbstractBaseDAO implements BaseMasterFileDAO {
	private static final Logger log = LoggerFactory.getLogger(BaseMasterFileDAOImpl.class);
	
	@Override
	public List<?> findAll() {
		log.debug("DAO:返回所有的原文文件");
		try {
			return getHibernateTemplate().loadAll(BaseMasterFile.class);
		} catch (DataAccessException e) {
			log.error("返回所有的原文文件失败", e);
		}
		return null;
	}
	
	@Override
	public PaginatedList queryBaseMasterFile(final PaginatedList paginatedList, final BaseMasterFileVO baseMasterFileVO,
			SysUserVO sysUserVO) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

				@Override
				public PaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer hql = new StringBuffer("from BaseMasterFile as obj").append(" where 1 = 1");
					
					if (baseMasterFileVO != null) {
						//订单主键
						if (!StringUtil.isNull(baseMasterFileVO.getSysOrderPid())) {
							hql.append(" and (obj.sysOrder.orderPid = '").append(baseMasterFileVO.getSysOrderPid()).append("')");
						}
					}
					
					Query query = session.createQuery("select obj " + hql.toString());
					query.setMaxResults(paginatedList.getObjectsPerPage()).
						setFirstResult(paginatedList.getStartNumber());
					paginatedList.setList(HibernateUtil.parseToVO(query.list(), BaseMasterFileVO.class));
					
					Query countQuery = session.createQuery("select count(obj) " + hql.toString());
					int count = ((Number) countQuery.uniqueResult()).intValue();
					paginatedList.setFullListSize(count);
					
					return paginatedList;
				}
			});
		} catch (DataAccessException e) {
			log.error("查询原文列表失败", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseMasterFile> findByPK(String[] cbIds) {
		try {
			StringBuffer hql = new StringBuffer("select obj from BaseMasterFile as obj where (1 = 2");
			if (!SystemUtil.isNull(cbIds)) {
				for (String cbId : cbIds) {
					hql.append(" or obj.masterFilePid = '").append(cbId).append("'");
				}
			}
			hql.append(")");
			return getHibernateTemplate().find(hql.toString());
		} catch (DataAccessException e) {
			log.debug("", e);
			throw e;
		}
	}
	
	@Override
	public int delete(final String[] cbIds, SysUserVO loginVO) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

				@Override
				public Integer doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer sql = new StringBuffer("delete from BASE_MASTER_FILE where (1 = 2");
					if (!SystemUtil.isNull(cbIds)) {
						for (String cbId : cbIds) {
							sql.append(" or MASTER_FILE_PID = '").append(cbId).append("'");
						}
					}
					sql.append(")");
					
					SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
					return sqlQuery.executeUpdate();
				}
			});
		} catch (DataAccessException e) {
			log.error("删除原文失败", e);
			throw e;
		}
	}
	
	@Override
	public Logger getLogger() {
		return log;
	}
	
}
