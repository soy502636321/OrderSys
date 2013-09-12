package order.hq.web.service;

import order.hq.basic.database.entity.ConfigSysOrderState;

public interface ConfigSysOrderStateService {

	public ConfigSysOrderState findCancel();

	public ConfigSysOrderState findComplete();

	public ConfigSysOrderState findTurnover();

	public ConfigSysOrderState findAccept();

	public ConfigSysOrderState findInitate();
}
