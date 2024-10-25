package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteAccount {
	@Test
	public void deleteAccount() throws InterruptedException{
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
	WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']/child::span[text()='Accounts']"));
	driver.executeScript("arguments[0].click();",accounts);
	driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Nandhini");
	driver.findElement(By.xpath("//div[@data-aura-class='forceListViewManagerHeader']")).click();
	Thread.sleep(10000);
	String originalstr = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	String[] textarray = originalstr.split(" ");
	int originalval = Integer.parseInt(textarray[0]);
	System.out.println(originalval);
	if(originalval!=0) {
		driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/child::a")).click();
	driver.findElement(By.xpath("//a[@title='Delete']")).click();
	driver.findElement(By.xpath("//span[text()='Delete']")).click();
	String popup = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
	System.out.println(popup);
	Thread.sleep(10000);
	String newstr = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	String[] newarray = newstr.split(" ");
	int newvalue = Integer.parseInt(newarray[0]); 
	System.out.println(newvalue);
	if(newvalue == (originalval-1))
	{
		System.out.println("Record hasbeen deleted.");
	}else {System.out.println("Record is not deleted.");}
	}else {
		System.out.println("No such record");
	}
	
}
}
