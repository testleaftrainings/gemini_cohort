package Sprint_01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EditCase {
	@Test
	public void editTestCase() throws InterruptedException, AWTException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement cases = driver.findElement(By.xpath("//a[@title='Cases']"));
		driver.executeScript("arguments[0].click();",cases);
		
		//driver.findElement(By.xpath("//span[text()='Show Actions']")).click();
		//driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//div[@data-aura-class= 'forceVirtualAction']/child::a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='Status']")).click();
		
		driver.findElement(By.xpath("//span[@class='slds-media__body']/following::span[text()='Working']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Priority']")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Case Origin']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250);");
        WebElement nextElement = driver.findElement(By.xpath("//button[@aria-label='SLA Violation']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextElement);

        nextElement.click();
		//driver.findElement(By.xpath("//button[@aria-label='SLA Violation']")).click();
		driver.findElement(By.xpath("//span[text()='No']")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String popup = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(popup);
		
		
		
		
		
		
	}

}
