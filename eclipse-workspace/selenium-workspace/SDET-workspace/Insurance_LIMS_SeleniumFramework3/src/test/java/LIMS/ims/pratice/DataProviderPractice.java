package LIMS.ims.pratice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LIMS.genericUtility.enums.AutoConstants;
import com.LIMS.genericUtility.excelUtility.ExcelUtility;

public class DataProviderPractice {

	@Test(dataProvider = "")
	public void test(String usn, String pwd) {
		System.out.println(usn);

	}

	@DataProvider
	public String[][] data() throws EncryptedDocumentException, IOException {
		ExcelUtility excelUtility = new ExcelUtility(AutoConstants.TEST_EXCEL_FILE_PATH);
		String[][] data = excelUtility.getData("dataprovider");
		return data;
	}

}
