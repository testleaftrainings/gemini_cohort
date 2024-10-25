package salesfrce.crm;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class s6_61_EditTask {
	
	@Test
	public void editTask() throws InterruptedException{
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
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("email");
		driver.findElement(By.xpath("//div[@data-aura-class='forceListViewManagerHeader']")).click();
		//driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@title='Show 6 more actions']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[text()='Due Date']/..//input")).sendKeys("15/11/2024");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputDate'])[9]")).click();
		
		
		
				
				
				
				
				
		
	}
	

}
