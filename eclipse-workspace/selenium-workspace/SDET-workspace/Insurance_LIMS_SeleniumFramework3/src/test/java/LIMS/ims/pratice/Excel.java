package LIMS.ims.pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	FileInputStream fis = null;
	Workbook workbook;
	DataFormatter df = new DataFormatter();

	public Map<String, String> returnMap() {
		try {
			fis = new FileInputStream("src/test/resources/Excell/TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		Sheet sheet = workbook.getSheet("Sheet1");
		int num = sheet.getLastRowNum();
		for (int i = 1; i <= num; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase("qspy1")) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
					map.put(key, value);

				}
				break;
			}
		}
		return map;

	}

	public static void main(String[] args) {
		Excel excel = new Excel();
		Map<String, String> abc = excel.returnMap();
		System.out.println(abc);

	}

}
