package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import order.hq.basic.dao.BaseOrganDAO;
import order.hq.basic.dao.SysSectionDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.BaseOrgan;
import order.hq.basic.database.entity.SysSection;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PasswordControl;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysUserDAOImplTest {
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
		SysUserDAO sysUserDAO = (SysUserDAO) factory.getBean("sysUserDAO");
		SysSectionDAO sysSectionDAO = (SysSectionDAO) factory.getBean("sysSectionDAO");
		
		List<SysSection> sysSections = (List<SysSection>) sysSectionDAO.findAll();
		SysUser sysUser = new SysUser();
		sysUser.setUserPid("admin");
		String password = PasswordControl.EncryptePassword("123");
		sysUser.setPassword(password);
		sysUser.setSysSection(sysSections.get(0));
		sysUser.setUserState("01");
		
		sysUserDAO.save(sysUser);
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
