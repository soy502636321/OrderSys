package order.hq.basic.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import order.hq.basic.dao.AbstractBaseDAO;
import order.hq.basic.dao.BaseTranslatedFileDAO;
import order.hq.basic.database.entity.BaseTranslatedFile;

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
	public Logger getLogger() {
		return log;
	}
	
	
}
