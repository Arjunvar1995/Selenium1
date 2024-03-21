
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import testComponents.baseTest;

public class E2ETest extends baseTest{

	@Test
	public void E2ETestMethod() throws IOException
	{		
		
		//System.setProperty("webdriver.chrome.driver","C:/Users/91956/selenium/drivers/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=initializeDriver();
			
		loginPage lp=new loginPage(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		lp.OpenSiteAction("https://rahulshettyacademy.com/client");
		
		lp.maximizewindow();
		
		lp.loginAction("qatraineraj@example.com", "Qatraineraj1!");
				
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
				
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product-> product.
				findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.xpath("//button[@Class='btn w-10 rounded']")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
	}
	
	
	

}
