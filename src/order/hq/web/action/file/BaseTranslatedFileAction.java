package order.hq.web.action.file;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.vo.SysOrderVO;
import order.hq.util.DateUtil;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.BaseAction;

public class BaseTranslatedFileAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BaseTranslatedFileAction.class);

	public String query() {
		log.debug("ACTION:");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getBaseTranslatedFileService().queryBaseTranslatedFile(paginatedList, getBaseTranslatedFileVO(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}
	
	public String queryShow() {
		query();
		return "show_Query";
	}
	
	public String add() {
		log.debug("");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String save() {
		if (!SystemUtil.isNull(getUpload()) && getBaseTranslatedFileVO() != null) {
			int i = getBaseTranslatedFileService().saveBaseTranslatedFile(getUpload(), getUploadFileName(), getUploadContentType(), getBaseTranslatedFileVO().getSysOrderPid(), getLoginVO());
			addActionMessage("成功上传【" + i + "】个译文文件");
			return query();
		} else {
			addActionError("请先选择要上传的文件");
			return ForwardUtil.FORWARD_ADD_PAGE;
		}
		
	}
	
	public String delete() {
		log.debug("");
		if (!SystemUtil.isNull(getCbId())) {
			int i = getBaseTranslatedFileService().deleteTranslatedFile(
					getCbId(), getLoginVO());
			addActionMessage("成功删除【" + i + "】个译文");
		} else {
			addActionError("请先选择译文记录");
		}
		return query();
	}
	
	public String download() {
		log.debug("打包下载选择的译文文件");
		if (!SystemUtil.isNull(getCbId())) {
			InputStream inputStream = getBaseTranslatedFileService().createZipStream(getCbId());
			setDownloadStream(inputStream);
			setDownloadFileName(DateUtil.getTime() + ".zip");
		} else {
			addActionError("请先选择译文记录再点击下载按钮");
			return query();
		}
		return "download";
	}
	
	public String back() {
		log.debug("");
		return query();
	}
}
