package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import order.hq.basic.dao.BaseLanguageDAO;
import order.hq.basic.dao.ConfigSysOrderStateDAO;
import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.BaseLanguage;
import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.database.entity.SysUser;
import order.hq.util.PaginatedList;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysOrderDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		
	}

	@Test
	public void testCreateOrderNo() {
		
	}
	
	@Test
	public void testFuerySysOrder() {
		SysOrderDAO sysOrderDAO = (SysOrderDAO) factory.getBean("sysOrderDAO");
		PaginatedList paginatedList = new PaginatedList();
		paginatedList = sysOrderDAO.querySysOrder(paginatedList, null, null, null);
		
		System.out.println("集合:" + paginatedList.getList());
		System.out.println("统计:" + paginatedList.getFullListSize());
	}

	@Test
	public void testSave() {
		SysOrderDAO sysOrderDAO = (SysOrderDAO) factory.getBean("sysOrderDAO");
		SysUserDAO sysUserDAO = (SysUserDAO) factory.getBean("sysUserDAO");
		ConfigSysOrderStateDAO configSysOrderStateDAO = (ConfigSysOrderStateDAO) factory.getBean("configSysOrderStateDAO");
		BaseLanguageDAO baseLanguageDAO = (BaseLanguageDAO) factory.getBean("baseLanguageDAO");
		List<BaseLanguage> languages = (List<BaseLanguage>) baseLanguageDAO.findAll();
		
		SysUser sysUser = (SysUser) sysUserDAO.findByPK("admin", SysUser.class);
		
		SysOrder sysOrder = new SysOrder();
		sysOrder.setOperUser(sysUser);
		String orderNo = sysOrderDAO.createOrderNo();
		sysOrder.setOrderNo(orderNo);
		ConfigSysOrderState configSysOrderState = configSysOrderStateDAO.findCancel();
		sysOrder.setOrderState(configSysOrderState);
		sysOrder.setStartLanguage(languages.get(0));
		sysOrder.setEndLanguage(languages.get(1));
		sysOrder.setSubmitTime(new Date());
		
		sysOrderDAO.save(sysOrder);
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
