package testngmarathon;
	import java.time.Duration;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_002 extends ProjectSpecificMethod {
	@BeforeTest
	   public void setup() {
		   sheet="TestCase_002";
	   }
	@Test(dataProvider="fetchData")
	public  void  individual(String firstname,String lastname,String confirmName) throws InterruptedException {

		// Click on toggle menu button from the left corner 
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
		// Click view All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//05) Type Individuals on the Search box
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Individuals");
		//06) Click Individuals Link
		driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
		//07) Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//08) Select Salutation with data (coming from excel) 
		driver.findElement(By.xpath("//a[@class='select']")).click();
		//driver.findElement(By.xpath("//a[@role='menuitemradio']")).sendKeys("Mrs");
		List<WebElement> salutation = driver.findElements(By.xpath("//a[@role='menuitemradio']"));
	    int size = salutation.size();
	    System.out.println(size);
	    
	    for (int i = 0; i<salutation.size(); i++) {
	    	salutation.get(2).click();
	    	break;
	    	}
		 
		//09) Type Last Name 
	    driver.findElement(By.xpath("//input[contains(@class,'firstName compoundBorder')]")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName compoundBorder')]")).sendKeys(firstname,Keys.TAB);
		WebElement name = driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]"));
		name.sendKeys(lastname);
		//driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).getAttribute("");
		//10) Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		//11) Click on the App Launcher (dots)
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();	
		//12) Click View All
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//13) Type Customers on the Search box
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Customers");
		//14) Click Customers Link
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mark[text()='Customers']")).click();
		//15) Click New
		Thread.sleep(2000);
		WebElement newClk = driver.findElement(By.xpath("//div[text()='New']"));
		driver.executeScript("arguments[0].click();",newClk);
		Thread.sleep(2000);
		//16) Type the same name provided in step 8 and confirm it appears
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(confirmName);
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//mark[@class='data-match']")).getText();
        System.out.println(text);
		//17) Close the browser

	}
}
