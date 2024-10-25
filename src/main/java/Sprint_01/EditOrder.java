package Sprint_01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditOrder {
	
	@Test
	
	public void orderEdit() throws InterruptedException, AWTException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	
		driver.findElement(By.xpath("//h2[text()='App Launcher']/following::input[@type='search']")).sendKeys("Orders");
		
		driver.findElement(By.xpath("(//*[text()='All Items']/following::mark[text()='Orders'])[2]")).click();
		driver.findElement(By.xpath("//button[@title ='Select a List View: Orders']")).click();
		driver.findElement(By.xpath("//span[text() ='All Orders']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/child::a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]")).click();
		WebElement accname = driver.findElement(By.xpath("(//input[@aria-haspopup='listbox'])[2]"));
		accname.sendKeys("Testleaf software");
		 Robot robot = new Robot();
		 Thread.sleep(5000); 
	        // Simulate pressing the down arrow key and selecting the value
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);
	        Thread.sleep(500);  // Adjust the sleep time if necessary
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);
	        Thread.sleep(500);  // Adjust the sleep time if necessary
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//button[@title='Clear Selection'])[1]")).click();
			WebElement contactnum = driver.findElement(By.xpath("(//input[@aria-haspopup='listbox'])[1]"));
			contactnum.sendKeys("00000133");
			Robot robot1 = new Robot();
			 Thread.sleep(5000); 
		        // Simulate pressing the down arrow key and selecting the value
		        robot1.keyPress(KeyEvent.VK_DOWN);
		        robot1.keyRelease(KeyEvent.VK_DOWN);
		        Thread.sleep(500); // Adjust the sleep time if necessary
		        robot1.keyPress(KeyEvent.VK_DOWN);
		        robot1.keyRelease(KeyEvent.VK_DOWN);
		        Thread.sleep(500);  // Adjust the sleep time if necessary
		        robot1.keyPress(KeyEvent.VK_ENTER);
		        robot1.keyRelease(KeyEvent.VK_ENTER);
//        
		        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				String popup = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
				System.out.println(popup);
	}

}
