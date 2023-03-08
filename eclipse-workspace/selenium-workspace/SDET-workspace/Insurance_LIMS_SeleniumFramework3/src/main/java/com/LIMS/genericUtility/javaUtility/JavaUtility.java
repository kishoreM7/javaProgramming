package com.LIMS.genericUtility.javaUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.google.protobuf.TextFormat.ParseException;

/**
 * This method contains generic utilities of java
 * @author kishore mallarapu
 *
 */
public class JavaUtility {
	/**
	 * This method will generate random number
	 * 
	 * @param i
	 * @return
	 */
	public int generateRandomNumber(int i) {
		int ramNumber = new Random().nextInt(i);
		return ramNumber;
	}

	/**
	 * This method will decode the string
	 * 
	 * @param s
	 * @return
	 */
	public String decoder(String s) {
		return new String(Base64.getDecoder().decode(s.getBytes()));

	}

	/**
	 * This method will encode the string
	 * 
	 * @param s
	 * @return
	 */
	public String encoder(String s) {
		return new String(Base64.getEncoder().encode(s.getBytes()));

	}

	/**
	 * This method will return current date and time
	 * 
	 * @return
	 */

	public String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		return sdf.format(new Date());
	}

	/**
	 * This method is used get the any date from given date date is a string and in
	 * this format ===>>> 01_01_2020 days is in integer format
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public String addorSubstractDate(String date, int days) throws ParseException, java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}

	/**
	 * This method used get the any date by passing required date
	 * 
	 * @param days
	 * @return
	 */
	public String addorSubstractDate(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}

	/**
	 * This method used to split the string based on the given strategy like space("
	 * "),comma(",")
	 * 
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s, String strategy) {
		return s.split(strategy);
	}

	/**
	 * This method used to convert string data type to integer datatype
	 * 
	 * @param s
	 * @return
	 */
	public int parseNumber(String s) {
		return Integer.parseInt(s);

	}

	/**
	 * This method is used to convert monthName into monthNumber and mention the
	 * pattern as below specified MMMM --->> month full name MMM --->> month short
	 * name
	 * 
	 * @param mothName
	 * @param pattren
	 */
	public int getMonthNumber(String mothName, String pattren) {
		int monthNumber = DateTimeFormatter.ofPattern(pattren.toUpperCase()).withLocale(Locale.ENGLISH).parse(mothName)
				.get(ChronoField.MONTH_OF_YEAR);

		return monthNumber;
	}

	/**
	 * This method is used to print in the console object because we can pass
	 * anything even String and Integer
	 * 
	 * @param output
	 */
	public void consolePrint(Object output) {
		System.out.println(output);
	}

}
