package salesfrce.crm;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class UpdateContact {

	@Test
	public void contactUpdate() throws InterruptedException{
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
		driver.findElement(By.xpath("//h2[text()='App Launcher']/following::input[@type='search']")).sendKeys("Contacts");
		
		driver.findElement(By.xpath("//*[text()='All Items']/following::mark[text()='Contacts']")).click();
		Thread.sleep(10000);
		String newstr = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
		System.out.print(newstr);
		String[] newarray = newstr.split(" ");
		int newvalue = Integer.parseInt(newarray[0]); 
		System.out.println("Total contacts: "+newvalue);
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Naveen");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-aura-class='forceListViewManagerHeader']")).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//div[@data-aura-class ='forceInlineEditGrid']")).click();
		driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/child::a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(6000);
		WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
		
		email.clear();
		email.sendKeys("nandhini123@gmail.com");
		Thread.sleep(5000);
//		WebElement scroll = driver.findElement(By.xpath("//button[@aria-label='Lead Source']"));
//		Actions action = new Actions(driver);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,350)", "");
//		action.moveToElement(scroll).perform();
//		driver.findElement(By.xpath("//button[@aria-label='Lead Source']")).click();
		WebElement element3 = driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Source')]"));
		driver.executeScript("arguments[0].click();",element3); 
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		driver.findElement(By.xpath("//label[text()='Mailing Street']/following::textarea[@autocomplete='street-address']")).sendKeys("barathamatha street, Selaiyur");
		WebElement level = driver.findElement(By.xpath("//button[@aria-label='Level']"));
		driver.executeScript("arguments[0].click();",level);
		driver.findElement(By.xpath("//span[text()='Tertiary']")).click();
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("Automation Testing");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String popup = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(popup);
		Thread.sleep(5000);
		String Savedemail = driver.findElement(By.xpath("//a[@data-aura-class='emailuiFormattedEmail']")).getText();
		System.out.println("email: "+Savedemail);
		if(Savedemail.contains("nandhini123@gmail.com")) {
			System.out.println("Test case is passed");
			
		}else {
			System.out.println("Test case is failed");
		}
	}
	
}
