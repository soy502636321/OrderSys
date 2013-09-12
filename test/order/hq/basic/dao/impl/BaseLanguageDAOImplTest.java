package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import order.hq.basic.dao.BaseLanguageDAO;
import order.hq.basic.database.entity.BaseLanguage;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseLanguageDAOImplTest {
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
		BaseLanguageDAO baseLanguageDAO = (BaseLanguageDAO) factory.getBean("baseLanguageDAO");
		BaseLanguage language = new BaseLanguage();
		language.setLanguageName("英文");
		language.setRemark("英文");
		
		baseLanguageDAO.save(language);
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
