package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class S6_13CreateCasewithoutMandatoryFields extends TestBase {
    @Test(description = "CreateCasewithoutMandatoryFields")
    public void CreateCasewithoutMandatoryFields() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
       // ((JavascriptExecutor) driver).executeScript()
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", sales);
        //Click on More--> Cases tab
        Thread.sleep(5000);
        WebElement moreTab = driver.findElement(By.xpath("//span[text()='More']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", moreTab);
        WebElement caseTab = driver.findElement(By.xpath("(//span[contains(text(),'Cases')])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", caseTab);
        //Click on New button
        driver.findElement(By.xpath("//div[text()='New']")).click();
        // Choose Contact Name from DropDown
        Thread.sleep(5000);
        WebElement contactName = driver.findElement(By.xpath("(//label[text()='Contact Name']/following::input[@role='combobox'])[1]"));
        if (contactName.isDisplayed()) {
            contactName.click();
            driver.findElement(By.xpath("(//li[@role='presentation'])[2]")).click();
        } else {
            //JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", contactName);
            contactName.click();
            driver.findElement(By.xpath("(//li[@role='presentation'])[2]")).click();
        }
        // Select status as None
        driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div[1]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'None')])[1]")).click();
        //Enter Subject as 'Testing' and description as 'Automation testing'
        WebElement subject = driver.findElement(By.xpath("//label[contains(text(),'Subject')]/following-sibling::div[1]"));
        //Scroll to subject
        js.executeScript("arguments[0].scrollIntoView();", subject);
        subject.click();
        subject.sendKeys("Testing");
        WebElement description = driver.findElement(By.xpath("//label[contains(text(),'Description')]/following-sibling::div[1]"));
        description.click();
        description.sendKeys("Automation Testing");
        Thread.sleep(5000);
        //Click Save
        WebElement saveButton = driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", saveButton);
        //Get the text from error message and display the message
        String ActualErrorMessage = driver.findElement(By.xpath("//h2[contains(text(),'We hit a snag.')]")).getText();
        String ExpectedErrorMessage = "We hit a snag.";
        Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage);
        String ActualSnagStatus = driver.findElement(By.xpath("//a[contains(text(),'Status')]")).getText();
        String ExpectedSnagStatus = "Status";
        Assert.assertEquals(ActualSnagStatus, ExpectedSnagStatus);
        String ActualSnagCaseOrigin = driver.findElement(By.xpath("//a[contains(text(),'Case Origin')]")).getText();
        String ExpectedSnagCaseOrigin = "Case Origin";
        Assert.assertEquals(ActualSnagCaseOrigin, ExpectedSnagCaseOrigin);
    }
}
