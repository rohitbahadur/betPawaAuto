package com.betPawa.utils;

import java.util.concurrent.TimeUnit;

import org.betPawa.automation.betPawa_automation.Driver;

public class Common {
	
	public void waitForElement() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void implicitWait() {
		Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
