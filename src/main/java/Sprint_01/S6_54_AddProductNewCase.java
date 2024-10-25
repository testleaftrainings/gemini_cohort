package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S6_54_AddProductNewCase extends TestBase{
    @Test
    public void S6_54_AddProductNewCase() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        //Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        //4. Click on Content tab
        driver.findElement(By.xpath("(//p[contains(text(),'Content')])[1]")).click();
        //5. Click View All Key Deals in Key Deals
        driver.findElement(By.xpath("//span[@class='viewAllLabel' and text()= 'View All Key Deals']")).click();
        Thread.sleep(5000);
        //6. Click the dropdown from Opportunities and select All Opportunities
        driver.findElement(By.xpath("//button[@title='Select a List View: Opportunities']")).click();
        driver.findElement(By.xpath("(//span[@class=\" virtualAutocompleteOptionText\" and text()= 'All Opportunities' ])[1]")).click();
        //7. Give SRM Steels in Search Box and search
        Thread.sleep(3000);
        WebElement OppSearchBox= driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
        OppSearchBox.sendKeys("SRM Steels");
        //Thread.sleep(2000);
        OppSearchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        OppSearchBox.sendKeys(Keys.ESCAPE);
        Thread.sleep(3000);
        //8. Click on the SRM Steels under Opportunity Name
        driver.findElement(By.xpath("//a[@title='SRM Steels' and text()='SRM Steels']")).click();
        Thread.sleep(3000);
        //9. Click on New Case, Click inside the Contact Name and select the first contact
        driver.findElement(By.xpath("//button[@name='Global.NewCase']")).click();
        //driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
        //10. Select Status as New and give Subject as New case to SRM Steels
        driver.findElement(By.xpath("(//span[text()='Status']/following::a)[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='--None--']/following::a[text()='New']")).click();
        driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input")).sendKeys("New Case");
        //Click Save
        driver.findElement(By.xpath("//footer/button[2]/span[text()='Save']")).click();
        //Verify
        String SucessMEssage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        //String ActualSMessage = SucessMEssage.substring()
        Thread.sleep(5000);
    }
}
