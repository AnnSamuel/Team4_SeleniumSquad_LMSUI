package com.lms.utilities;

import java.util.List;
import java.util.Map;

public class ApplicationData {
	
	private Map<String, List<Map<String,String>>> moduleNameTestDataMap;
	private boolean isLoggedIn;
	private String programName;
	private String batchName;
	private String classTopic;

	
	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getClassTopic() {
		return classTopic;
	}

	public void setClassTopic(String classTopic) {
		this.classTopic = classTopic;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

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
