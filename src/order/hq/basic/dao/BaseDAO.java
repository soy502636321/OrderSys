package order.hq.basic.dao;

import java.io.Serializable;
import java.util.List;

import order.hq.basic.database.entity.SysSection;

public interface BaseDAO {
	
	public void save(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
	public Object findByPK(Serializable serializable, String string);
	
	public Object findByPK(Serializable serializable, Class<?> clazz);
	
	public List<?> findAll();
	
}
