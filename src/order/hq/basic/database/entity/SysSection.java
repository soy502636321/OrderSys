package order.hq.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysSection entity. @author MyEclipse Persistence Tools
 */

public class SysSection implements java.io.Serializable {

	// Fields

	private String sectionPid;
	private String sectionName;
	private String remark;
	private Set sectionFunctions = new HashSet(0);
	private Set sectionOrgans = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysSection() {
	}

	// Property accessors

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSectionFunctions() {
		return this.sectionFunctions;
	}

	public void setSectionFunctions(Set sectionFunctions) {
		this.sectionFunctions = sectionFunctions;
	}

	public Set getSectionOrgans() {
		return this.sectionOrgans;
	}

	public void setSectionOrgans(Set sectionOrgans) {
		this.sectionOrgans = sectionOrgans;
	}

	public String getSectionPid() {
		return sectionPid;
	}

	public void setSectionPid(String sectionPid) {
		this.sectionPid = sectionPid;
	}

	
}