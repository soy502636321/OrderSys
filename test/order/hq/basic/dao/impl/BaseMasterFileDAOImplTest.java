package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import order.hq.basic.dao.BaseMasterFileDAO;
import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.database.entity.BaseMasterFile;
import order.hq.basic.database.entity.SysOrder;
import order.hq.util.PaginatedList;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseMasterFileDAOImplTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testGetLogger() {
		
	}
	
	@Test
	public void testQueryBaseMasterFile() {
		BaseMasterFileDAO baseMasterFileDAO = (BaseMasterFileDAO) factory.getBean("baseMasterFileDAO");
		PaginatedList paginatedList = new PaginatedList(1);
		paginatedList = baseMasterFileDAO.queryBaseMasterFile(paginatedList, null, null);
		System.out.println(paginatedList.getList());
	}

	@Test
	public void testSave() {
		BaseMasterFileDAO baseMasterFileDAO = (BaseMasterFileDAO) factory.getBean("baseMasterFileDAO");
		SysOrderDAO sysOrderDAO = (SysOrderDAO) factory.getBean("sysOrderDAO");
		List<SysOrder> sysOrders = (List<SysOrder>) sysOrderDAO.findAll();
		
		BaseMasterFile masterFile = new BaseMasterFile();
		masterFile.setMasterFileName("测试文件.txt");
		masterFile.setMasterFileSize(400L);
		masterFile.setMasterFileLocation("电脑中");
		masterFile.setSysOrder(sysOrders.get(0));
		
		baseMasterFileDAO.save(masterFile);
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
