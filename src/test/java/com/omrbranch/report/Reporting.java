package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.internal.annotations.ConfigurationAnnotation;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class Reporting {

	public static void generateJvmReport(String jsonFile) {
        //1.mention the path of JVM report ,where to store
		File file=new File("C:\\Users\\shari\\eclipse-TestNG\\OMRBranchHotelAutomation\\target\\API.json");
		
		//2.create object for configuration class
		Configuration configuration= new Configuration(file,"OMR Branch Automation API");
		
		//3.K:V --->Browser,OS,version
		configuration.addClassifications("browser","chrome");
		configuration.addClassifications("browser version ","113");
		configuration.addClassifications("OS","WIN 10");
		configuration.addClassifications("Sprint","34");
        
		//4.pass the JSON file to fetch result
		List<String> jsonFiles=new ArrayList<>();
		
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder=new ReportBuilder(jsonFiles, configuration);
		
		// Generate Report
		builder.generateReports();
	}
}
