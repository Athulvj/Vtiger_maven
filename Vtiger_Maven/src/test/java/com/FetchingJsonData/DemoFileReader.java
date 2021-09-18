package com.FetchingJsonData;

import com.crm.genericUtility.JsonFileUtility;

public class DemoFileReader {
	public static void main(String[] args) throws Throwable {
		JsonFileUtility jsu = new JsonFileUtility();
		String browser = jsu.JsonLib("browser");
		String username = jsu.JsonLib("username");
		String password = jsu.JsonLib("password");
		
		System.out.println(browser +"\t" +username+ "\t" +password);
	}

}
