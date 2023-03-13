package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/main/java/com/features",
		glue="com.stepdef",
		plugin="html:target",
		monochrome=true,//for readable output
		dryRun=false,//to compile feature file
		tags="@login"
		
	)
public class TestRunner {
	
}
