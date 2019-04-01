package br.ce.soctest.steps;

import static br.ce.soctest.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@After
	public static void afterScenario(Scenario scenario) {
		// if (!scenario.isFailed()) {
		String screenshotID = scenario.getId().substring(scenario.getId().length() - 1);
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			// This takes a screenshot from the driver at save it to the specified location
			TakesScreenshot ss = (TakesScreenshot) getDriver();
			File arquivo = ss.getScreenshotAs(OutputType.FILE);

			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			// folder
			File destinationPath = new File(
					"C:\\Users\\CLARK\\eclipse-workspace\\SOCTest\\target\\cucumber-reports\\screenshots\\"
							+ screenshotID + " - " + screenshotName + ".png");

			// Copy taken screenshot from source location to destination location
			Files.copy(arquivo, destinationPath);

			// This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
		}
		// }
	}

}
