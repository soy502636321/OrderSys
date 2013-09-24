package order.hq.basic.dao;

import java.util.List;

import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.vo.BaseTranslatedFileVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface BaseTranslatedFileDAO extends BaseDAO {

	public PaginatedList queryBaseTranslatedFile(PaginatedList paginatedList,
			BaseTranslatedFileVO baseTranslatedFileVO, SysUserVO loginVO);

	public List<BaseTranslatedFile> findByPK(String[] cbIds);

	public int delete(String[] cbId, SysUserVO loginVO);

}
