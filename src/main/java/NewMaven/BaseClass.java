package NewMaven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	 protected WebDriver driver;
	 public void initializeBrowser() 
	 {
	 driver=new ChromeDriver(); driver.get("https://www.saucedemo.com/");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	           driver.manage().window().maximize();
	      }

}
