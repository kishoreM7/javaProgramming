package LIMS.ims.pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.LIMS.genericUtility.enums.AutoConstants;

public class WriteInXl {
	public static void main(String[] args) throws Exception, IOException {
		FileInputStream fis = new FileInputStream(AutoConstants.TEST_EXCEL_FILE_PATH);
		DataFormatter df = new DataFormatter();
		Workbook wb = WorkbookFactory.create(fis);
		String testCase = "AddClientTest";
		String data = "tc pass";
		Sheet sheet = wb.getSheet("ClientVerificationData");
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i < rowCount; i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(0)).equals(testCase)) {
				for (int j = 1; j <= sheet.getRow(i).getLastCellNum() + 1; j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equals("status")) {
						sheet.getRow(i + 1).createCell(j).setCellValue(data);
						break;
					} else if (key.equals("")) {
						sheet.getRow(i).createCell(j).setCellValue("status");
						sheet.getRow(i + 1).createCell(j).setCellValue(data);
						break;
					}
				}
			}
		}
		FileOutputStream fos = new FileOutputStream(AutoConstants.TEST_EXCEL_FILE_PATH);
		wb.write(fos);
		fis.close();

	}

}
