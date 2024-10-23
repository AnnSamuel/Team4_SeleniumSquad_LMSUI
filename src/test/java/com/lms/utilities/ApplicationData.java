package com.lms.utilities;

import java.util.List;
import java.util.Map;

public class ApplicationData {
	
	private Map<String, List<Map<String,String>>> moduleNameTestDataMap;
	

	public void setModuleNameTestDataMap(Map<String, List<Map<String, String>>> moduleNameTestDataMap) {
		this.moduleNameTestDataMap = moduleNameTestDataMap;
	}
	
	public Map<String,String> getData(String sheetName, String testCase){
		for(Map<String,String> row : moduleNameTestDataMap.get(sheetName)) {
			if(testCase.equalsIgnoreCase(row.get("testcase"))) {
				return row;
			}
		}
		return null;
	}
}
