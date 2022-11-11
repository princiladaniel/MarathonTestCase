package firstmarathonsolutioncode;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
public static void main(String[] args) throws InterruptedException {
	//Testcase:3-Create Task

	//1) Launch the browser
	WebDriverManager.chromedriver().setup();
	ChromeOptions ch=new ChromeOptions();
	ch.addArguments("--disable-notifications");
	ChromeDriver driver =new ChromeDriver(ch);
	driver.get("https://login.salesforce.com/?locale=in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//enter the username
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	//enter the password
	driver.findElement(By.id("password")).sendKeys("Testleaf$321");
	//click Login
	driver.findElement(By.id("Login")).click();
	//4) Click on Global Actions SVG icon(App Launcher)
	driver.findElement(By.className("slds-icon-waffle")).click();
	//5) Click view all
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	//6) Type task and select task
	driver.findElement(By.xpath("//div[contains(@class,'slds-form-element')]/input")).sendKeys("Tasks");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mark[text()='Tasks']")).click();
	//7) Click New Task under dropdown icon 
	Thread.sleep(2000);
	
	WebElement drop = driver.findElement(By.xpath("//div[@class='uiPopupTrigger']//a"));
	drop.click();
	
	WebElement newTask = driver.findElement(By.xpath("//a[@title='New Task']"));
	driver.executeScript("arguments[0].click();",newTask);
	//8) Enter subject as "Bootcamp "
	driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("BootCamp");
	//9) Select status as 'Waiting on someone else'
	driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
	driver.findElement(By.xpath("(//a[text()='Waiting on someone else'])[1]")).click();
	//10) Save and verify the 'Task created' message
	 driver.findElement(By.xpath("//span[text()='Save']")).click();
	
	String attribute = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds')]/a")).getAttribute("title");
	System.out.println(attribute);
	//verify
	if(attribute.contains("BootCamp")) {
		System.out.println("Task was created");
	}
	else {
		System.out.println("task not created");
	}
	//close the browser
	driver.close();
	
}


}