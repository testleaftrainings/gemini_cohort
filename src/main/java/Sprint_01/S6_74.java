package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S6_74 extends LocalTestBase_A {
	@Test
	public void testA() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		// Click view All and click Service Console from App Launcher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='Contracts']"));
		driver.executeScript("arguments[0].click();", element);
//		Click on the Dropdown icon in the Contract tab
		driver.findElement(By.xpath("(//a[contains(@title,'Contracts')]/following::span[1])[2]")).click();
//		Click on New Contract
		WebElement element2 = driver.findElement(By.xpath("//span[text()='New Contract']"));
		driver.executeScript("arguments[0].click();", element2);
//		Select the accounts listed on the'Account Name' field
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).sendKeys("Testing001");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Testing001']")).click();
//		Select the Contract Start Date as Tommorow's Date
		driver.findElement(By.xpath("//input[@name='StartDate']")).sendKeys("25/10/2024");
//		Click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
//		Verify the Alert message(These required fields must be completed: Contract Term (months)) 
		String text = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("(//a[contains(@href,'javascript:void')and text()])[3]")).getText();
		System.out.println(text2);


	}
}
