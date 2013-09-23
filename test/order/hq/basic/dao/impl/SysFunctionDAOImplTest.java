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
		SysFunction sysFunction = (SysFunction) sysFunctionDAO.findByPK("8a80c97b4120bee5014120befc9d0001", SysFunction.class);
		SysFunction function = new SysFunction();
		function.setFunctionName("反馈完成");
		function.setFunctionType(GlobalUtil.isBtn);
		function.setRemark(sysFunction.getRemark() + "》反馈完成");
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
