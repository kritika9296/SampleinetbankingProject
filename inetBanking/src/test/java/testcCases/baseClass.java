package testcCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void takeScreenshot(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+ "/ScreenShots/"+ tname+ ".png");
	    FileUtils.copyFile(source, target);
	    System.out.println("Screenshot taken");
		
	}
	
}
