package com.FetchFromXML;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXML {
	@Test
	public void ReadXML(XmlTest xmlobj) {
		System.out.println(xmlobj.getParameter("browser"));
		
	}

}
