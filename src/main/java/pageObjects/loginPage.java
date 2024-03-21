package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement loginbutton;
	
	public void OpenSiteAction(String homepageurl) {
		
		driver.get(homepageurl);
		
	}
	
	public void maximizewindow() {
		
		driver.manage().window().maximize();
		
	}
	
	public void loginAction(String mailid, String password) {
		
		useremail.sendKeys(mailid);
		userpassword.sendKeys(password);
		loginbutton.click();
		
	}
	
	

}
