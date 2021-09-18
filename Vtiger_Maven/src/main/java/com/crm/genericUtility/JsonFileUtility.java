package com.crm.genericUtility;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JsonFileUtility {
	/*
	 * this method will read data from json file
	 */
	public String JsonLib(String key) throws Throwable {

		//read data from json file
		FileReader file = new FileReader("./commondata.json");

		//create an  object of json file
		JSONParser jsonobj = new JSONParser();
		//converting json file into java object
		Object jobj = jsonobj.parse(file);
		
		//type cast the java obj to hashmap
		HashMap map = (HashMap)jobj;
		
		String KeyValue = map.get(key).toString();
		return KeyValue;
	}
	
	/*public int JsonintLib(String key) throws Throwable {

		//read data from json file
		FileReader file = new FileReader("./commondata.json");

		//create an  object of json file
		JSONParser jsonobj = new JSONParser();
		//converting json file into java object
		Object jobj = jsonobj.parse(file);
		
		//type cast the java obj to hashmap
		HashMap map = (HashMap)jobj;
		
		int KeyValue = (int) map.get(key);
		return KeyValue;
		
	}
*/
}
