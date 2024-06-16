package inetBankingPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver ldriver;
	
	public AddCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newcustclick;
	
	
	@FindBy(name="name")
	WebElement custname;
	
	@FindBy(id="dob")
	WebElement DOB;
	
	@FindBy(name="addr")
	WebElement add;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="state")
	WebElement State;
	
	@FindBy(name="pinno")
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn;
	
	public void newcustclick() {
		newcustclick.click();
	}
	
	
	public void Customername(String customname) {
		custname.sendKeys(customname);
	}
	
	public void dob(String dd,String mm,String yy) {
		DOB.sendKeys(dd);
		DOB.sendKeys(mm);
		DOB.sendKeys(yy);
	}
	 
	public void Address(String Address) {
		add.sendKeys(Address);
	}
	 
	public void City(String Cityy) {
		City.sendKeys(Cityy);
	}
	
	public void State(String state) {
		State.sendKeys(state);
	}
	
	public void pinc(int pin) {
		pincode.sendKeys(String.valueOf(pin));
	}
	 
	public void telliphone(String telph) {
		telephoneno.sendKeys(telph);
	}
	 
	public void Emailid(String mailid) {
		emailid.sendKeys(mailid);
	}
	 
	public void Submit() {
		btn.click();
	}
	 
	 
	
	
	
}
