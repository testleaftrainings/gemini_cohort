package salesfrce.crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FollowUpTask {
	
	public void taskFollowup() throws InterruptedException{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement content = driver.findElement(By.xpath("//p[text()='Content']"));
		driver.executeScript("arguments[0].click();",content);
		driver.findElement(By.xpath("//a[@aria-label = 'View All Tasks']")).click();
		Thread.sleep(10000);
	}

}
