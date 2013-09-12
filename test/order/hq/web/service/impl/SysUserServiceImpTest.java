package order.hq.web.service.impl;

import static org.junit.Assert.*;

import order.hq.basic.vo.SysUserVO;
import order.hq.web.service.SysUserService;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysUserServiceImpTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindByPK() {
		String userPid = "admin";
		SysUserService sysUserService = (SysUserService) factory.getBean("sysUserService");
		SysUserVO sysUserVO = sysUserService.findByPK(userPid);
		System.out.println("是否为空:" + sysUserVO);
	}

	@Test
	public void testAddSysUser() {
		
	}

	@Test
	public void testDelteSysUser() {
		
	}

	@Test
	public void testFindByUserName() {
		
	}

	@Test
	public void testUpdateSysUser() {
		
	}

	@Test
	public void testUpdatePassword() {
		
	}

	@Test
	public void testFindSysFunctionAll() {
		
	}

	@Test
	public void testSetSysFunctionDAO() {
		
	}

	@Test
	public void testSetSysUserDAO() {
		
	}

	@Test
	public void testGetSysUserDAO() {
		
	}

	@Test
	public void testGetSysFunctionDAO() {
		
	}

}
