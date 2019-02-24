package org.betPawa.automation.betPawa_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.betPawa.utils.ProjectConfig;

public class Driver {
	public static WebDriver driver;

	static {

		System.setProperty("webdriver.chrome.driver", ProjectConfig.prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		driver.get(ProjectConfig.prop.getProperty("Ugandaappurl"));
		driver.manage().window().maximize();
	}
}
