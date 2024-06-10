package testcCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utitlities.XLUtils;
import inetBankingPageObject.LoginPage;

public class TC_LOGIN_DDT_002 extends baseClass {

	@Test(dataProvider="Logindata")
	public void DDT(String user,String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		System.out.println(user);
		lp.setPass(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		if(isAlerPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.logoutclick();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlerPresent() {
		try {
		 driver.switchTo().alert();
		 return true;
		 }
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="Logindata")
	public String[][] getdata() throws IOException {
		String path=System.getProperty("user.dir")+ "/src/test/java/TestData/Logindata.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colnum= XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] logindata=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<colnum;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
		
		
		
		
		
		
		
		
		
		
	}
}
