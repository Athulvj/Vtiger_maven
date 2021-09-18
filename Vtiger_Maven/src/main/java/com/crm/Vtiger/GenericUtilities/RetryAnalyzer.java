package com.crm.Vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int count = 0;
	int  retrycount=4;
	
	@Override
	public boolean retry(ITestResult arg0) {
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}

	
}
