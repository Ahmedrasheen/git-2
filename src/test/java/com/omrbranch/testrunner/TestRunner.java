package com.omrbranch.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,features = "src\\test\\resources\\Features",glue="com.omrbranch.stepdefinition",plugin ={"json:target\\api.json","html:target\\api.html","junit:target\\api.xml"})
public class TestRunner {

	@AfterClass
	public static void API() {
		Reporting.generateJvmReport("C:\\Users\\shari\\eclipse-TestNG\\OMRBranchAPIAutomation\\target\\api.json");

	}
}
