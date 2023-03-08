package LIMS.ims.pratice;

import java.io.IOException;

import com.LIMS.genericUtility.enums.AutoConstants;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.genericUtility.javaUtility.JavaUtility;
import com.LIMS.genericUtility.propertyUtility.PropertyUtility;

public class DecopdeEncode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		PropertyUtility propertyUtility = new PropertyUtility(AutoConstants.TEST_PROPERTY_FILE_PATH);
		System.out.println(propertyUtility.getPropertyData(PropertiesFile.EXTENTREPORTTITLE));
	
		

	}

}
