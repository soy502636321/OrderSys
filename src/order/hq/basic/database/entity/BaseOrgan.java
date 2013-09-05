package order.hq.basic.database.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * BaseOrgan entity. @author MyEclipse Persistence Tools
 */

public class BaseOrgan implements java.io.Serializable {

	// Fields

	private String organPid;
	private String organName;
	private String principal;
	private String organTel;
	private String organFax;
	private String email;
	private String organType;
	private String operFre;
	private String custFre;
	private String remark;

	/**
	 * @hibernate.many-to-one column="parentId"
	 */
	private BaseOrgan parent;
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="parentId"
	 * @hibernate.one-to-many class="com.hq.basic.database.entity.SysFunction"
	 */
	private Set children = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseOrgan() {
	}

	// Property accessors

	public String getOrganName() {
		return this.organName;
	}

	public String getOrganPid() {
		return organPid;
	}

	public void setOrganPid(String organPid) {
		this.organPid = organPid;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getOrganTel() {
		return this.organTel;
	}

	public void setOrganTel(String organTel) {
		this.organTel = organTel;
	}

	public String getOrganFax() {
		return this.organFax;
	}

	public void setOrganFax(String organFax) {
		this.organFax = organFax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganType() {
		return this.organType;
	}

	public void setOrganType(String organType) {
		this.organType = organType;
	}

	public String getOperFre() {
		return this.operFre;
	}

	public void setOperFre(String operFre) {
		this.operFre = operFre;
	}

	public String getCustFre() {
		return this.custFre;
	}

	public void setCustFre(String custFre) {
		this.custFre = custFre;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BaseOrgan getParent() {
		return parent;
	}

	public void setParent(BaseOrgan parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

}