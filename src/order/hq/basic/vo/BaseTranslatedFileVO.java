package order.hq.basic.vo;

import order.hq.basic.database.entity.BaseTranslatedFile;

public class BaseTranslatedFileVO {
	private BaseTranslatedFile baseTranslatedFile;

	public BaseTranslatedFileVO() {
	}

	public BaseTranslatedFileVO(BaseTranslatedFile baseTranslatedFile) {
		this.baseTranslatedFile = baseTranslatedFile;
	}

	public BaseTranslatedFile getBaseTranslatedFile() {
		return baseTranslatedFile;
	}

	public void setBaseTranslatedFile(BaseTranslatedFile baseTranslatedFile) {
		this.baseTranslatedFile = baseTranslatedFile;
	}

}
