package order.hq.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.SysSectionDAO;
import order.hq.basic.database.entity.SysSection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;



public class SysSectionDAOImpl extends AbstractBaseDAO implements SysSectionDAO {
	
	private static final Logger log = LoggerFactory.getLogger(SysSectionDAOImpl.class);

	@Override
	public List<?> findAll(){
		log.debug("找出所有部门信息");
		try {
			return getHibernateTemplate().loadAll(SysSection.class);
		} catch (Exception e) {
			log.error("找出所有部门信息异常:"+e);
		}
		return null;
	}
	
	public List findAll(String orderBy, boolean isAsc){
		Assert.hasText(orderBy);
		if (isAsc){
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(SysSection.class).addOrder(Order.asc(orderBy)));
		}else{
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(SysSection.class).addOrder(Order.desc(orderBy)));
		}
	}
	
	@Override
	public Logger getLogger() {
		return log;
	}
		
}
