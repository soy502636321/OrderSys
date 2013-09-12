package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import order.hq.basic.dao.ConfigSysOrderStateDAO;
import order.hq.basic.database.entity.ConfigSysOrderState;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigSysOrderStateDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindInitate() {
		ConfigSysOrderStateDAO configSysOrderStateDAO = (ConfigSysOrderStateDAO) factory.getBean("configSysOrderStateDAO");
		ConfigSysOrderState configSysOrderState = configSysOrderStateDAO.findInitate();
		System.out.println(":" + configSysOrderState);
//		ConfigSysOrderState configSysOrderState = new ConfigSysOrderState();
//		configSysOrderState.setStateName("新订单");
//		configSysOrderState.setRemark("用户刚下单，还未被业务员接收的订单状态");
		
//		configSysOrderStateDAO.save(configSysOrderState);
	}

	@Test
	public void testFindAccept() {
		ConfigSysOrderStateDAO configSysOrderStateDAO = (ConfigSysOrderStateDAO) factory.getBean("configSysOrderStateDAO");
		ConfigSysOrderState configSysOrderState = configSysOrderStateDAO.findAccept();
		System.out.println(":" + configSysOrderState);
//		ConfigSysOrderState configSysOrderState = new ConfigSysOrderState();
//		configSysOrderState.setStateName("已接受");
//		configSysOrderState.setRemark("已被业务员接受，但是还未成交的订单状态");
		
//		configSysOrderStateDAO.save(configSysOrderState);
	}

	@Test
	public void testFindTurnover() {
		ConfigSysOrderStateDAO configSysOrderStateDAO = (ConfigSysOrderStateDAO) factory.getBean("configSysOrderStateDAO");
		ConfigSysOrderState configSysOrderState = configSysOrderStateDAO.findTurnover();
		System.out.println(":" + configSysOrderState);
		
//		ConfigSysOrderState configSysOrderState = new ConfigSysOrderState();
//		configSysOrderState.setStateName("已成交");
//		configSysOrderState.setRemark("已成交的订单，但是还未完成");
//		
//		configSysOrderStateDAO.save(configSysOrderState);
	}

	@Test
	public void testFindComplete() {
		ConfigSysOrderStateDAO configSysOrderStateDAO = (ConfigSysOrderStateDAO) factory.getBean("configSysOrderStateDAO");
		ConfigSysOrderState configSysOrderState = configSysOrderStateDAO.findComplete();
		System.out.println(":" + configSysOrderState);
		
//		ConfigSysOrderState configSysOrderState = new ConfigSysOrderState();
//		configSysOrderState.setStateName("已完成");
//		configSysOrderState.setRemark("订单已经完成");
//		
//		configSysOrderStateDAO.save(configSysOrderState);
	}

	@Test
	public void testFindCancel() {
		ConfigSysOrderStateDAO configSysOrderStateDAO = (ConfigSysOrderStateDAO) factory.getBean("configSysOrderStateDAO");
		ConfigSysOrderState configSysOrderState = configSysOrderStateDAO.findCancel();
		System.out.println(":" + configSysOrderState);
//		
//		ConfigSysOrderState configSysOrderState = new ConfigSysOrderState();
//		configSysOrderState.setStateName("已作废");
//		configSysOrderState.setRemark("订单已经作废");
//		
//		configSysOrderStateDAO.save(configSysOrderState);	
	}

}
