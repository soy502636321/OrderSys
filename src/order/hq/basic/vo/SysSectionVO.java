package order.hq.basic.vo;

import order.hq.basic.database.entity.SysSection;

public class SysSectionVO {
	private SysSection sysSection;

	private String sectionPid;
	private String sectionName;
	private String remark;
	
	public SysSectionVO() {
	}
	
	public SysSectionVO(SysSection sysSection) {
		this.sysSection = sysSection;
	}

	public String getSectionPid() {
		if (getSysSection() != null && sectionPid == null) {
			sectionPid = getSysSection().getSectionPid();
		}
		return sectionPid;
	}

	public void setSectionPid(String sectionPid) {
		this.sectionPid = sectionPid;
	}

	public String getSectionName() {
		if (getSysSection() != null && sectionName == null) {
			sectionName = getSysSection().getSectionName();
		}
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getRemark() {
		if (getSysSection() != null && remark == null) {
			remark = getSysSection().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysSection getSysSection() {
		return sysSection;
	}

	public void setSysSection(SysSection sysSection) {
		this.sysSection = sysSection;
	}

}
