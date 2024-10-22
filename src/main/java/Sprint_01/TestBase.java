package Sprint_01;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public  RemoteWebDriver driver;
    @BeforeMethod
    public void initTest() throws MalformedURLException{

    	EdgeOptions options = new EdgeOptions();
        DesiredCapabilities dc = new DesiredCapabilities(options);
		dc.setBrowserName("MicrosoftEdge"); //
		dc.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);

        driver.get("https://login.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //Step 1: Login to Login | Salesforce
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
        driver.findElement(By.id("Login")).click();
    }

    /*@AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }*/
}
