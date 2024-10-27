package Sprint_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class NBAStatisticsAssesment {

	public void Nba() throws InterruptedException {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.nba.com/stats");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();
		Actions ac = new Actions(driver);
		WebElement accpt = driver.findElement(By.xpath("//button[text()='I Accept']"));
		Thread.sleep(6000);
		ac.moveToElement(accpt).click();

		// driver.switchTo().alert().accept();

		// click season and select season
		driver.findElement(By.xpath("(//div[@class='DropDown_dropdown__TMlAR'])[1]")).click();
		ac.moveToElement(accpt).click();
		WebElement dropdownSeason = driver.findElement(By.xpath("//select[contains(@class, 'DropDown')]"));
		Select objSelect = new Select(dropdownSeason);
		objSelect.selectByVisibleText("2023-24");

		WebElement dropdownSeasontyp = driver.findElement(By.xpath("(//select[contains(@class, 'DropDown')])[2]"));
		Select objSelect2 = new Select(dropdownSeasontyp);
		objSelect2.selectByVisibleText("NBA Cup");

		WebElement dropdownMode = driver.findElement(By.xpath("(//select[contains(@class, 'DropDown')])[3]"));
		Select objSelect3 = new Select(dropdownMode);
		objSelect3.selectByVisibleText("Per Game");

		WebElement dropdownSegment = driver.findElement(By.xpath("(//select[contains(@class, 'DropDown')])[4]"));
		Select objSelect4 = new Select(dropdownSegment);
		objSelect4.selectByVisibleText("Last Game");

		Thread.sleep(3000);

		List<WebElement> AgeList = driver.findElements(By.xpath("(//tbody)[3]//td[4]"));
		List<Integer> ages = new ArrayList<>();
		for (WebElement age : AgeList) {
			int EachAge = Integer.parseInt(age.getText());// faced issue here hence googled
			ages.add(EachAge);
			Collections.sort(ages);
			// System.out.println(ages);
		}
		System.out.println("Players of All Ages" + ages);
		Integer YoungestPlayer = ages.get(0);
		System.out.println("Youngest Player Age:" + YoungestPlayer);

		List<WebElement> checkAge = driver.findElements(By.xpath("(//tbody)[3]//tr//td[4]"));
		for (WebElement findAge : checkAge) {

			// (//tbody)[3]//tr[14]//td[text()='20']
			// (//tbody)[3]//tr[14]//td[2]
			for (int i = 0; i <= ages.size(); i++) {
				if (findAge.getText().equals(YoungestPlayer)) {
					WebElement clickOnPlayer = driver
							.findElement(By.xpath("(//tbody)[3]//tr[" + i + "]//td[text()='" + YoungestPlayer + "']"));
					driver.executeScript("arguments[0].click();", clickOnPlayer);

				}
			}

		}
		
		String ExperienceOfPlayer = driver.findElement(By.xpath("(//p[text()='EXPERIENCE'])[1]//following::p[1]")).getText();
		System.out.println("Experience of Player:"+ExperienceOfPlayer);

	}

}
