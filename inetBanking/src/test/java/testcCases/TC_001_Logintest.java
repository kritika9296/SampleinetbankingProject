package testcCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import inetBankingPageObject.LoginPage;

@Test
public class TC_001_Logintest extends baseClass{

	public void login() throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		System.out.println(username);
		lp.setPass(password);
		//System.out.println(password);
		lp.loginClick();
		Thread.sleep(4000);
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
}
