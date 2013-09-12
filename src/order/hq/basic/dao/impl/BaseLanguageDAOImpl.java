package order.hq.basic.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.BaseLanguageDAO;
import order.hq.basic.database.entity.BaseLanguage;

public class BaseLanguageDAOImpl extends AbstractBaseDAO implements BaseLanguageDAO {
	private static final Logger log = LoggerFactory.getLogger(BaseLanguageDAOImpl.class);
	
	@Override
	public List<?> findAll() {
		log.debug("DAO:返回所有的 语种");
		try {
			return getHibernateTemplate().loadAll(BaseLanguage.class);
		} catch (DataAccessException e) {
			log.error("返回所有的语种失败", e);
		}
		return null;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
	
}
