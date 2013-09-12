package order.hq.basic.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.BaseMasterFileDAO;
import order.hq.basic.database.entity.BaseMasterFile;

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
	public Logger getLogger() {
		return log;
	}
	
}
