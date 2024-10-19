package sprint_01;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sample2 {
	@Test
	public void testA() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		// driver = new ChromeDriver(options);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		// username: gokul.sekar@testleaf.com
		// password: Leaf$321

		// Click on toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Click on contacts under 'All Items'
		WebElement element = driver.findElement(By.xpath("//p[text()='Contacts']"));
		driver.executeScript("arguments[0].click();", element);
		//Get the size of conatcts available and print the list
		Thread.sleep(3000);
		//WebElement contactName = driver.findElement(By.xpath("(//a[contains(text(),'Naveen Elumalai')])[13]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", contactName);
		//js.executeScript("window.scrollBy(0,550)", "");
		long temp = 0;
        while (true) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2500);
            long start = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            if (start == temp) {
                break;
            }
            temp = start;
        }
        System.out.println("completed the scroll");
		//Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println(text);
	}
}