package order.hq.basic.dao.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
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
		try {
			ZipFile zipFile = new ZipFile("D:\\test.zip");
			ArrayList<File> files = new ArrayList<File>();
			files.add(new File("D:\\HQ.DMP"));
			files.add(new File("D:\\export.log"));
			
			ZipParameters zipParameters = new ZipParameters();
			zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			zipFile.addFiles(files, zipParameters);
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		SysFunctionDAO sysFunctionDAO = (SysFunctionDAO) factory.getBean("sysFunctionDAO");
		SysFunction sysFunction = (SysFunction) sysFunctionDAO.findByPK("4028848c41580fe30141580fe9f10001", SysFunction.class);
		SysFunction function = new SysFunction();
		function.setFunctionName("下载译文");
		function.setFunctionType(GlobalUtil.isBtn);
		function.setRemark(sysFunction.getRemark() + "》下载译文");
//		function.setRemark("》反馈译文");
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
