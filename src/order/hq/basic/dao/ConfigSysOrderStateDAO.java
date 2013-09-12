package order.hq.basic.dao;

import order.hq.basic.database.entity.ConfigSysOrderState;

public interface ConfigSysOrderStateDAO extends BaseDAO {

	public ConfigSysOrderState findCancel();

	public ConfigSysOrderState findComplete();

	public ConfigSysOrderState findTurnover();

	public ConfigSysOrderState findAccept();

	public ConfigSysOrderState findInitate();

}
