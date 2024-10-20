package salesfrce.crm;

import java.time.Duration;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	@Test
	public void mobileView() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		String mainwindowhandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		Set<String>  windowhandles = driver.getWindowHandles();
		for (String handle:windowhandles) {
			driver.switchTo().window(handle);
		}
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow shado = new Shadow(driver);
		WebElement products = shado.findElementByXPath("//span[text()='Products']");
		products.click();
//		WebElement service = shado.findElementByXPath("//*[text()='Service']");
//		Actions act = new Actions(driver);
//		act.moveToElement(service).perform();
		
		 // Locate the Service element
        WebElement service = shado.findElementByXPath("//*[text()='Service']");

        // Use JavaScript to perform mouse hover
        String jsHoverScript = "var event = new MouseEvent('mouseover', { 'view': window, 'bubbles': true, 'cancelable': true }); arguments[0].dispatchEvent(event);";
        ((JavascriptExecutor) driver).executeScript(jsHoverScript, service);

		
		
		
	}
	
}
