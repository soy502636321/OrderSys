package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import order.hq.basic.dao.SysSectionDAO;
import order.hq.basic.database.entity.SysSection;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysSectionDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		
	}

	@Test
	public void testFindAllStringBoolean() {
		
	}

	@Test
	public void testSave() {
		SysSectionDAO sysSectionDAO = (SysSectionDAO) factory.getBean("sysSectionDAO");
		SysSection sysSection = new SysSection();
		sysSection.setSectionName("管理员");
		sysSection.setRemark("拥有全部的权限");
		
		sysSectionDAO.save(sysSection);
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testFindByPKSerializableString() {
		
	}

	@Test
	public void testFindByPKSerializableClassOfQ() {
		
	}

}
