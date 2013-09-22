package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

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
		SysFunction sysFunction = (SysFunction) sysFunctionDAO.findByPK("8a80cd8e40fd523c0140fd5251060001", SysFunction.class);
		SysFunction function = new SysFunction();
		function.setFunctionName("查看原文");
		function.setFunctionType(GlobalUtil.isBtn);
		function.setRemark(sysFunction.getRemark() + "》查看原文");
		function.setParent(sysFunction);
		function.setOperTime(new Date());
		
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
