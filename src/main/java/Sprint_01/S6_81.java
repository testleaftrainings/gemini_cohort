package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
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
		driver.findElement(By.xpath("//a[@title='File']")).click();
		//4. Click on 'Select a file from Salesforce'
		//5. Click on 'Owned by Me'
		//6. Search for 'Maven'
		//7. Click on the 'Attach' for Maven file
		//8. Click on the 'Share' Button
		//9. Click on the 'More Actions'
		//10. Click on the 'File Sharing Settings'
		//11. Change permissions as 'Collaborators'
		//12. Enable the checkBox for 'Prevent others from sharing and unsharing'
		//13. Verify the checkbox is Enabled
		//14. Click on the 'Close' button.
		//15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
		//16. Verify the Topics as 'Maven Installtion Guide'
		//17. Click on the widget dropdown for post and click 'Delete'
		//18. Click on the 'Ok' Button.
		//19. Verify the post is Deleted.
	}
}
