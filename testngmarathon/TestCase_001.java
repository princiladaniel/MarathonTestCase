package testngmarathon;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
	public class TestCase_001 extends ProjectSpecificMethod{
		@BeforeTest
		   public void setup() {
			   sheet="TestCase_001";
		   }
		@Test(dataProvider="fetchData")
		public  void chatterTest(String Question,String detail) throws InterruptedException {
			
				// Click on toggle menu button from the left corner 
			driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
				// Click view All and click Sales from App Launcher 
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("content");
			driver.findElement(By.xpath("//mark[text()='Content']")).click();
			WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
			driver.executeScript("arguments[0].click();",chatter );
			Thread.sleep(2000);
			String title = driver.getTitle();
			if(title.contains("Chatter Home")) {
				System.out.println("Title Matched");
			}
			else {
				System.out.println("Title Not Matched");
			}
			driver.findElement(By.xpath("//span[text()='Question']")).click();
			driver.findElement(By.xpath("//textarea[contains(@class,'cuf-questionTitle')]")).sendKeys(Question,Keys.TAB);
			driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(detail);
			driver.findElement(By.xpath("//button[text()='Ask']")).click();
			Thread.sleep(2000);
			String question = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
			System.out.println(question);
			if(question.equalsIgnoreCase(question)) {
				System.out.println("Question Appears");
			}
			else {
				System.out.println("Question Not Appears");
			}

}
}