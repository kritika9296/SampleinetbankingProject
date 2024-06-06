package inetBankingPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
    	ldriver=rdriver;
    	PageFactory.initElements(rdriver, this);
    }


    @FindBy(name="uid")
    WebElement textuserid;
    
    @FindBy(name="password")
    WebElement textPass;
    
    @FindBy(name="btnLogin")
    WebElement btnlofin;
    
    public void setUserName(String uname) {
    	textuserid.sendKeys(uname);
    }
    public void setPass(String pass) {
    	textPass.sendKeys(pass);
    }
    public void loginClick() {
    	btnlofin.click();
}
    
}
