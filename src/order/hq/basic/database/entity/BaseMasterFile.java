package order.hq.basic.database.entity;

import java.io.File;

public class BaseMasterFile {
	private String masterFilePid; // 原文文件主键
	private String masterFileName; // 原文文件名字
	private long masterFileSize; // 原文文件大小
	private String masterFileLocation; // 原文文件位置(相对位置)

	private SysOrder sysOrder;

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

}
