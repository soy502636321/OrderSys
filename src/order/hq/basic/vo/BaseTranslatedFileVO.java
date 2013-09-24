package order.hq.basic.vo;

import java.util.Date;

import order.hq.basic.database.entity.BaseTranslatedFile;
import order.hq.basic.database.entity.SysFeedback;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.database.entity.SysUser;

public class BaseTranslatedFileVO {
	private BaseTranslatedFile baseTranslatedFile;

	private String translatedFilePid;
	private String translatedFileName;
	private long translatedFileSize;
	private String translatedFileLocation;

	private Date operTime;
	private SysUser operUser;
	private long downloadSize;

	private SysOrder sysOrder;
	private String sysOrderPid;
	private SysFeedback sysFeedback;

	public BaseTranslatedFileVO() {
	}
	
	public BaseTranslatedFileVO(BaseTranslatedFile baseTranslatedFile) {
		this.baseTranslatedFile = baseTranslatedFile;
	}

	public BaseTranslatedFile getBaseTranslatedFile() {
		return baseTranslatedFile;
	}

	public void setBaseTranslatedFile(BaseTranslatedFile baseTranslatedFile) {
		this.baseTranslatedFile = baseTranslatedFile;
	}

	public String getTranslatedFilePid() {
		if (getBaseTranslatedFile() != null && translatedFilePid == null) {
			translatedFilePid = getBaseTranslatedFile().getTranslatedFilePid();
		}
		return translatedFilePid;
	}

	public void setTranslatedFilePid(String translatedFilePid) {
		this.translatedFilePid = translatedFilePid;
	}

	public String getTranslatedFileName() {
		if (getBaseTranslatedFile() != null && translatedFileName == null) {
			translatedFileName = getBaseTranslatedFile().getTranslatedFileName();
		}
		return translatedFileName;
	}

	public void setTranslatedFileName(String translatedFileName) {
		this.translatedFileName = translatedFileName;
	}

	public long getTranslatedFileSize() {
		if (getBaseTranslatedFile() != null && translatedFileSize == 0L) {
			translatedFileSize = getBaseTranslatedFile().getTranslatedFileSize();
		}
		return translatedFileSize;
	}

	public void setTranslatedFileSize(long translatedFileSize) {
		this.translatedFileSize = translatedFileSize;
	}

	public String getTranslatedFileLocation() {
		if (getBaseTranslatedFile() != null && translatedFileLocation == null) {
			translatedFileLocation = getBaseTranslatedFile().getTranslatedFileLocation();
		}
		return translatedFileLocation;
	}

	public void setTranslatedFileLocation(String translatedFileLocation) {
		this.translatedFileLocation = translatedFileLocation;
	}

	public Date getOperTime() {
		if (getBaseTranslatedFile() != null && operTime == null) {
			operTime = getBaseTranslatedFile().getOperTime();
		}
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public SysUser getOperUser() {
		if (getBaseTranslatedFile() != null && operUser == null) {
			operUser = getBaseTranslatedFile().getOperUser();
		}
		return operUser;
	}

	public void setOperUser(SysUser operUser) {
		this.operUser = operUser;
	}

	public long getDownloadSize() {
		if (getBaseTranslatedFile() != null && downloadSize == 0L) {
			downloadSize = getBaseTranslatedFile().getDownloadSize();
		}
		return downloadSize;
	}

	public void setDownloadSize(long downloadSize) {
		this.downloadSize = downloadSize;
	}

	public SysOrder getSysOrder() {
		if (getBaseTranslatedFile() != null && sysOrder == null) {
			sysOrder = getBaseTranslatedFile().getSysOrder();
		}
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public SysFeedback getSysFeedback() {
		if (getBaseTranslatedFile() != null && sysFeedback == null) {
			sysFeedback = getBaseTranslatedFile().getSysFeedback();
		}
		return sysFeedback;
	}

	public void setSysFeedback(SysFeedback sysFeedback) {
		this.sysFeedback = sysFeedback;
	}

	public String getSysOrderPid() {
		if (getSysOrder() != null && sysOrderPid == null) {
			sysOrderPid = getSysOrder().getOrderPid();
		}
		return sysOrderPid;
	}

	public void setSysOrderPid(String sysOrderPid) {
		this.sysOrderPid = sysOrderPid;
	}

}
