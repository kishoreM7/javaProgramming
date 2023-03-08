package com.LIMS.genericUtility.enums;
/**
 * 
 * @author kishore mallarapu
 *
 */
public enum ExcellSheet {
	/**
	 * 
	 */
	ORGANIZATION("Organization");
	String SheetName;
	/**
	 * 
	 * @param key
	 */
	private ExcellSheet(String key)
	{
		this.SheetName=key;
	}
	public String getSheetName()
	{
		return SheetName;
	}

}
