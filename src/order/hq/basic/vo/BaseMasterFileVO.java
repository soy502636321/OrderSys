package order.hq.basic.vo;

import java.util.Date;

import order.hq.basic.database.entity.BaseMasterFile;
import order.hq.basic.database.entity.SysOrder;
import order.hq.basic.database.entity.SysUser;

public class BaseMasterFileVO {
	private BaseMasterFile baseMasterFile;

	private String masterFilePid; // 原文文件主键
	private String masterFileName; // 原文文件名字
	private long masterFileSize; // 原文文件大小
	private String masterFileLocation; // 原文文件位置(相对位置)
	private Date operTime; // 上传日期
	private SysUser operUser; // 上传人
	private long downloadSize; // 下载次数

	private SysOrder sysOrder;
	private String sysOrderPid;
	private String sysOrderNo;

	public BaseMasterFileVO() {
	}

	public BaseMasterFileVO(BaseMasterFile baseMasterFile) {
		this.baseMasterFile = baseMasterFile;
	}

	public BaseMasterFile getBaseMasterFile() {
		return baseMasterFile;
	}

	public void setBaseMasterFile(BaseMasterFile baseMasterFile) {
		this.baseMasterFile = baseMasterFile;
	}

	public String getMasterFilePid() {
		if (getBaseMasterFile() != null && masterFilePid == null) {
			masterFilePid = getBaseMasterFile().getMasterFilePid();
		}
		return masterFilePid;
	}

	public void setMasterFilePid(String masterFilePid) {
		this.masterFilePid = masterFilePid;
	}

	public String getMasterFileName() {
		if (getBaseMasterFile() != null && masterFileName == null) {
			masterFileName = getBaseMasterFile().getMasterFileName();
		}
		return masterFileName;
	}

	public void setMasterFileName(String masterFileName) {
		this.masterFileName = masterFileName;
	}

	public long getMasterFileSize() {
		if (getBaseMasterFile() != null && masterFileSize == 0L) {
			masterFileSize = getBaseMasterFile().getMasterFileSize();
		}
		return masterFileSize;
	}

	public void setMasterFileSize(long masterFileSize) {
		this.masterFileSize = masterFileSize;
	}

	public String getMasterFileLocation() {
		if (getBaseMasterFile() != null && masterFileLocation == null) {
			masterFileLocation = getBaseMasterFile().getMasterFileLocation();
		}
		return masterFileLocation;
	}

	public void setMasterFileLocation(String masterFileLocation) {
		this.masterFileLocation = masterFileLocation;
	}

	public SysOrder getSysOrder() {
		if (getBaseMasterFile() != null && sysOrder == null) {
			sysOrder = getBaseMasterFile().getSysOrder();
		}
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
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

	public Date getOperTime() {
		if (getBaseMasterFile() != null && operTime == null) {
			operTime = getBaseMasterFile().getOperTime();
		}
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public SysUser getOperUser() {
		if (getBaseMasterFile() != null && operUser == null) {
			operUser = getBaseMasterFile().getOperUser();
		}
		return operUser;
	}

	public void setOperUser(SysUser operUser) {
		this.operUser = operUser;
	}

	public long getDownloadSize() {
		if (getBaseMasterFile() != null && downloadSize == 0) {
			downloadSize = getBaseMasterFile().getDownloadSize();
		}
		return downloadSize;
	}

	public void setDownloadSize(long downloadSize) {
		this.downloadSize = downloadSize;
	}

	public String getSysOrderNo() {
		if (getSysOrder() != null && sysOrderNo == null) {
			sysOrderNo = getSysOrder().getOrderNo();
		}
		return sysOrderNo;
	}

	public void setSysOrderNo(String sysOrderNo) {
		this.sysOrderNo = sysOrderNo;
	}

}
