package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("pills-home-tab")).click();
		driver.findElement(By.id("source")).sendKeys("chennai");
		driver.findElement(By.xpath("//li[@class='ui-menu-item ui-state-focus']")).click();
		driver.findElement(By.id("destination")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@class='ui-menu-item ui-state-focus']")).click();
		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.xpath("(//a[@class='ui-state-default'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		String text = driver.findElement(By.xpath("//h2[@class='TravelAgntNm ng-binding']")).getText();
		System.out.println(text);
		driver.findElement(By.id("Bustypes4")).click();
		String text2 = driver.findElement(By.xpath("//p[@class='noseats AvailSts ng-binding']")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("//span[@class='book']")).click();
		driver.findElement(By.xpath("//a[@class='tooltip tooltipstered']")).click();
		String text3 = driver.findElement(By.id("seatnos")).getText();
		System.out.println(text3);
		String text4 = driver.findElement(By.id("ticketfare")).getText();
		System.out.println(text4);
		Thread.sleep(2000);
		WebElement drop1 = driver.findElement(By.id("boardingpoint_id"));
		Select board =new Select(drop1);
		board.selectByIndex(1);
		WebElement drop2 = driver.findElement(By.id("droppingpoint_id"));
		Select dropping =new Select(drop2);
		dropping.selectByIndex(1);
		System.out.println(driver.getTitle());
		driver.close();
	}

}
