package order.hq.web.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import order.hq.basic.database.entity.BaseMasterFile;
import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.basic.vo.BaseMasterFileVO;
import order.hq.basic.vo.BaseTranslatedFileVO;
import order.hq.basic.vo.SysOrderVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.GlobalUtil;
import order.hq.util.PaginatedList;
import order.hq.web.service.BaseMasterFileService;
import order.hq.web.service.BaseTranslatedFileService;
import order.hq.web.service.ConfigSysOrderStateService;
import order.hq.web.service.SysOrderService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private HttpServletRequest request;

	private PaginatedList paginatedList;
	private int page = 1;
	private String[] cbId;

	// VO
	private SysOrderVO sysOrderVO;
	private BaseMasterFileVO baseMasterFileVO;
	private BaseTranslatedFileVO baseTranslatedFileVO;

	// SERVICE
	private SysOrderService sysOrderService;
	private ConfigSysOrderStateService configSysOrderStateService;
	private BaseMasterFileService baseMasterFileService;
	private BaseTranslatedFileService baseTranslatedFileService;

	// 订单状态
	private ConfigSysOrderState cancel;
	private ConfigSysOrderState complete;
	private ConfigSysOrderState turnover;
	private ConfigSysOrderState accept;
	private ConfigSysOrderState initate;

	// 下载文件流对象
	private InputStream downloadStream;
	private String downloadFileName;

	// 处理上传文件的对象
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public SysUserVO getLoginVO() {
		SysUserVO sysUserVO = (SysUserVO) getSession()
				.get(GlobalUtil.LOGINUSER);
		return sysUserVO;
	}

	public PaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(PaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String[] getCbId() {
		return cbId;
	}

	public void setCbId(String[] cbId) {
		this.cbId = cbId;
	}

	public SysOrderVO getSysOrderVO() {
		return sysOrderVO;
	}

	public void setSysOrderVO(SysOrderVO sysOrderVO) {
		this.sysOrderVO = sysOrderVO;
	}

	public BaseMasterFileVO getBaseMasterFileVO() {
		return baseMasterFileVO;
	}

	public void setBaseMasterFileVO(BaseMasterFileVO baseMasterFileVO) {
		this.baseMasterFileVO = baseMasterFileVO;
	}

	public BaseTranslatedFileVO getBaseTranslatedFileVO() {
		return baseTranslatedFileVO;
	}

	public void setBaseTranslatedFileVO(
			BaseTranslatedFileVO baseTranslatedFileVO) {
		this.baseTranslatedFileVO = baseTranslatedFileVO;
	}

	public ConfigSysOrderState getCancel() {
		return cancel;
	}

	public void setCancel(ConfigSysOrderState cancel) {
		this.cancel = cancel;
	}

	public ConfigSysOrderState getComplete() {
		return complete;
	}

	public void setComplete(ConfigSysOrderState complete) {
		this.complete = complete;
	}

	public ConfigSysOrderState getTurnover() {
		return turnover;
	}

	public void setTurnover(ConfigSysOrderState turnover) {
		this.turnover = turnover;
	}

	public ConfigSysOrderState getAccept() {
		return accept;
	}

	public void setAccept(ConfigSysOrderState accept) {
		this.accept = accept;
	}

	public ConfigSysOrderState getInitate() {
		return initate;
	}

	public void setInitate(ConfigSysOrderState initate) {
		this.initate = initate;
	}

	public SysOrderService getSysOrderService() {
		return sysOrderService;
	}

	public void setSysOrderService(SysOrderService sysOrderService) {
		this.sysOrderService = sysOrderService;
	}

	public ConfigSysOrderStateService getConfigSysOrderStateService() {
		return configSysOrderStateService;
	}

	public void setConfigSysOrderStateService(
			ConfigSysOrderStateService configSysOrderStateService) {
		this.configSysOrderStateService = configSysOrderStateService;
	}

	public BaseMasterFileService getBaseMasterFileService() {
		return baseMasterFileService;
	}

	public void setBaseMasterFileService(
			BaseMasterFileService baseMasterFileService) {
		this.baseMasterFileService = baseMasterFileService;
	}

	public BaseTranslatedFileService getBaseTranslatedFileService() {
		return baseTranslatedFileService;
	}

	public void setBaseTranslatedFileService(
			BaseTranslatedFileService baseTranslatedFileService) {
		this.baseTranslatedFileService = baseTranslatedFileService;
	}

	public InputStream getDownloadStream() {
		return downloadStream;
	}

	public void setDownloadStream(InputStream downloadStream) {
		this.downloadStream = downloadStream;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
