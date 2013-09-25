package order.hq.web.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface BaseMasterFileService {
	public PaginatedList queryBaseMasterFile(PaginatedList paginatedList, BaseMasterFileVO baseMasterFileVO, SysUserVO sysUserVO);

	public InputStream createZipStream(String[] cbId);

	public int saveBaseMasterFile(List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String sysOrderPid, SysUserVO loginVO);

	public int deleteMasterFile(String[] cbId, SysUserVO loginVO);
}