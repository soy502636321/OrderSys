package order.hq.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.dao.BaseTranslatedFileDAO;
import order.hq.web.service.BaseTranslatedFileService;

public class BaseTranslatedFileServiceImpl implements BaseTranslatedFileService {
	private static final Logger log = LoggerFactory.getLogger(BaseTranslatedFileServiceImpl.class);
	
	private BaseTranslatedFileDAO baseTranslatedFileDAO;

	public BaseTranslatedFileDAO getBaseTranslatedFileDAO() {
		return baseTranslatedFileDAO;
	}

	public void setBaseTranslatedFileDAO(BaseTranslatedFileDAO baseTranslatedFileDAO) {
		this.baseTranslatedFileDAO = baseTranslatedFileDAO;
	}
	
	
}
