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
import order.hq.basic.dao.BaseTranslatedFileDAO;
import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.vo.BaseTranslatedFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.HibernateUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;

public class BaseTranslatedFileDAOImpl extends AbstractBaseDAO implements BaseTranslatedFileDAO {
	private static final Logger log = LoggerFactory.getLogger(BaseTranslatedFileDAOImpl.class);

	@Override
	public List<?> findAll() {
		log.debug("DAO:返回全部的译文文件");
		try {
			return getHibernateTemplate().loadAll(BaseTranslatedFile.class);
		} catch (DataAccessException e) {
			log.error("返回全部的译文文件失败", e);
		}
		return null;
	}
	
	@Override
	public PaginatedList queryBaseTranslatedFile(final PaginatedList paginatedList,
			final BaseTranslatedFileVO baseTranslatedFileVO, SysUserVO loginVO) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

				@Override
				public PaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer hql = new StringBuffer("from BaseTranslatedFile as obj where 1 = 1");
					if (baseTranslatedFileVO != null) {
						if (!StringUtil.isNull(baseTranslatedFileVO.getSysOrderPid())) {
							hql.append(" and obj.sysOrder.orderPid = '").append(baseTranslatedFileVO.getSysOrderPid()).append("'");
						}
					}
					
					Query query = session.createQuery("select obj " + hql.toString());
					query.setMaxResults(paginatedList.getObjectsPerPage()).
						setFirstResult(paginatedList.getStartNumber());
					paginatedList.setList(HibernateUtil.parseToVO(query.list(), BaseTranslatedFileVO.class));
					
					Query countQuery = session.createQuery("select count(obj) " + hql.toString());
					int count = ((Number) countQuery.uniqueResult()).intValue();
					paginatedList.setFullListSize(count);
					
					return paginatedList; 
				}
			});
		} catch (DataAccessException e) {
			log.error("查询译问列表集合失败", e);
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BaseTranslatedFile> findByPK(String[] cbIds) {
		try {
			StringBuffer hql = new StringBuffer("select obj from BaseTranslatedFile as obj where (1 = 2");
			if (!SystemUtil.isNull(cbIds)) {
				for (String cbId : cbIds) {
					hql.append(" or obj.translatedFilePid = '").append(cbId).append("'");
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
					StringBuffer sql = new StringBuffer("delete from BASE_TRANSLATED_FILE where (1 = 2");
					if (!SystemUtil.isNull(cbIds)) {
						for (String cbId : cbIds) {
							sql.append(" or TRANSLATED_FILE_PID = '").append(cbId).append("'");
						}
						sql.append(")");
					}
					SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
					return sqlQuery.executeUpdate();
				}
				
			});
		} catch (DataAccessException e) {
			log.error("删除译文失败", e);
			throw e;
		}
	}

	@Override
	public Logger getLogger() {
		return log;
	}
	
	
}
