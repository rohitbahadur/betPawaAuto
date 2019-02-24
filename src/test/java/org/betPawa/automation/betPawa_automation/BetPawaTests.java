package org.betPawa.automation.betPawa_automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.betPawa.pageobjects.HomePage;
import com.betPawa.pageobjects.LoginPage;
import com.betPawa.utils.Common;

public class BetPawaTests extends Common{

	static String voucherNum = "";
	static String secondVoucherNum = "";
	static String kenyaVoucherNum = "";	

	public void VerifyLogin() {

		HomePage hp = new HomePage();

		hp.loginLink.click();

		LoginPage lp = new LoginPage();
		lp.phoneNumber.sendKeys("788899001");
		lp.password.sendKeys("123456");
		lp.loginButton.click();

		implicitWait();

	}

	@Test
	public void b_VerifyBet()  {
		VerifyLogin();
		float testBet = 4;
		waitForElement();
		WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		String bal = presentBal.getText().substring(0, presentBal.getText().indexOf("UGX"));

		System.out.println("Initial Bal:" + bal.substring(0, 3));
		System.out.println("Rest Bal:" + bal.substring(4));

		float preBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Present Bal:" + preBal);

		Driver.driver.findElement(By.xpath("//span[@class='event-bet']")).click();
		Driver.driver.findElement(By.id("Bp-Stake-Input")).sendKeys(testBet + "");
		Driver.driver.findElement(By.id("bp-place-bet")).click();

		waitForElement();

		WebElement updatedBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		bal = updatedBal.getText().substring(0, updatedBal.getText().indexOf("UGX"));

		float updBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Updated Bal:" + updBal);

		float expBal = preBal - testBet;

		System.out.println("Expected Bal:" + expBal);

		assertEquals(updBal, expBal);
	}

	@Test
	public void c_VerifyMultipleBet()  {

		WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		String bal = presentBal.getText().substring(0, presentBal.getText().indexOf("UGX"));

		System.out.println("Initial Bal:" + bal.substring(0, 3));
		System.out.println("Rest Bal:" + bal.substring(4));

		float preBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Present Bal:" + preBal);

		Driver.driver.findElement(By.xpath("//span[@class='event-bet']")).click();
		Driver.driver.findElement(By.id("Bp-Stake-Input")).sendKeys("2");
		Driver.driver.findElement(By.id("bp-place-bet")).click();

		waitForElement();

		WebElement updatedBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		bal = updatedBal.getText().substring(0, updatedBal.getText().indexOf("UGX"));

		float updBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Updated Bal:" + updBal);

		float expBal = preBal - 2;

		System.out.println("Expected Bal:" + expBal);

		// For multiple bets

		Driver.driver.findElement(By.xpath("//span[@class='event-bet'][1]")).click();
		Driver.driver.findElement(By.id("Bp-Stake-Input")).sendKeys("2");
		Driver.driver.findElement(By.id("bp-place-bet")).click();
		waitForElement();

		Driver.driver.findElement(By.xpath("//span[@class='event-bet'][2]")).click();
		Driver.driver.findElement(By.id("Bp-Stake-Input")).sendKeys("2");
		Driver.driver.findElement(By.id("bp-place-bet")).click();
		waitForElement();

		Driver.driver.findElement(By.xpath("//span[@class='event-bet'][3]")).click();
		Driver.driver.findElement(By.id("Bp-Stake-Input")).sendKeys("2");
		Driver.driver.findElement(By.id("bp-place-bet")).click();
		waitForElement();

		Driver.driver.findElement(By.xpath("//span[@class='event-bet'][1]")).click();
		Driver.driver.findElement(By.id("Bp-Stake-Input")).sendKeys("2");
		Driver.driver.findElement(By.id("bp-place-bet")).click();
		waitForElement();

		WebElement updatedMulBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		bal = updatedMulBal.getText().substring(0, updatedBal.getText().indexOf("UGX"));

		float updMulBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Updated Mul Bal:" + updMulBal);

		float expMulBal = preBal - 10;
		assertEquals(updMulBal, expMulBal);
		System.out.println("Expected Mul Bal:" + expMulBal);

	}

	@Test
	public void d_VerifyWithdrawl()  {
		//VerifyLogin();
		waitForElement();

		WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		String bal = presentBal.getText().substring(0, presentBal.getText().indexOf("UGX"));

		System.out.println("Initial Bal:" + bal.substring(0, 3));
		System.out.println("Rest Bal:" + bal.substring(4));

		float preBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Present Bal:" + preBal);

		Driver.driver.findElement(By.id("Main-Menu-Button")).click();

		Driver.driver.findElement(By.id("withdraw-menu-top")).click();

		Driver.driver.findElement(By.id("withdraw-to-voucher")).click();

		Driver.driver.findElement(By.id("Input-Amount")).sendKeys("2");

		Driver.driver.findElement(By.id("Submit-Payout")).click();

		String expText = "Thank you. Your payout for 2 UGX to voucher was successful. Your voucher number is";
		String actText = Driver.driver.findElement(By.xpath("//div[@class=\"notify success\"]")).getText();

		System.out.println("expText Bal:" + expText);
		System.out.println("actText Bal:" + actText);

		WebElement updatedBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		bal = updatedBal.getText().substring(0, updatedBal.getText().indexOf("UGX"));

		float updBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Updated Bal:" + updBal);
		waitForElement();

		WebElement updatedMulBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		bal = updatedMulBal.getText().substring(0, updatedBal.getText().indexOf("UGX"));

		float updMulBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Updated Mul Bal:" + updMulBal);

		float expMulBal = preBal - 2;

		System.out.println("Expected Mul Bal:" + expMulBal);

		actText = actText.substring(0, actText.indexOf("is") + 2);

		System.out.println("Expected Text:" + expText);
		System.out.println("Actual Text:" + actText);

		assertEquals(actText, expText);

		assertEquals(updMulBal, expMulBal);

		voucherNum = Driver.driver.findElement(By.xpath("//*[@id=\"1162\"]/div[2]/div/span")).getText();
		secondVoucherNum = Driver.driver.findElement(By.xpath("(//*[@id=\"1162\"]/div[2]/div/span)[2]")).getText();

		System.out.println("Voucher No:" + voucherNum);
		System.out.println("Second Voucher No:" + secondVoucherNum);

	}
	
	@Test
	public void e_VerifyRedeemVoucher()  {
		
		waitForElement();

		WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		String bal = presentBal.getText().substring(0, presentBal.getText().indexOf("UGX"));

		System.out.println("Initial Bal:" + bal.substring(0, 3));
		System.out.println("Rest Bal:" + bal.substring(4));

		float preBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Present Bal:" + preBal);

		Driver.driver.get("http://ug.test.verekuu.com/voucher");

		// Redeem Voucher
		// String voucherNum = BetPawaTests.voucherNum;
		Driver.driver.findElement(By.id("input_voucher")).sendKeys(voucherNum);

		Driver.driver.findElement(By.id("activateVoucher")).click();

		////
		waitForElement();
		WebElement updatedBal = Driver.driver.findElement(By.xpath("//span[@class=\"count bold\"]"));

		bal = updatedBal.getText().substring(0, updatedBal.getText().indexOf("UGX"));

		float updBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Updated Bal:" + updBal);
		waitForElement();

		System.out.println("Updated Mul Bal:" + updBal);

		float expMulBal = preBal + 2;

		System.out.println("Expected Mul Bal:" + expMulBal);
		assertEquals(updBal, expMulBal);
	}
	
	@Test
	public void f_VerifyWithdrawlInsufficientAmount()  {
		waitForElement();
		
		Driver.driver.get("http://ug.test.verekuu.com/withdraw");
		waitForElement();

		WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		String bal = presentBal.getText().substring(0, presentBal.getText().indexOf("UGX"));

		System.out.println("Initial Bal:" + bal.substring(0, 3));
		System.out.println("Rest Bal:" + bal.substring(4));

		float preBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Present Bal:" + preBal);

		Driver.driver.findElement(By.id("Main-Menu-Button")).click();

		Driver.driver.findElement(By.id("withdraw-menu-top")).click();

		Driver.driver.findElement(By.id("withdraw-to-voucher")).click();

		Driver.driver.findElement(By.id("Input-Amount")).sendKeys("1000000000");

		Driver.driver.findElement(By.id("Submit-Payout")).click();

		String expText = "You cannot withdraw more money than you have on your account.";
		String actText = Driver.driver.findElement(By.xpath("//div[@class=\"notify error\"]")).getText();

		System.out.println("Expected Text:" + expText);
		System.out.println("Actual Text:" + actText);

		assertEquals(actText, expText);
	}

	@Test
	public void g_VerifyWithdrawlInvalidAmount()  {
		waitForElement();

		WebElement presentBal = Driver.driver.findElement(By.xpath("//*[@id=\"bet_initial\"]/div[1]/div/span[2]"));

		String bal = presentBal.getText().substring(0, presentBal.getText().indexOf("UGX"));

		System.out.println("Initial Bal:" + bal.substring(0, 3));
		System.out.println("Rest Bal:" + bal.substring(4));

		float preBal = new Float(bal.substring(0, 3) + bal.substring(4)).floatValue();

		System.out.println("Present Bal:" + preBal);

		Driver.driver.findElement(By.id("Main-Menu-Button")).click();

		Driver.driver.findElement(By.id("withdraw-menu-top")).click();

		Driver.driver.findElement(By.id("withdraw-to-voucher")).click();

		Driver.driver.findElement(By.id("Input-Amount")).sendKeys(".1");

		Driver.driver.findElement(By.id("Submit-Payout")).click();

		String actText = "Pass";

		try {
			Driver.driver.findElement(By.xpath("//div[@class=\"notify error hidden\"]"));
		} catch (Exception e) {
			actText = "Fail";
		}

		assertEquals(actText, "Pass");
	}
	
	@Test
	public void h_VerifyInvalidCurrencyVoucher()  {
		Driver.driver.get("http://ke.test.verekuu.com/");

		Driver.driver.findElement(By.id("secondarySlot")).click();
		Driver.driver.findElement(By.id("input_phone")).sendKeys("728899021");
		Driver.driver.findElement(By.id("input_password")).sendKeys("123456");
		Driver.driver.findElement(By.xpath("//*[@id=\"Bp-Login-Form\"]/div[3]/input")).click();

		implicitWait();

		waitForElement();	
		
		Driver.driver.get("http://ke.test.verekuu.com/voucher");
		
		waitForElement();

		Driver.driver.findElement(By.id("input_voucher")).sendKeys(secondVoucherNum);

		Driver.driver.findElement(By.id("activateVoucher")).click();

		waitForElement();	
		
		String expText = "The voucher is in UGX. You are only allowed to deposit vouchers in KES.";
		String actText = Driver.driver.findElement(By.xpath("//div[@class=\"notify error\"]")).getText();

		System.out.println("Expected Text:" + expText);
		System.out.println("Actual Text:" + actText);

		assertEquals(actText, expText);


	}
}