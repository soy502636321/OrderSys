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

import order.hq.basic.dao.BaseTranslatedFileDAO;
import order.hq.basic.dao.SysOrderDAO;
import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.database.entity.SysUser;
import order.hq.basic.vo.BaseTranslatedFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.DateUtil;
import order.hq.util.FileUtil;
import order.hq.util.PaginatedList;
import order.hq.util.StringUtil;
import order.hq.util.SystemUtil;
import order.hq.web.action.BaseAction;
import order.hq.web.service.BaseTranslatedFileService;

public class BaseTranslatedFileServiceImpl implements BaseTranslatedFileService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseTranslatedFileServiceImpl.class);

	private BaseTranslatedFileDAO baseTranslatedFileDAO;
	private SysOrderDAO sysOrderDAO;

	@Override
	public int deleteTranslatedFile(String[] cbId, SysUserVO loginVO) {
		return getBaseTranslatedFileDAO().delete(cbId, loginVO);
	}

	@Override
	public PaginatedList queryBaseTranslatedFile(PaginatedList paginatedList,
			BaseTranslatedFileVO baseTranslatedFileVO, SysUserVO loginVO) {
		return getBaseTranslatedFileDAO().queryBaseTranslatedFile(
				paginatedList, baseTranslatedFileVO, loginVO);
	}

	@Override
	public InputStream createZipStream(String[] cbIds) {
		InputStream inputStream = null;
		try {
			List<BaseTranslatedFile> translatedFiles = getBaseTranslatedFileDAO()
					.findByPK(cbIds);
			if (!SystemUtil.isNull(translatedFiles)) {
				String string = ServletActionContext.getServletContext()
						.getRealPath("/");
				File file = new File(string + UUID.randomUUID() + ".zip");
				ZipFile zipFile = new ZipFile(file);
				ZipParameters zipParameters = new ZipParameters();
				zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
				zipParameters
						.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
				ArrayList<File> files = new ArrayList<File>();
				for (BaseTranslatedFile translatedFile : translatedFiles) {
					File readFile = new File(string
							+ translatedFile.getTranslatedFileLocation());
					files.add(readFile);
				}
				System.out.println("OK");
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
	public int saveBaseTranslatedFile(List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String sysOrderPid, SysUserVO sysUserVO) {
		int size = 0;
		if (!SystemUtil.isNull(upload) && !StringUtil.isNull(sysOrderPid)) {
			SysOrder sysOrder = (SysOrder) getSysOrderDAO().findByPK(sysOrderPid, SysOrder.class);
			if (sysOrder != null) {
				try {
					String path = ServletActionContext.getServletContext().getRealPath("/");
					for (int i = 0; i < upload.size(); i++) {
						File file = upload.get(i);
						String fileName = uploadFileName.get(i);
						StringBuffer relatively = new StringBuffer("BaseTranslatedFile").append(File.separator)
							.append(DateUtil.getDate()).append(File.separator).append(UUID.randomUUID()).append(File.separator);
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
						BaseTranslatedFile translatedFile = new BaseTranslatedFile(saveFile, relatively.toString(), sysOrder, sysUserVO.getSysUser());
						
						getBaseTranslatedFileDAO().save(translatedFile);
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

	public BaseTranslatedFileDAO getBaseTranslatedFileDAO() {
		return baseTranslatedFileDAO;
	}

	public void setBaseTranslatedFileDAO(
			BaseTranslatedFileDAO baseTranslatedFileDAO) {
		this.baseTranslatedFileDAO = baseTranslatedFileDAO;
	}

	public SysOrderDAO getSysOrderDAO() {
		return sysOrderDAO;
	}

	public void setSysOrderDAO(SysOrderDAO sysOrderDAO) {
		this.sysOrderDAO = sysOrderDAO;
	}
	
	

}
