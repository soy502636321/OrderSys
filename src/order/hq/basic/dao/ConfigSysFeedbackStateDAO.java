package order.hq.basic.dao;

import order.hq.basic.database.entity.ConfigSysFeedbackState;

public interface ConfigSysFeedbackStateDAO extends BaseDAO {

	public ConfigSysFeedbackState findByName(String stateName);

}
