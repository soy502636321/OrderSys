package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import order.hq.basic.dao.BaseOrganDAO;
import order.hq.basic.dao.SysUserDAO;
import order.hq.basic.database.entity.BaseOrgan;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.SysUserVO;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysUserDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindAll() {
		BaseOrganDAO baseOrganDAO = (BaseOrganDAO) factory.getBean("baseOrganDAO");
		
		while (true) {
			List<BaseOrgan> baseOrgans = (List<BaseOrgan>) baseOrganDAO.findAll();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(dateFormat.format(new Date()) + " : " + baseOrgans.size());
			for (Object object : baseOrgans) {
				BaseOrgan baseOrgan =(BaseOrgan) object;
				System.out.println(baseOrgan.getOrganName());
			}
			
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testGetLogger() {
		
	}

	@Test
	public void testSave() {
		
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
