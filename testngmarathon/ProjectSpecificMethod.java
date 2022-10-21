package testngmarathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethod {
	
    RemoteWebDriver driver;
    String sheet;
    @Parameters({"browser","url","username","password"})
    @BeforeMethod
	public  void precondition(String browser,String url,String username,String password) {
	if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	 driver=new ChromeDriver(options);
	}
	else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		 driver=new EdgeDriver(options);
		}
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	//3.Enter the username as " ramkumar.ramaiah@testleaf.com "
	driver.findElement(By.id("username")).sendKeys(username);
	//4. Enter the password as " Password$123 "
	driver.findElement(By.id("password")).sendKeys(password);
	//5.click on the login button
	driver.findElement(By.id("Login")).click();
}
       @AfterMethod
       public void postcondition() {
    	   driver.close();
       }
       @DataProvider(name="fetchData")
 	  public String[][] getData() throws IOException   {
 		  String[][] readData = ReadExcel.readData(sheet);
 		return readData;
}
}
