package order.hq.web.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.struts2.ServletActionContext;

import order.hq.basic.dao.BaseMasterFileDAO;
import order.hq.basic.database.entity.BaseMasterFile;
import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.service.BaseMasterFileService;

public class BaseMasterFileServiceImpl implements BaseMasterFileService {
	private BaseMasterFileDAO baseMasterFileDAO;

	@Override
	public PaginatedList queryBaseMasterFile(PaginatedList paginatedList, BaseMasterFileVO baseMasterFileVO,
			SysUserVO sysUserVO) {
		return getBaseMasterFileDAO().queryBaseMasterFile(paginatedList, baseMasterFileVO, sysUserVO);
	}

	@Override
	public InputStream createZipStream(String[] cbIds) {
		InputStream inputStream = null;
		try {
			List<BaseMasterFile> masterFiles = getBaseMasterFileDAO().findByPK(cbIds);
			if (!SystemUtil.isNull(masterFiles)) {
				String string = ServletActionContext.getServletContext().getRealPath("/");
				File file = new File(string + UUID.randomUUID() + ".zip");
				ZipFile zipFile = new ZipFile(file);
				ZipParameters zipParameters = new ZipParameters();
				zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
				zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
				ArrayList<File> files = new ArrayList<File>();
				for (BaseMasterFile masterFile : masterFiles) {
					File readFile = new File(string + masterFile.getMasterFileLocation());
					files.add(readFile);
				}
				zipFile.addFiles(files, zipParameters);
				inputStream = new FileInputStream(file);
			}
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
	
	public BaseMasterFileDAO getBaseMasterFileDAO() {
		return baseMasterFileDAO;
	}

	public void setBaseMasterFileDAO(BaseMasterFileDAO baseMasterFileDAO) {
		this.baseMasterFileDAO = baseMasterFileDAO;
	}

}
