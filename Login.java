package salesfrce.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Login {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		/*Step 1: Login to Login | Salesforce  
		 * 
		

		username: gokul.sekar@testleaf.com
		password: Leaf$321


		Click on toggle menu button from the left corner

		Click view All and click Sales from App Launcher

		Click on Accounts tab 

		Click on New button

		Enter 'your name' as account name

		Select Ownership as Public                                       

		Click save and verify Account name 

		Expected Result:
		Account should be created Successfully
	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("//*[@id='username']")).sendKeys("gokul.sekar@testleaf.com");
		
*/
		
	


		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Step 1: Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
		Thread.sleep(5000);
		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//Click on Accounts tab 
		// driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);

		//Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();


		//Enter 'your name' as account name
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Nandhini");


		//Select Ownership as Public 
		driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]")).click();

		//Click save and verify Account name 
		driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);

		}

		}
