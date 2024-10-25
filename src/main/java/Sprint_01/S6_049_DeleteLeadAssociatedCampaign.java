package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_049_DeleteLeadAssociatedCampaign extends TestBase{

    @Test
    public void verifyDeleteLeadAssociatedCampaign() throws InterruptedException{

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        try{
            //click on 'View All'
            driver.findElement(By.xpath("//*[text()='View All']")).click();
        }catch (NoSuchElementException e){
            driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text()='View All']")).click();
        }

        //Click on Work Type Groups from App Launcher
        WebElement eleCampaigns = driver.findElement(By.xpath("//p[contains(text(),'Leads')]"));
        driver.executeScript("arguments[0].click();", eleCampaigns);

        try{
            driver.findElement(By.xpath("//*[@name='Lead-search-input']")).click();

        }catch(NoSuchElementException e){
            driver.navigate().refresh();
        }

        //Click on Search Input Field

        driver.findElement(By.xpath("//*[@name='Lead-search-input']")).sendKeys("Stalin");
        driver.findElement(By.xpath("//*[@name='Lead-search-input']")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        //Click dropdown of the record
//        driver.findElement(By.xpath("//*[@title='Show 4 more actions']")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).click();

        //Click on Delete
        driver.findElement(By.xpath("//a[@title='Delete']")).click();

        //Confirm Delete
        driver.findElement(By.xpath("//span[text()='Delete']")).click();

        System.out.println("Check this out!");
        Thread.sleep(2000);

        //Verify Delete confirmation Message
        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
        System.out.println("This is the "+text);
        //Opportunity "Oppo Stalin" was deleted.
        String exp = "Lead \"Stalin Durai\" was deleted";
        Assert.assertTrue(text.contains(exp));
    }
}
