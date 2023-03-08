
package com.LIMS.genericUtility.propertyUtility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import com.LIMS.genericUtility.enums.PropertiesFile;

/**
 * 
 * @author kishore mallarapu
 *
 */

public class PropertyUtility {

	private Properties prop;

	/**
	 * 
	 * @param filepath
	 * @throws IOException
	 */

	public PropertyUtility(String filepath) throws IOException {
		FileInputStream fisProperty = new FileInputStream(filepath);
		prop = new Properties();
		prop.load(fisProperty);
		// fisProperty.close();
	}

	/**
	 * this method is used to initialize Property file
	 * 
	 * @deprecated new PropertyUtiltly(String filepath)
	 * @param filepath
	 * @throws IOException
	 */
	@Deprecated
	public void intializePropertyFile(String filepath) throws IOException {
		FileInputStream fisProperty = new FileInputStream(filepath);
		prop = new Properties();
		prop.load(fisProperty);
		// fisProperty.close();
	}

	/**
	 * This method is used to get the value of key from property file using property
	 * file
	 * 
	 * @param key
	 * @return
	 */
	public String getPropertyData(PropertiesFile key) {
		String propKey = key.name().toLowerCase();
		String value = prop.getProperty(propKey, "").trim();
		return value;
	}

	/**
	 * This method is used to get the value from property file based on key
	 * 
	 * @param s
	 * @return
	 */
	public String getPropertyOfKey(String s) {
		String value = prop.getProperty(s);
		return value;
	}

}
