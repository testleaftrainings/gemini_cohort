package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class S6_53_AddProductWithOpportunity extends TestBase{
    @Test
    public void S6_53_AddProductWithOpportunity() throws InterruptedException {
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
        //Git test
        //9. Click on  dropdown of Products under Related and select Add Products
        driver.findElement(By.xpath("(//span[@title='Products']/following::a[@role='button'])[1]")).click();



    }
}
