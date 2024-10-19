package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class SampleAccountCreation_SalesForce {
	
	@Test
	public void createAccount() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']//div[1]")).click();
		
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on Accounts tab 
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click()", eleAccounts);
		
		
		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//label[text()='Account Name']//following::input[1]")).sendKeys("Vaishu");

		//Select Ownership as Public                                       
		WebElement buttonOwnership = driver.findElement(By.xpath("//label[text()='Ownership']//following::button[1]"));
		driver.executeScript("arguments[0].click()",buttonOwnership);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='Public']")).click();

		//Click save and verify Account name 
		driver.findElement(By.xpath("//label[text()='Description']//following::button[text()='Save']")).click();
		
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

	}

}
