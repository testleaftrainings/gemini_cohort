package salesfrce.crm;

/*
 * https://www.cheapoair.com/
 *1. Select one way trip
 *2. Select Destination
 *3. Select Travel date
 *4. Select 2 adults & Click on Done
 *5. Click search Flights
 *6. Write a logic to find the lowest price and Select the lowest price flight
 * 
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class debug {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.cheapoair.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='onewayTrip']")).click();

		driver.findElement(By.id("from0")).sendKeys("MAA",Keys.TAB);
		WebElement textBox=driver.findElement(By.id("to0"));
		driver.findElement(By.xpath("(//a[@class='suggestion-box__clear icon'])[2]")).click();
		Thread.sleep(2000);
		textBox.sendKeys("BLR");
		driver.findElement(By.xpath("//div[@class='suggestion-displayText']")).click();
		
		driver.findElement(By.xpath("//input[@aria-label='Choose a departure date. expanded']")).click();
		driver.findElement(By.xpath("//a[@aria-label='14 October 2024']")).click();
//		driver.findElement(By.xpath("//input[@aria-label='Choose a return date. expanded']")).click();
//		driver.findElement(By.xpath("//a[@aria-label='15 October 2024']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("travellerButton")).click();
		driver.findElement(By.id("addadults")).click();
		driver.findElement(By.id("closeDialog")).click();
		driver.findElement(By.id("searchNow")).click();

		List<WebElement> allElements = driver.findElements(By.xpath("//span[@class='fpamount fpRoundToFixDecimal']"));
		List<Double> allPrice = new ArrayList<Double>();
	
		for (WebElement eachEle : allElements) {
			String priceInString = eachEle.getAttribute("innerText");
			double priceInDouble = Double.parseDouble(priceInString);
			allPrice.add(priceInDouble);
		}
		System.out.println(allPrice);
		Collections.sort(allPrice); // Write a logic to find the least price
		Double least = allPrice.get(0);

		driver.findElement(By.xpath("//span[contains(@title,'" + least + "')]/following::span[text()='Select']")).click();

	}

}



