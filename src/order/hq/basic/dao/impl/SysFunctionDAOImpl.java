package order.hq.basic.dao.impl;

import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.SysFunctionDAO;
import order.hq.basic.database.entity.SysFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class SysFunctionDAOImpl extends AbstractBaseDAO implements SysFunctionDAO {
	
	private static final Logger log = LoggerFactory.getLogger(SysFunctionDAOImpl.class);

	@Override
	public List<?> findAll(){
		log.debug("找出所有功能信息");
		try {
			String hql = "from SysFunction obj order by obj.operTime";
			return getHibernateTemplate().find(hql);
		} catch (Exception e) {
			log.error("找出所有功能信息异常:"+e);
		}
		return null;
	}
	
	@Override
	public Logger getLogger() {
		return log;
	}
}
