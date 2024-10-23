package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S6_57 extends LocalTestBase {
	
	@Test
	public void testA() throws InterruptedException 
	{
		//Click on menu button from the Left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click view All and click Service Console from App Launcher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();

		//Click on the drop down and select Orders
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		WebElement element = driver.findElement(By.xpath("(//span[text()='Orders'])[2]"));
		driver.executeScript("arguments[0].click();", element);

		//Click drop down near Recently Viewed and Select All Orders
		driver.findElement(By.xpath("//button[@title='Select a List View: Orders']")).click();
		driver.findElement(By.xpath("//span[text()='All Orders']")).click();

		//Select first result, click the dropdown of the result and click on Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@role='button'])[11]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		//Click on the close button form the Account Name Field and Select Account name as Testing001
		driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]")).click();
		driver.findElement(By.xpath("(//span[@title='Credits'])[1]")).click();

		//Click on the close button form theContract Number field and select Contract number as 00000104
		driver.findElement(By.xpath("(//button[@title='Clear Selection'])[1]")).click();
		driver.findElement(By.xpath("//span[@title='00000135']")).click();

		//Click Save Expected Result:
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//New account name and respective Contract number should be saved Step Video:   
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

	}

}
