package com.LIMS.genericUtility.excelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This utility class contains generic utilities related to excel
 * fetching data from excel'
 * writing data excel sheet
 * @author kishore mallarapu
 *
 */

public class ExcelUtility {
	DataFormatter df;
	FileInputStream fis;
	Workbook wb;

	

	/**
	 * This constructor will excel file
	 * @param fileName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ExcelUtility(String fileName) throws EncryptedDocumentException, IOException {
		intiallize(fileName);
	}

	/**
	 * This method will initialise Dataformatter and Fileinputstraem and workbook
	 * factory
	 * 
	 * @param fileName
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throws
	 */

	private void intiallize(String fileName) throws EncryptedDocumentException, IOException {
		try {
			df = new DataFormatter();
			fis = new FileInputStream(fileName);
			wb = WorkbookFactory.create(fis);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method will will return the map of of required data
	 * 
	 * @param sheetName
	 * @param extestCaseName
	 * @return
	 */

	public Map<String, String> getData(String sheetName, String extestCaseName) {
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// return index
		Map<String, String> map = new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equalsIgnoreCase(extestCaseName)) {
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

	/**
	 * This method will return required data from excel sheet based on key
	 * 
	 * @param sheetName
	 * @param exptestCaseName
	 * @param expctedKey
	 * @return
	 */

	public String getData(String sheetName, String exptestCaseName, String expctedKey) {
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();// index
		String value = "";
		int testScriptCounter = 0;
		int keyCounter = 0;
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if (testScriptName.equals(exptestCaseName)) {
				testScriptCounter++;
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if (key.equalsIgnoreCase(expctedKey)) {
						keyCounter++;
						value = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
						break;
					}
				}
				break;

			}
		}
		if (keyCounter == 0) {
			if (testScriptCounter == 0) {
				value = "please give proper testScript key'" + exptestCaseName + "' ";
			} else {
				value = "please give proper testScript key'" + expctedKey + "'";

			}
		}
		// System.out.println("value fetched from excel-->" + value);
		return value;
	}

	/**
	 * this method will return two - dimentional array of strings from excel sheet
	 * 
	 * @param sheetName
	 * @return
	 */
	public String[][] getData(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getFirstRowNum();// index
		String[][] arr = new String[rowCount][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; i < sheet.getRow(i).getLastCellNum(); j++) {
				arr[i - 1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}

	/**
	 * This method will return required data from excel sheet
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */

	public String getData(String sheetName, int rowIndex, int cellIndex) {
		String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
	}

	/**
	 * 
	 * @throws IOException
	 */

	public void close() throws IOException {
		wb.close();
	}

	/**
	 * This mwthod is used to write in excel sheet
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 */

	public void setData(String sheetName, int rowIndex, int cellIndex) {
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);

	}

	/**
	 * This method is used to save data in excel sheet
	 * 
	 * @param fileOutputPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveData(String fileOutputPath) throws FileNotFoundException, IOException {
		wb.write(new FileOutputStream(fileOutputPath));
	}

}
