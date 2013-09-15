package order.hq.basic.database.entity;

import java.io.Serializable;

public class BaseTranslatedFile implements Serializable {

	private static final long serialVersionUID = 1L;

	private String translatedFilePid;
	private String translatedFileName;
	private long translatedFileSize;
	private String translatedFileLocation;

	private SysOrder sysOrder;
	private SysFeedback sysFeedback;

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

	
}
