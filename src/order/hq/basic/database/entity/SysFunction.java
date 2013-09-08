package order.hq.basic.database.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 */

public class SysFunction implements java.io.Serializable {

	// Fields

	private String functionPid;
	private String functionName;
	private String functionUrl;
	private String functionType;
	private String remark;
	private Date operTime;

	/**
	 * @hibernate.many-to-one column="parentId"
	 */
	private SysFunction parent;
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="parentId"
	 * @hibernate.one-to-many class="com.hq.basic.database.entity.SysFunction"
	 */
	private Set children = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysFunction() {
	}

	// Property accessors

	public String getFunctionName() {
		return this.functionName;
	}

	public String getFunctionPid() {
		return functionPid;
	}

	public void setFunctionPid(String functionPid) {
		this.functionPid = functionPid;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysFunction getParent() {
		return parent;
	}

	public void setParent(SysFunction parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

}