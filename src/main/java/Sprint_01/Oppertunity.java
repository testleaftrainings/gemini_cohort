package Sprint_01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Oppertunity extends LocalTestBase {
	@Test
	public void oppertunity() {
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement oppertunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();",oppertunity);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		 LocalDate tomorrow = LocalDate.now().plusDays(1);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String tomorrowDate = tomorrow.format(formatter);
	        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(tomorrowDate);
	    	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='fieldLevelErrors']//following::ul/li/a"));
        List<String> values = new ArrayList<>();
	         for (WebElement element : elements) {
	        	 values.add(element.getText());
	         }
	    String valueToCheck = "Opportunity Name";
	    String valueToCheck1 = "Stage";
	    
	    if (values.contains(valueToCheck)) {
	    	 if (values.contains(valueToCheck1)) {
	             System.out.println("Test case passed. "+valueToCheck+" , "+valueToCheck1+" fields are missing.");
	    	   }
        } else {
            System.out.println("Test case failed!");
        }
	}

}
