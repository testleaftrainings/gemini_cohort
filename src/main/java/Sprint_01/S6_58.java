package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S6_58 extends TestBase{
	
	@Test
	public void testA() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//Click view All and click Service Console from App Launcher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on Content tab
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		//Click View All from Today's Task
		driver.findElement(By.xpath("(//span[text()='View All'])[2]")).click();
		//Click on Show one more Action and click New Task
		driver.findElement(By.xpath("//a[@title='Show 2 more actions']")).click();
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
	//	Select a Account Name in Assigned to field 
		driver.findElement(By.xpath("(//span[text()='jeyagokul sekar'])[2]")).click();		
	//	Select a subject as Email
		driver.findElement(By.xpath("//input[contains(@id,'combobox-input')]")).click();
		driver.findElement(By.xpath("//span[contains(@title,'Email')]")).click();
		//Set Priority as High and Status as In Progress
		driver.findElement(By.xpath("(//a[contains(@role,'combobox')])[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'High')]")).click();
		driver.findElement(By.xpath("(//a[contains(@role,'combobox')])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'In Progress')]")).click();
		//Click on the image of Name field, click on Contacts and select Contact
		driver.findElement(By.xpath("(//a[contains(@class,'icon ')])[14]")).click();
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@part='formatted-rich-text' and text()='Test Leaf']")).click();
	//	Click on the image of Related To field, click on Product and Select Product
		driver.findElement(By.xpath("(//a[contains(@class,'icon ')])[15]")).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(@title,'Products')]"));
		driver.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//input[@title='Search Products']")).click();
		driver.findElement(By.xpath("(//span[text()='JeyaGokul'])[27]")).click();
	//	Click Save Expected Result:      
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
	}

}
