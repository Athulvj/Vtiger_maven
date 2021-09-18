package com.crm.Vtiger.GenericUtilities;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility  {
	public String JsonLib(String key)  throws Throwable {

		//read data from json file
		FileReader file = new FileReader(IpathConstants.JsonPath);

		//create an  object of json file
		JSONParser jsonobj = new JSONParser();
		//converting json file into java object
		Object jobj = jsonobj.parse(file);

		//type cast the java obj to hashmap
		HashMap map = (HashMap)jobj;

		String KeyValue = map.get(key).toString();
		return KeyValue;
	}
}
