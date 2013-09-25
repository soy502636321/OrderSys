package order.hq.basic.database.entity;

import java.io.File;
import java.util.Date;

public class BaseMasterFile {
	private String masterFilePid; // 原文文件主键
	private String masterFileName; // 原文文件名字
	private long masterFileSize; // 原文文件大小
	private String masterFileLocation; // 原文文件位置(相对位置)
	private Date operTime; //上传日期
	private SysUser operUser; //上传人
	private long downloadSize; //下载次数
	
	private SysOrder sysOrder;
	
	public BaseMasterFile() {
	}

	public BaseMasterFile(File saveFile, String string, SysOrder sysOrder,
			SysUser sysUser) {
		this.masterFileName = saveFile.getName();
		this.masterFileSize = saveFile.length();
		this.masterFileLocation = string;
		this.operTime = new Date();
		this.operUser = sysUser;
		this.sysOrder = sysOrder;
	}

	public String getMasterFilePid() {
		return masterFilePid;
	}

	public void setMasterFilePid(String masterFilePid) {
		this.masterFilePid = masterFilePid;
	}

	public String getMasterFileName() {
		return masterFileName;
	}

	public void setMasterFileName(String masterFileName) {
		this.masterFileName = masterFileName;
	}

	public long getMasterFileSize() {
		return masterFileSize;
	}

	public void setMasterFileSize(long masterFileSize) {
		this.masterFileSize = masterFileSize;
	}

	public String getMasterFileLocation() {
		return masterFileLocation;
	}

	public void setMasterFileLocation(String masterFileLocation) {
		this.masterFileLocation = masterFileLocation;
	}

	public SysOrder getSysOrder() {
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public SysUser getOperUser() {
		return operUser;
	}

	public void setOperUser(SysUser operUser) {
		this.operUser = operUser;
	}

	public long getDownloadSize() {
		return downloadSize;
	}

	public void setDownloadSize(long downloadSize) {
		this.downloadSize = downloadSize;
	}

}
