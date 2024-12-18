package Sprint_01;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S6_46_Delete_Attachmen_Campaign extends TestBase {


	@Test
	public void editCampaign() throws InterruptedException, MalformedURLException {
		// Click on toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Click view All and click Sales from App Launcher--view all-sales
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement campaigns = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaigns);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();

		Thread.sleep(3000);
		WebElement attach = driver
				.findElement(By.xpath("//span[@class='view-all-label']//following::span[text()='Attachments']"));
		driver.executeScript("arguments[0].click();", attach);

		Thread.sleep(3000);
		WebElement drpdown = driver.findElement(By.xpath("(//tbody//tr[1]//th)[3]//following::a[@role='button']"));
		driver.executeScript("arguments[0].click();", drpdown);

		Thread.sleep(3000);
		WebElement dele = driver.findElement(By.xpath("//div[@title='Delete']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dele).click().perform();

		Thread.sleep(3000);
		WebElement delecConfirm = driver.findElement(By.xpath("//span[text()='Delete']"));
		ac.moveToElement(delecConfirm).click().perform();

		Thread.sleep(3000);
		String SuccessMesg = driver
				.findElement(By.xpath("(//div[@role='alert'])[3]//following::span[contains(@class,'toastMessage')]"))
				.getText();
		System.out.println(SuccessMesg);

	}

}
