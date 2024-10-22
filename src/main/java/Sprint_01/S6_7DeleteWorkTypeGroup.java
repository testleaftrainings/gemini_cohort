package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_7DeleteWorkTypeGroup extends TestBase {
    @Test
    public void s6_7DeleteWorkTypeGroup() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        //Click view All and click Work Type Groups from App Launcher
        // driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        // driver.findElement(By.xpath("//button[text()='View All']")).click();
       /* ToggleButton.click();
        ViewAll.click();*/
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        Thread.sleep(3000);
        WebElement WorkTypeGroups = driver.findElement(By.xpath("//p[contains(text(),'Work Type Groups')]"));
        js.executeScript("arguments[0].scrollIntoView();", WorkTypeGroups);
        //Thread.sleep(5000);
        WorkTypeGroups.click();
        Thread.sleep(3000);
        //Search the Work Type Group 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//div[@title='New']")).click();
        //driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following-sibling::div[1]")).click();
        driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following-sibling::div[1]")).sendKeys("Salseforce Automation by Vignesh");
        driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
        Thread.sleep(5000);
        WebElement RecentlyAddedWorkType = driver.findElement(By.xpath("//span[contains(text(),'Salseforce Automation by Vignesh | Work Type Group')]"));
        js.executeScript("arguments[0].click()", RecentlyAddedWorkType);
        Thread.sleep(5000);
        WebElement SalseforceAutomationByVignesh = driver.findElement(By.xpath("//a[contains(text(),'Salseforce Automation by Vignesh')]"));
        //driver.manage().window().setSize(new Dimension(450,630));
        Thread.sleep(5000);
        if (SalseforceAutomationByVignesh.isDisplayed()) {
            // Click on the Dropdown icon and Select Delete
            /*WorkTypeGroupSearchbox.click();
            WorkTypeGroupSearchbox.sendKeys("Salseforce Automation by Vignesh");
            WorkTypeGroupSearchbox.sendKeys(Keys.ENTER);*/
            driver.findElement(By.xpath("//div[@type='search']/input")).click();
            driver.findElement(By.xpath("//div[@type='search']/input")).sendKeys("Salseforce Automation by Vignesh");
            driver.findElement(By.xpath("//div[@type='search']/input")).sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@type='search']/input")).sendKeys(Keys.ENTER);
            //js2.executeScript("window.scrollBy(70,0)");
            Thread.sleep(5000);
            WebElement DropSelectDelete = driver.findElement(By.xpath("(//a[contains(text(),'Salseforce Automation by Vignesh')]/following::a)[1]"));
            // js2.executeScript("arguments[0].scrollIntoView();",DropSelectDelete);
            DropSelectDelete.click();
            Thread.sleep(5000);
            //DropSelectDelete.sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//a[@title='Delete']")).click();
            //7.Click on the Delete option in the displayed popup window.
            driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
            Thread.sleep(5000);
            //Verify Whether Work Type group is Deleted using Work Type Group Name
            String ActualVerificationMessage = driver.findElement(By.xpath("//span[contains(normalize-space(),'Work Type Group \"Salseforce Automation by Vignesh\" was deleted.')]")).getText();
            String ExpectedVerificationMessage = "Work Type Group \"Salseforce Automation by Vignesh\" was deleted. Undo";
            Assert.assertEquals(ActualVerificationMessage, ExpectedVerificationMessage);
        }
    }
}
