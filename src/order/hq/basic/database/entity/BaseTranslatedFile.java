package order.hq.basic.database.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class BaseTranslatedFile implements Serializable {

	private static final long serialVersionUID = 1L;

	private String translatedFilePid;
	private String translatedFileName;
	private long translatedFileSize;
	private String translatedFileLocation;

	private Date operTime;
	private SysUser operUser;
	private long downloadSize;

	private SysOrder sysOrder;
	private SysFeedback sysFeedback;
	
	public BaseTranslatedFile() {
	}

	public BaseTranslatedFile(File saveFile, String relatively, SysOrder sysOrder, SysUser sysUser) {
		this.sysOrder = sysOrder;
		this.operUser = sysUser;
		this.operTime = new Date();
		translatedFileName = saveFile.getName();
		translatedFileSize = saveFile.length();
		translatedFileLocation = relatively;
	}

	public String getTranslatedFilePid() {
		return translatedFilePid;
	}

	public void setTranslatedFilePid(String translatedFilePid) {
		this.translatedFilePid = translatedFilePid;
	}

	public String getTranslatedFileName() {
		return translatedFileName;
	}

	public void setTranslatedFileName(String translatedFileName) {
		this.translatedFileName = translatedFileName;
	}

	public long getTranslatedFileSize() {
		return translatedFileSize;
	}

	public void setTranslatedFileSize(long translatedFileSize) {
		this.translatedFileSize = translatedFileSize;
	}

	public String getTranslatedFileLocation() {
		return translatedFileLocation;
	}

	public void setTranslatedFileLocation(String translatedFileLocation) {
		this.translatedFileLocation = translatedFileLocation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SysOrder getSysOrder() {
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

	public SysFeedback getSysFeedback() {
		return sysFeedback;
	}

	public void setSysFeedback(SysFeedback sysFeedback) {
		this.sysFeedback = sysFeedback;
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
