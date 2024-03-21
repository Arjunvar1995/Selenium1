package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseTest {
	
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\91956\\eclipse-workspace\\SeleniumFrameworkCourse\\src\\main\\java\\resources\\Global.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:/Users/91956/selenium/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
		//code to initialize firefox driver
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
		//code to initialize ie driver
		}
		return driver;
		
		
		
	}

}
