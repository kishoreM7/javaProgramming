package LIMS.ims.pratice;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchColumnFromExceel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		Sheet sh=book.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		String value="";
		for(int i=1;i<=rowcount;i++)
		{
			String val=format.formatCellValue(sh.getRow(i).getCell(1));
			System.out.println(val);
			if(val.equals("Org_name"))
			{
				value=format.formatCellValue(sh.getRow(i).getCell(1));
				break;
			}
		}
		System.out.println(value);
				
		
		
		

	}

}
