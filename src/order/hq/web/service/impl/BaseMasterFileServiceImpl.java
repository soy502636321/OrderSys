package order.hq.web.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.dao.BaseMasterFileDAO;
import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.database.entity.BaseMasterFile;
import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.DateUtil;
import order.hq.util.FileUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;
import order.hq.web.service.BaseMasterFileService;

public class BaseMasterFileServiceImpl implements BaseMasterFileService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseMasterFileServiceImpl.class);

	private BaseMasterFileDAO baseMasterFileDAO;
	private SysOrderDAO sysOrderDAO;

	@Override
	public PaginatedList queryBaseMasterFile(PaginatedList paginatedList,
			BaseMasterFileVO baseMasterFileVO, SysUserVO sysUserVO) {
		return getBaseMasterFileDAO().queryBaseMasterFile(paginatedList,
				baseMasterFileVO, sysUserVO);
	}

	@Override
	public InputStream createZipStream(String[] cbIds) {
		InputStream inputStream = null;
		try {
			List<BaseMasterFile> masterFiles = getBaseMasterFileDAO().findByPK(
					cbIds);
			if (!SystemUtil.isNull(masterFiles)) {
				String string = ServletActionContext.getServletContext()
						.getRealPath("/");
				File file = new File(string + UUID.randomUUID() + ".zip");
				ZipFile zipFile = new ZipFile(file);
				ZipParameters zipParameters = new ZipParameters();
				zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
				zipParameters
						.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
				ArrayList<File> files = new ArrayList<File>();
				for (BaseMasterFile masterFile : masterFiles) {
					File readFile = new File(string
							+ masterFile.getMasterFileLocation());
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

	@Override
	public int saveBaseMasterFile(List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String sysOrderPid, SysUserVO loginVO) {
		int size = 0;
		if (!SystemUtil.isNull(upload) && !StringUtil.isNull(sysOrderPid)) {
			SysOrder sysOrder = (SysOrder) getSysOrderDAO().findByPK(sysOrderPid, SysOrder.class);
			if (sysOrder != null) {
				try {
					String path = ServletActionContext.getServletContext().getRealPath("/");
					for (int i = 0; i < upload.size(); i++) {
						File file = upload.get(i);
						String fileName = uploadFileName.get(i);
						StringBuffer relatively = new StringBuffer(
								"BaseMasterFile").append(File.separator)
								.append(DateUtil.getDate())
								.append(File.separator)
								.append(UUID.randomUUID())
								.append(File.separator);
						File parentFile = new File(path + relatively.toString());
						if (!parentFile.exists()) {
							parentFile.mkdirs();
						}
						relatively.append(fileName);
						File saveFile = new File(path + relatively.toString());
						if (!saveFile.exists()) {
							saveFile.createNewFile();
						}
						FileUtil.copy(file, saveFile);
						BaseMasterFile masterFile = new BaseMasterFile(saveFile, relatively.toString(), sysOrder, loginVO.getSysUser());
						getBaseMasterFileDAO().save(masterFile);
						size++;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return size;
	}
	
	@Override
	public int deleteMasterFile(String[] cbIds, SysUserVO loginVO) {
		return getBaseMasterFileDAO().delete(cbIds, loginVO);
	}

	public BaseMasterFileDAO getBaseMasterFileDAO() {
		return baseMasterFileDAO;
	}

	public void setBaseMasterFileDAO(BaseMasterFileDAO baseMasterFileDAO) {
		this.baseMasterFileDAO = baseMasterFileDAO;
	}

	public SysOrderDAO getSysOrderDAO() {
		return sysOrderDAO;
	}

	public void setSysOrderDAO(SysOrderDAO sysOrderDAO) {
		this.sysOrderDAO = sysOrderDAO;
	}

}
