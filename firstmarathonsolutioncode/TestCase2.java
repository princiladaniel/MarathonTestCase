package firstmarathonsolutioncode;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {
	public static void main(String[] args) throws InterruptedException {
	/*
	 * TestCase:1-Create Contact
	 */
	//setup the path
	WebDriverManager.chromedriver().setup();
	//disable notifications
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(option);
	// Load url : https://login.salesforce.com
	driver.get("https://login.salesforce.com/");
	////manage ur window
	driver.manage().window().maximize();
	//add wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//enter username	
    driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	//enter password
	driver.findElement(By.id("password")).sendKeys("Testleaf$321");
	//click login button
	driver.findElement(By.id("Login")).click();
	//Click on toggle menu button from the left corner
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	//Click view All and
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	// click Sales from App Launcher
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	//Click on Account tab 
	WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
	driver.executeScript("arguments[0].click();",account );
	//Click on New button
	driver.findElement(By.xpath("//div[text()='New']")).click();
	//Enter 'your name' as account name
	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Princila");		
	//Select Ownership as Public
	WebElement lstBox = driver.findElement(By.xpath("(//button[@aria-haspopup='listbox'])[3]"));
	driver.executeScript("arguments[0].click();",lstBox );
    Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Public']")).click();
	//click save
		driver.findElement(By.xpath("//button[text()='Save']")).click();	
	//verify message
		
    String verification = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading')]")).getText();
   System.out.println(verification);
    if(verification.contains("Princila")) {
	System.out.println("Account was created");
}
else {
	System.out.println("No Account was not Created");
}
  //close the browser
  	driver.close();
	}
}
