package testcCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utitlities.ReadConfig;


public class baseClass {

	ReadConfig Read=new ReadConfig();
	
	public String baseurl=Read.getApplicationUrl();
	public String username=Read.getUserName();
	public String password=Read.getPass();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br=="chrome") {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br=="edge") {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.get(baseurl);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
