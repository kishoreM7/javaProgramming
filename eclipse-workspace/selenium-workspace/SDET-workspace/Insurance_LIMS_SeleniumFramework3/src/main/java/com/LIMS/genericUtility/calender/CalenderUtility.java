package com.LIMS.genericUtility.calender;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.protobuf.TextFormat.ParseException;

/**
 * This class contains generic utilities related to calender
 * @author kishore mallarapu
 *
 */
public class CalenderUtility {
	private Calendar c;
	private SimpleDateFormat sd;

	/**
	 * 
	 * @param format
	 */
	public CalenderUtility(String format) {
		c = Calendar.getInstance();
		sd = new SimpleDateFormat(format);
	}

	/**
	 * This method is used to get time
	 * @return
	 * @throws ParseException
	 */
	public String getDate() throws ParseException {
		return sd.format(c.getTime());
	}

	/**
	 * This method is used to get date
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public String getDate(String dateString) throws ParseException {
		try {
			c.setTime(sd.parse(dateString));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sd.format(c.getTime());
	}

	/**
	 * This method is used to get date
	 * 
	 * @param amount
	 * @return
	 * @throws ParseException
	 */
	public String getDate(int amount) throws ParseException {
		c.add(Calendar.DAY_OF_MONTH, amount);
		return sd.format(c.getTime());
	}

	/**
	 * This method is used to get date
	 * 
	 * @param dateString
	 * @param amount
	 * @return
	 * @throws ParseException
	 */
	public String getDate(String dateString, int amount) throws ParseException {
		try {
			c.setTime(sd.parse(dateString));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, amount);
		return sd.format(c.getTime());
	}

}
