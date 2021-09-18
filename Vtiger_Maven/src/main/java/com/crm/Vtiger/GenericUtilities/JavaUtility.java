package com.crm.Vtiger.GenericUtilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * its used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return
	 */
	
	public int RandomNumber() {
		Random R = new Random();
		int RandomNum = R.nextInt(1000);
		return RandomNum;
				
	}
	
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	
	public String getSystmeDate() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	
	/**
	 *   its used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return intData
	 */
	public int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
	}
	
	public String localDate() {
		LocalDate lTime = LocalDate.now(); // Create a date object
		String localtime = lTime.toString();
		return localtime;
	}
	
	
	

	
}
