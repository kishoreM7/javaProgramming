package com.LIMS.objectRepository;

public enum ModuleName {

	CLIENTS("CLIENTS"), AGENTS("AGENTS"), POLICY("POLICY"), NOMINEE("NOMINEE"), PAYMENTS("PAYMENTS");

	private String moduleName;

	private ModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModule() {
		return moduleName;
	}

}
