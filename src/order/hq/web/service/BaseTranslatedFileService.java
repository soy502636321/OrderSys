package order.hq.web.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import order.hq.basic.vo.BaseTranslatedFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface BaseTranslatedFileService {

	public int deleteTranslatedFile(String[] cbId, SysUserVO loginVO);

	public PaginatedList queryBaseTranslatedFile(PaginatedList paginatedList,
			BaseTranslatedFileVO baseTranslatedFileVO, SysUserVO loginVO);

	public InputStream createZipStream(String[] cbId);

	public int saveBaseTranslatedFile(List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String sysOrderPid, SysUserVO sysUserVO);

}
