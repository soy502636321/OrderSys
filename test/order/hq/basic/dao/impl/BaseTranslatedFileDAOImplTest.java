package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import order.hq.basic.dao.BaseTranslatedFileDAO;
import order.hq.basic.database.entity.BaseTranslatedFile;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTranslatedFileDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		BaseTranslatedFileDAO baseTranslatedFileDAO = (BaseTranslatedFileDAO) factory.getBean("baseTranslatedFileDAO");
		BaseTranslatedFile file = new BaseTranslatedFile();
		file.setTranslatedFileLocation("测试译问.txt");
		file.setTranslatedFileName("测试译文.txt");
		file.setOperTime(new Date());
		
		baseTranslatedFileDAO.save(file);
	}

	@Test
	public void testQueryBaseTranslatedFile() {
		
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
