package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import order.hq.basic.dao.ConfigSysFeedbackStateDAO;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.database.entity.SysFeedback;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigSysFeedbackStateDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		ConfigSysFeedbackStateDAO configSysFeedbackStateDAO = (ConfigSysFeedbackStateDAO) factory.getBean("configSysFeedbackStateDAO");
		List<?> list = configSysFeedbackStateDAO.findAll();
		
		for (Object object : list) {
			System.out.println(object);
		}
	}

	@Test
	public void testSave() {
		ConfigSysFeedbackStateDAO configSysFeedbackStateDAO = (ConfigSysFeedbackStateDAO) factory.getBean("configSysFeedbackStateDAO");
		ConfigSysFeedbackState state = new ConfigSysFeedbackState();
		state.setStateName("处理完");
		state.setRemark("业务员已经处理完成该反馈");
		
		configSysFeedbackStateDAO.save(state);
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
