package order.hq.basic.dao.impl;

import java.util.List;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.SysUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class SysUserDAOImpl extends AbstractBaseDAO implements SysUserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(SysUserDAOImpl.class);

	@Override
	public List<?> findAll(){
		log.debug("找出所有用户信息");
		try {
			return getHibernateTemplate().loadAll(SysUser.class);
		} catch (Exception e) {
			log.error("找出所有用户信息异常:"+e);
		}
		return null;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
