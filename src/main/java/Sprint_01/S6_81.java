package Sprint_01;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class S6_81 {
	public RemoteWebDriver driver;

	@Test
	public void testA() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 1: Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='Home']")).click();
		//3. Click on the 'File'
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='File']")).click();
		//4. Click on 'Select a file from Salesforce'
		driver.findElement(By.xpath("//a[@title='Select a file from Salesforce']")).click();
		//5. Click on 'Owned by Me'
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
		driver.findElement(By.xpath("//span[text()='Owned by Me']")).click();
		//6. Search for 'Maven'
		driver.findElement(By.xpath("//input[@title='Search Files I Own...']")).sendKeys("Maven",Keys.ENTER);
		//7. Click on the 'Attach' for Maven file
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-seclke='ContentVersion']")));
			driver.findElement(By.xpath("//a[@data-seclke='ContentVersion']")).click();
			}catch(StaleElementReferenceException e)
			{
				System.out.println("Stale element reference exception"+e.getMessage());
			}
		//driver.findElement(By.xpath("//span[text()='Attach']")).click();
		//8. Click on the 'Share' Button
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title='Share']")).click();
		//9. Click on the 'More Actions'
		driver.findElement(By.xpath("//span[text()='More Actions']")).click();
		//10. Click on the 'File Sharing Settings'
		driver.findElement(By.xpath("//span[text()='File Sharing Settings']")).click();
		//11. Change permissions as 'Collaborators'
		//driver.findElement(By.xpath("(//img[@class='tinyDownArrowIcon'])[2]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[@class='permissionLabel']")).getText();
		System.out.println(text);
		//12. Enable the checkBox for 'Prevent others from sharing and unsharing'
		WebElement element = driver.findElement(By.xpath("//label[@id='sharingOptionLabel']"));
		System.out.println("Option is already enabled"+element.isEnabled());
		if(element.isEnabled()==false)
		{
			element.click();
		}
		else System.out.println("Checkbox is already checked");
		//13. Verify the checkbox is Enabled
		//14. Click on the 'Close' button.
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		//15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Click to add topics:']")).click();
		//16. Verify the Topics as 'Maven Installtion Guide'
		driver.findElement(By.xpath("//textarea[text()='Add your own topics or choose from our suggestions.']")).sendKeys("Maven installation guide",Keys.ENTER);
		//17. Click on the widget dropdown for post and click 'Delete'
		driver.findElement(By.xpath("//a[@title='More Actions']")).click();
		
		driver.findElement(By.xpath("//a[@title='Delete this post']")).click();
		//String parent1=driver.getWindowHandle();
		Thread.sleep(2000);
		Set<String>s1=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I2= s1.iterator();
		while(I2.hasNext())
		{
		String child_window=I2.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
		
		//18. Click on the 'Ok' Button.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='OK']")).click();
		//19. Verify the post is Deleted.
	}
}
