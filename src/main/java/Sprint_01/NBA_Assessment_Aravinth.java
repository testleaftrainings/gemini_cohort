package Sprint_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NBA_Assessment_Aravinth {
	public RemoteWebDriver driver;

	@Test
	public void testA() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 1. Navigate to https://www.nba.com/stats
		driver.get("https://www.nba.com/stats");
		driver.findElement(By.xpath("//button[text()='I Accept']")).click();
		// 2. Click on 'See All Player Stats'
		driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();
		// 3. Choose 'Season' as '2023-24'
		Select obj = new Select(driver.findElement(By.xpath("//select[contains(@class,'DropDown_select')]")));
		obj.selectByVisibleText("2023-24");
		// 4. Choose 'Season Type' as 'NBA Cup'
		Select obj1 = new Select(driver.findElement(By.xpath("(//select[contains(@class,'DropDown_select')])[2]")));
		obj1.selectByVisibleText("NBA Cup");
		// 5. Choose 'Per Mode' as 'Per Game'
		Select obj2 = new Select(driver.findElement(By.xpath("(//select[contains(@class,'DropDown_select')])[3]")));
		obj2.selectByVisibleText("Per Game");
		// 6. Choose 'Season Segment' as 'Last Game'
		Select obj3 = new Select(driver.findElement(By.xpath("(//select[contains(@class,'DropDown_select')])[4]")));
		obj3.selectByVisibleText("Last Game");
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//span[contains(text(),'dialog')]")).click();
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'dialog')]/preceding::button[1])[2]")));
				//("//span[contains(text(),'dialog')]")));
		driver.findElement(By.xpath("(//span[contains(text(),'dialog')]/preceding::button[1])[2]")).click();
		}catch(Exception e)
		{
			System.out.println("TimeoutException");
		}
		// driver.findElement(By.xpath("//span[text()='close email sign up
		// banner']")).click();
		// 7. Click on the player name with lowest age
		List<WebElement> list = driver.findElements(By.xpath("//td[@class='Crom_text__NpR1_']/following::td[1]"));
		Thread.sleep(3000);
		List<Integer> allAges = new ArrayList<Integer>();
		for (WebElement eachAge : list) {
			String priceInString = eachAge.getText();
			int priceInDouble = Integer.parseInt(priceInString);
			allAges.add(priceInDouble);
		}

		Collections.sort(allAges); // Write a logic to find the least price
		int leastAge = allAges.get(0);
		// System.out.println(leastAge);
		// 8. Click on the Profile
		WebElement element = driver.findElement(By.xpath("//td[text()= '" + leastAge + "']/preceding::a[2]"));
		driver.executeScript("arguments[0].click();", element);
		// 9. Get the Experience of the player
		String text = driver.findElement(By.xpath("//p[text()='EXPERIENCE']/following::p[1]")).getText();
		System.out.println(text);
		boolean equals = text.equals("1 Year");
		System.out.println(equals);
		// 10. Verify the player experience as 1.
	}

}
