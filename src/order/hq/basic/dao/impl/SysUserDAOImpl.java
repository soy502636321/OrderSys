package order.hq.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.HibernateUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SysUserDAOImpl extends AbstractBaseDAO implements SysUserDAO {

	private static final Logger log = LoggerFactory
			.getLogger(SysUserDAOImpl.class);

	@Override
	public List<?> findAll() {
		log.debug("找出所有用户信息");
		try {
			return getHibernateTemplate().loadAll(SysUser.class);
		} catch (Exception e) {
			log.error("找出所有用户信息异常:" + e);
		}
		return null;
	}

	@Override
	public PaginatedList querySysUser(final PaginatedList paginatedList,
			final SysUserVO sysUserVO, SysUserVO loginVO) {
		try {
			return getHibernateTemplate().execute(new HibernateCallback<PaginatedList>() {

				@Override
				public PaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer hql = new StringBuffer("from SysUser obj where 1 = 1");
					
					if (sysUserVO != null) {
						if(!StringUtil.isNull(sysUserVO.getUserPid())) {
							hql.append(" and obj.userPid like '%").append(sysUserVO.getUserPid()).append("%'");
						}
						if (!StringUtil.isNull(sysUserVO.getUserName())) {
							hql.append(" and obj.userName like '%").append(sysUserVO.getUserName()).append("%'");
						}
						if (!StringUtil.isNull(sysUserVO.getCustNo())) {
							hql.append(" and obj.custNo like '%").append(sysUserVO.getCustNo()).append("%'");
						}
					}
					
					//查询分页集合
					Query query = session.createQuery("select distinct obj " + hql.toString());
					query.setMaxResults(paginatedList.getObjectsPerPage()).setFirstResult(paginatedList.getStartNumber());
					paginatedList.setList(HibernateUtil.parseToVO(query.list(), SysUserVO.class));
					
					//统计数量
					Query countQuery = session.createQuery("select count(distinct obj) " + hql.toString());
					int count = ((Number) countQuery.uniqueResult()).intValue();
					paginatedList.setFullListSize(count);
					
					return paginatedList;
				}
			});
		} catch (DataAccessException e) {
			log.error("根据用户VO查询用户失败", e);
			throw e;
		}
	}

	@Override
	public Logger getLogger() {
		return log;
	}

}
