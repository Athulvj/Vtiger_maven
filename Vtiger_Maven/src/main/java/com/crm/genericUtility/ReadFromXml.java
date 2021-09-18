package com.crm.genericUtility;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXml {
	@Test
	public void readXml(XmlTest xmlobj) {
		System.out.println(xmlobj.getParameter("browser"));
	}	
}
