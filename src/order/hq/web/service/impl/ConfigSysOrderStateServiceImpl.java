package order.hq.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.dao.ConfigSysOrderStateDAO;
import order.hq.basic.database.entity.ConfigSysOrderState;
import order.hq.web.service.ConfigSysOrderStateService;

public class ConfigSysOrderStateServiceImpl implements
		ConfigSysOrderStateService {
	private static final Logger log = LoggerFactory
			.getLogger(ConfigSysOrderStateServiceImpl.class);

	private ConfigSysOrderStateDAO configSysOrderStateDAO;

	@Override
	public ConfigSysOrderState findCancel() {
		return getConfigSysOrderStateDAO().findCancel();
	}

	@Override
	public ConfigSysOrderState findComplete() {
		return getConfigSysOrderStateDAO().findComplete();
	}

	@Override
	public ConfigSysOrderState findTurnover() {
		return getConfigSysOrderStateDAO().findTurnover();
	}

	@Override
	public ConfigSysOrderState findAccept() {
		return getConfigSysOrderStateDAO().findAccept();
	}

	@Override
	public ConfigSysOrderState findInitate() {
		return getConfigSysOrderStateDAO().findInitate();
	}

	public ConfigSysOrderStateDAO getConfigSysOrderStateDAO() {
		return configSysOrderStateDAO;
	}

	public void setConfigSysOrderStateDAO(
			ConfigSysOrderStateDAO configSysOrderStateDAO) {
		this.configSysOrderStateDAO = configSysOrderStateDAO;
	}

}
