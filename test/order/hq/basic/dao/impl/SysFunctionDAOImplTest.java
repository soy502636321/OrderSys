package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import order.hq.basic.dao.SysFunctionDAO;
import order.hq.basic.database.entity.SysFunction;
import order.hq.util.GlobalUtil;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysFunctionDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		
	}

	@Test
	public void testSave() {
		SysFunctionDAO sysFunctionDAO = (SysFunctionDAO) factory.getBean("sysFunctionDAO");
		SysFunction sysFunction = (SysFunction) sysFunctionDAO.findByPK("ff80808140fc52030140fc5215420001", SysFunction.class);
		SysFunction function = new SysFunction();
		function.setFunctionName("查看指示");
		function.setFunctionUrl("publicInitateSysOrderAction!findSysShow");
		function.setFunctionType(GlobalUtil.isBtn);
		function.setParent(sysFunction);
		function.setRemark("订单管理》新订单》查看指示");
		
		sysFunctionDAO.save(function);
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
