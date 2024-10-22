package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_25_CreateLegalEntityWithoutMandatoryFields extends TestBase{
    @Test
    public void S6_25_CreateLegalEntityWithoutMandatoryFields() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        //Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement legalEntities = driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));
        //Scroll to legal entities
        js.executeScript("arguments[0].scrollIntoView();", legalEntities);
        js.executeScript("arguments[0].click()", legalEntities);
        //4. Click on the Dropdown icon in the legal Entities tab
        Thread.sleep(3000);
        legalEntities.sendKeys("+{TAB}");
        legalEntities.sendKeys("+{TAB}");
        legalEntities.sendKeys("+{TAB}");
        legalEntities.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='New Legal Entity']")).click();
        //driver.findElement(By.xpath("//div[@title='New' and text()='New']")).click();
        driver.findElement(By.xpath("(//label[ text()='Company Name']/following::input)[1]")).sendKeys("Test Leaf");
        driver.findElement(By.xpath("//label[ text()='Description']/following::textarea")).sendKeys("SalesForce");
        //Select status
        WebElement Status = driver.findElement(By.xpath("//button[@type='button' and @aria-label='Status']"));
        js.executeScript("arguments[0].scrollIntoView();", Status);
        Status.click();
        driver.findElement(By.xpath("//span[@class='slds-truncate' and @title='Active']")).click();
        //9. Click on Save
        driver.findElement(By.xpath("//button[contains(text(),'Save') and @name='SaveEdit']")).click();
        //Assert
        String ExpectedErrorMessage = "We hit a snag.";
        String ActualErrorMessage = driver.findElement(By.xpath("//h2[text()='We hit a snag.']")).getText();
        Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage);
        String ExpectedErrorField = "Legal Entity Name";
        String ActualErrorField = driver.findElement(By.xpath("//a[contains(text(),'Legal Entity Name')]")).getText();
        Assert.assertEquals(ActualErrorField, ExpectedErrorField);
    }
}
