package testcCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import inetBankingPageObject.AddCustomer;
import inetBankingPageObject.LoginPage;
import net.bytebuddy.utility.RandomString;

public class TC_AddCutomertest extends baseClass{
    
	
	@Test
	public void addcust() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPass(password);
		lp.loginClick();
		Thread.sleep(4000);
		
		AddCustomer ad=new AddCustomer(driver);
		ad.newcustclick();
		ad.Customername("Kritika");
		ad.dob("01", "02", "1994");
		Thread.sleep(2000);
		ad.Address("c-13 sbi colony");
		ad.City("Lucknow");
		ad.State("UP");
		ad.pinc(226022);
		ad.telliphone("911815301");
		ad.Emailid("nik@gmail.com");
		ad.newcustclick();
		Thread.sleep(3000);
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			
			takeScreenshot(driver, "addcust");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
	}
	
}
