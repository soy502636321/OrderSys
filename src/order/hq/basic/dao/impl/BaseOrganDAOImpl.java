package order.hq.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.BaseOrganDAO;
import order.hq.basic.database.entity.BaseOrgan;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public class BaseOrganDAOImpl extends AbstractBaseDAO implements BaseOrganDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BaseOrganDAOImpl.class);

	@Override
	public List<?> findAll(){
		log.debug("找出所有组织机构信息");
//		try {
//			getHibernateTemplate().setCacheQueries(true);
//			String hql = "from BaseOrgan obj order by obj.organPid";
//			return getHibernateTemplate().find(hql);
//		} catch (Exception e) {
//			log.error("找出所有组织机构信息异常:"+e);
//		}
//		return null;
		return getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {

			/* (non-Javadoc)
			 * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
			 */
			@Override
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from BaseOrgan obj order by obj.organPid";
				System.out.println("SESSOIN-" + session.hashCode());
				Query query = session.createQuery(hql);
				query.setCacheable(true);
				query.setCacheRegion("query.BaseOrgan");
				return query.list();
			}
		});
	}
	
	@Override
	public Logger getLogger() {
		return log;
	}
}
