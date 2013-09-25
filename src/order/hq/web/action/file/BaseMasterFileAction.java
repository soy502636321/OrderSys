package order.hq.web.action.file;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.util.DateUtil;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.BaseAction;
import order.hq.web.service.BaseMasterFileService;

public class BaseMasterFileAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(BaseMasterFileAction.class);

	private BaseMasterFileService baseMasterFileService;
	
	private BaseMasterFileVO baseMasterFileVO;

	public String query() {
		log.debug("ACTION:订单原文件列表");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getBaseMasterFileService().queryBaseMasterFile(paginatedList, getBaseMasterFileVO(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_MASTERFILE_PAGE;
	}
	
	public String queryShow() {
		query();
		return "show_Query";
	}
	
	public String add() {
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String save() {
		if (!SystemUtil.isNull(getUpload()) && getBaseMasterFileVO() != null) {
			System.out.println("1");
			int i = getBaseMasterFileService().saveBaseMasterFile(getUpload(), getUploadFileName(), getUploadContentType(), getBaseMasterFileVO().getSysOrderPid(), getLoginVO());
			System.out.println("2");
			addActionMessage("成功上传【" + i + "】个原文文件");
			return query();
		} else {
			addActionError("请先选择要上传的文件");
			return ForwardUtil.FORWARD_ADD_PAGE;
		}
	}
	
	public String download() {
		log.debug("");
		if (!SystemUtil.isNull(getCbId())) {
			InputStream inputStream = getBaseMasterFileService().createZipStream(getCbId());
			setDownloadStream(inputStream);
			setDownloadFileName(DateUtil.getTime() + ".zip");
		} else {
			addActionError("请先选择原文记录再点击下载按钮");
			return query();
		}
		return "download";
	}
	
	public String delete() {
		log.debug("");
		if (!SystemUtil.isNull(getCbId())) {
			int i = getBaseMasterFileService().deleteMasterFile(getCbId(), getLoginVO());
			addActionMessage("成功删除【" + i + "】个原文");
		} else {
			addActionError("请先选择原文记录");
		}
		return query();
	}
	
	public String back() {
		return query();
	}

	public BaseMasterFileService getBaseMasterFileService() {
		return baseMasterFileService;
	}

	public void setBaseMasterFileService(
			BaseMasterFileService baseMasterFileService) {
		this.baseMasterFileService = baseMasterFileService;
	}

	public BaseMasterFileVO getBaseMasterFileVO() {
		return baseMasterFileVO;
	}

	public void setBaseMasterFileVO(BaseMasterFileVO baseMasterFileVO) {
		this.baseMasterFileVO = baseMasterFileVO;
	}

	
}