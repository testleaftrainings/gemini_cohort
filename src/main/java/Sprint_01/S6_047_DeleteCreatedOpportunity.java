package Sprint_01;

import jdk.vm.ci.meta.Local;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S6_047_DeleteCreatedOpportunity extends LocalTestBase{

    @Test
    public void verifyDeleteCreated() throws InterruptedException{

        //Click on toggle menu button from the left corner
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

        //click on 'View All'
        driver.findElement(By.xpath("//*[text()='View All']")).click();

        //Click on Work Type Groups from App Launcher
        WebElement eleCampaigns = driver.findElement(By.xpath("//p[contains(text(),'Campaigns')]"));
        driver.executeScript("arguments[0].click();", eleCampaigns);

        //Click mon 'Bootcamp'
        driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();

        //Click on the dropdown icon in the Opportunities
        driver.findElement(By.xpath("//*[text()='Oppo Stalin']/following::div[1]")).click();

        //Click on Delete
        driver.findElement(By.xpath("//a[@title='Delete']")).click();

        //Confirm Delete
        driver.findElement(By.xpath("//span[text()='Delete']")).click();

        //Verify Delete confirmation Message
        String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();

        //Click on Opportunities tab
        driver.findElement(By.xpath("//span[@title='Opportunities'][text()='Opportunities']")).click();

        Thread.sleep(3000);

        //Click on Search Input Field
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).click();

        //Enter the search text
        driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Oppo Stalin");

        //Verify No items displayed
        boolean noItesms = driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
        Assert.assertTrue(noItesms);




    }
}