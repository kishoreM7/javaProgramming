package LIMS.ims.pratice;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet {

	

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//fetch all the data from excell sheet
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		Sheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		short cellcount=sh.getRow(1).getLastCellNum();
	
		for(int i=1;i<=rowcount;i++)
			{
			
			
			for(int j=0;j<=cellcount;j++)
			{
				
				
				System.out.println(format.formatCellValue(sh.getRow(i).getCell(j)));
			}
		}
		
	
		
		
		
		
		

	}

}
