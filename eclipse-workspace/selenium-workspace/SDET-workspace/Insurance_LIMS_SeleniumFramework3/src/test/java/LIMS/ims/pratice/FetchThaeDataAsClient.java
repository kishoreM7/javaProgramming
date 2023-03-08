package LIMS.ims.pratice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class FetchThaeDataAsClient {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String sheetName="Sheet2";
		String exptestCaseName="AddClient";
	DataFormatter format=new DataFormatter();
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Sheet2");
	int rowcount=sh.getLastRowNum();
	Map<String,String> map=new HashMap<>();
	for(int i=1;i<=rowcount;i++)
	{
		String testScriptName=format.formatCellValue(sh.getRow(i).getCell(0));
		if(testScriptName.equalsIgnoreCase(exptestCaseName))
		{
			for(int j=1;j<sh.getRow(i).getLastCellNum();j++)
			{
				String key=format.formatCellValue(sh.getRow(i).getCell(j));
				String value=format.formatCellValue(sh.getRow(i+1).getCell(j));
				map.put(key, value);
			}
			break;
		}
		
		
	}
	System.out.println(map);
	
	}
}
