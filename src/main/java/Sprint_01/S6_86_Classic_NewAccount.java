package Sprint_01;

/*
* Test Steps:
1. Navigate to Salesforce login page
2. Enter username as 'learners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
3. Choose 'Account' from the dropdown
4. Click on the 'Go!' button.
5. Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
6. Enter the Billing Address
7. Click Copy Billing Address to Shipping Address link
8. Verify the Shipping Address reflects the Billing Address
9. Enter the SLA Expiration Date as Current Date + 20 days
10. Click on Save button.
11. Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
12. Navigate to Accounts tab and Verify the newly Created account is displayed
13. Close the browser Expected Result:
Verify the newly Created account is displayed
*
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class S6_86_Classic_NewAccount  extends TestBase{

    @Test
    public void createClassicNewAccount() throws InterruptedException{

        //click on File
        driver.findElement(By.id("AllTab_Tab")).click();

        //click on the dropdown
        driver.findElement(By.name("createNewSelect")).click();

        //Select 'Account'
        WebElement ele = driver.findElement(By.name("createNewSelect"));
        Select select = new Select(ele);
        select.selectByVisibleText("Account");

        //click on 'Go' button
        driver.findElement(By.id("createNewGo")).click();

        //Enter Account Name
        driver.findElement(By.id("acc2")).sendKeys("BootCamp Puppeteer_Stalin");

        //Enter Billing Street
        driver.findElement(By.id("acc17street")).sendKeys("12, Elango Salai");

        //Enter Billing Street Post Code
        driver.findElement(By.id("acc17zip")).sendKeys("600 018");

        //Click on Copy Billing Address
        driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();

        /*//Enter the SLA Expiration Date as Current Date + 20 days//Get the current Date
        String currDate = driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::span[@class='dateFormat']/a")).getText();
//        currDate = "26/10/2024";
        String date = currDate.substring(0,2);
        String month = currDate.substring(3,5);
        String sDate = date;
        String sMontha = month;
        int intMonth = Integer.parseInt(month);
        intMonth++;
        month = String.valueOf(intMonth);
        int intDate = Integer.parseInt(date);
        intDate = intDate+20;
        intDate = intDate-30;
        date = String.valueOf(intDate);
        currDate = currDate.replace(sDate, date);
        currDate = currDate.replace(sMontha, month);
        System.out.println(currDate);

        //Enter date+20 days
        driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::span[@class='dateInput dateOnlyInput']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::span[@class='dateInput dateOnlyInput']")).sendKeys(currDate);*/

        //Click 'Save' button
        driver.findElement(By.xpath("//input[@name='save'][@type='submit']")).click();

        Thread.sleep(3000);

        //Verify if it is available in Recent
        Assert.assertTrue(driver.findElement(By.xpath("//*[@title='Account: BootCamp Puppeteer_Stalin']")).isDisplayed());


        //Navigate to Accounts tab and Verify the newly Created account is displayed
        //Click on Accounts Tab
        driver.findElement(By.xpath("//*[@title='Accounts Tab - Selected']")).click();

        List<WebElement> table = driver.findElements(By.xpath("//*[@class='list']/tbody/tr[*]"));
        System.out.println(table.size());

        for(int i=1;i<10;i++){
            if(driver.findElement(By.xpath("//*[@class='list']/tbody/tr["+i+"]")).getText().contains("BootCamp Puppeteer_Stalin")){
                System.out.println("Confirmation on New Account");

            }
        }
    }
}
