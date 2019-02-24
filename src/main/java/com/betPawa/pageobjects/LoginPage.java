package com.betPawa.pageobjects;

import org.betPawa.automation.betPawa_automation.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebElement phoneNumber = Driver.driver.findElement(By.id("input_phone"));
	public WebElement password = Driver.driver.findElement(By.id("input_password"));
	public WebElement loginButton = Driver.driver.findElement(By.xpath("//*[@id=\"Bp-Login-Form\"]/div[3]/input"));
}
