package order.hq.basic.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractBaseDAO extends HibernateDaoSupport implements BaseDAO {

	@Override
	public void save(Object obj) {
		try {
			getHibernateTemplate().save(obj);
		} catch (DataException e) {
			getLogger().error("增加记录失败，异常信息:"+e);
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object obj) {
		try {
			getHibernateTemplate().update(obj);
		} catch (DataAccessException e) {
			getLogger().error("更新记录失败，异常信息:" + e);
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Object obj) {
		try {
			getHibernateTemplate().delete(obj);
		} catch (DataAccessException e) {
			getLogger().error("删除记录失败，异常信息:" + e);
			e.printStackTrace();
		}
	}

	@Override
	public Object findByPK(Serializable serializable, String string) {
		try {
			return getHibernateTemplate().get(string, serializable);
		} catch (DataAccessException e) {
			getLogger().error("根据主键、类型名字返回记录，异常信息:" + e);
			throw e;
		}
	}
	
	@Override
	public Object findByPK(Serializable serializable, Class<?> clazz) {
		try {
			return getHibernateTemplate().get(clazz, serializable);
		} catch (DataAccessException e) {
			getLogger().error("根据主键、Class返回记录，异常信息:" + e);
			throw e;
		}
	}

	@Override
	public abstract List<?> findAll();
	
	public abstract Logger getLogger();
}
