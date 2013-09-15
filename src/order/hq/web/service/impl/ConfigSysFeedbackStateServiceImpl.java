package order.hq.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.dao.ConfigSysFeedbackStateDAO;
import order.hq.basic.database.entity.ConfigSysFeedbackState;
import order.hq.web.service.ConfigSysFeedbackStateService;

public class ConfigSysFeedbackStateServiceImpl implements
		ConfigSysFeedbackStateService {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigSysFeedbackStateServiceImpl.class);
	
	public ConfigSysFeedbackState findByName(String stateName) {
		return getConfigSysFeedbackStateDAO().findByName(stateName);
	}

	private ConfigSysFeedbackStateDAO configSysFeedbackStateDAO;

	public ConfigSysFeedbackStateDAO getConfigSysFeedbackStateDAO() {
		return configSysFeedbackStateDAO;
	}

	public void setConfigSysFeedbackStateDAO(
			ConfigSysFeedbackStateDAO configSysFeedbackStateDAO) {
		this.configSysFeedbackStateDAO = configSysFeedbackStateDAO;
	}

}
