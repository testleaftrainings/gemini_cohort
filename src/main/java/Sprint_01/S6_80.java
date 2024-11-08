package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class S6_80 {
	public RemoteWebDriver driver;
	@Test
	public void testA() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.get("https://login.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //Step 1: Login to Login | Salesforce
        driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Home']")).click();
        //3. Choose 'Account' from the dropdown
        Select objSelect =new Select(driver.findElement(By.id("createNewSelect")));
        objSelect.selectByVisibleText("Account");
        //4. Click on the 'Go!' button.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='createNewGo']")).click();
        //5. Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
        driver.findElement(By.xpath("//input[@id='acc2']")).sendKeys("BootCamp Puppeteer_Aravinth_D");
        //6. Enter the Billing Address
       driver.findElement(By.xpath("//textarea[@id='acc17street']")).sendKeys("Balaji nagar");
       driver.findElement(By.xpath("//input[@id='acc17city']")).sendKeys("Chennai");
       driver.findElement(By.xpath("//input[@id='acc17zip']")).sendKeys("600087");
       driver.findElement(By.xpath("//input[@id='acc17state']")).sendKeys("TamilNadu");
       driver.findElement(By.xpath("//input[@id='acc17country']")).sendKeys("India");
        //7. Click Copy Billing Address to Shipping Address link
       driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();
        //8. Verify the Shipping Address reflects the Billing Address
        //9. Enter the SLA Expiration Date as Current Date + 20 days
       driver.findElement(By.xpath("//input[@id='00N5i00000LydkL']")).sendKeys("15/11/2024");
        //10. Click on Save button.
       driver.findElement(By.xpath("//input[@name='save']")).click();
        //11. Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
       String text = driver.findElement(By.xpath("//h2[@class='topName']")).getText();
       System.out.println(text);
        //12. Navigate to Accounts tab and Verify the newly Created account is displayed
       driver.findElement(By.xpath("//a[@title='Accounts Tab - Selected']")).click();
       Thread.sleep(2000);
       String text2 = driver.findElement(By.xpath("//th[@class=' dataCell  ']/a[1]")).getText();
       System.out.println(text2);
        //13. Close the browser Expected Result:
        //Verify the newly Created account is displayed
		
	}

}
