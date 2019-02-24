package com.betPawa.pageobjects;

import org.betPawa.automation.betPawa_automation.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebElement loginLink = Driver.driver.findElement(By.xpath("//a[@id='secondarySlot']"));

}
