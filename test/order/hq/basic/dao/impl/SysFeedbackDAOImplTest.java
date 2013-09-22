package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import order.hq.basic.dao.SysFeedbackDAO;
import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.basic.database.entity.SysFeedback;
import order.hq.basic.database.entity.SysOrder;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SysFeedbackDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		
	}

	@Test
	public void testQuerySysFeedback() {
		
	}

	@Test
	public void testSave() {
		SysFeedbackDAO sysFeedbackDAO = (SysFeedbackDAO) factory.getBean("sysFeedbackDAO");
		SysOrderDAO sysOrderDAO = (SysOrderDAO) factory.getBean("sysOrderDAO");
//		ConfigSysFeedbackState initateFeedback = (ConfigSysFeedbackState) factory.getBean("initateFeedback");
		ConfigSysFeedbackState handleFeedback = (ConfigSysFeedbackState) factory.getBean("handleFeedback");
		ConfigSysFeedbackState completeFeedback = (ConfigSysFeedbackState) factory.getBean("completeFeedback");
		
		SysFeedback feedback = new SysFeedback();
//		feedback.setState(initateFeedback);
		feedback.setState(completeFeedback);
		
		List<?> list = sysOrderDAO.findAll();
		feedback.setSysOrder((SysOrder) list.get(0));
		
		sysFeedbackDAO.save(feedback);
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
