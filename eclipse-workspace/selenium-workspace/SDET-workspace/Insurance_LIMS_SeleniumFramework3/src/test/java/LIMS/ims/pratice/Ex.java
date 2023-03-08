package LIMS.ims.pratice;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.LIMS.genericUtility.calender.CalenderUtility;
import com.google.protobuf.TextFormat.ParseException;

public class Ex {
	public static void main(String[] args) throws ParseException {
		CalenderUtility CalenderUtility = new CalenderUtility("dd_MM_yyyy");
		String ca = CalenderUtility.getDate("02_05_2023", 2);
		System.out.println(ca);
	}
	
	

}
