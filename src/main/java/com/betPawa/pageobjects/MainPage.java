package com.betPawa.pageobjects;

import org.betPawa.automation.betPawa_automation.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

	public WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));
	public WebElement betRecord = Driver.driver.findElement(By.xpath("//*[@id=\"Bp-Price-43585216\"]/span[2]"));

	public WebElement betAmt = Driver.driver.findElement(By.id("Bp-Stake-Input"));

	

}
