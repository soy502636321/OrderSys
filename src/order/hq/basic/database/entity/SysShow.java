package order.hq.basic.database.entity;


public class SysShow {
	private String showPid;

	private SysOrder sysOrder;

	public String getShowPid() {
		return showPid;
	}

	public void setShowPid(String showPid) {
		this.showPid = showPid;
	}

	public SysOrder getSysOrder() {
		return sysOrder;
	}

	public void setSysOrder(SysOrder sysOrder) {
		this.sysOrder = sysOrder;
	}

}
