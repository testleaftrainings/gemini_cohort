package salesfrce.crm;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaign {
	@Test
	public void campaignCreate() throws InterruptedException {
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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(4000);
		WebElement campaign = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();",campaign);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Add Leads']")).click();
		Thread.sleep(4000);
		WebElement search = driver.findElement(By.xpath("//input[@title='Search Leads']"));
//		 Actions actions = new Actions(driver);
//
//	        // Perform double click
//	        actions.doubleClick(search).perform();
        driver.executeScript("arguments[0].click();", search);
        Thread.sleep(4000);
		search.sendKeys("a");
		search.clear();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[text()='New Lead']")).click();
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Nandhini");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kandasamy");
		driver.findElement(By.xpath("(//span[text()='Company'])[2]/../following-sibling::input")).sendKeys("Test Leaf");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		driver.findElement(By.xpath("//span[@class='pillText']")).click();
		Thread.sleep(000);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//html/body")).sendKeys(Keys.PAGE_DOWN);Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='slds-card__footer'])[5]")).click();
		Thread.sleep(4000);
		WebElement name = driver.findElement(By.xpath("//span[@title='Name']/../following::*[text()='Nandhini Kandasamy']"));
		name.click();
		String nameval = name.getText();
		System.out.println(nameval);
		
				
		
	}

}
