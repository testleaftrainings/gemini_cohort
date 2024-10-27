package Sprint_01;

/*
* Test step:
1. Navigate to Salesforce login page
2. Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
3. Click on the 'File'
4. Click on 'Select a file from Salesforce'
5. Click on 'Owned by Me'
6. Search for 'Maven'
7. Click on the 'Attach' for Maven file
8. Click on the 'Share' Button
9. Click on the 'More Actions'
10. Click on the 'File Sharing Settings'
11. Change permissions as 'Collaborators'
12. Enable the checkBox for 'Prevent others from sharing and unsharing'
13. Verify the checkbox is Enabled
14. Click on the 'Close' button.
15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
16. Verify the Topics as 'Maven Installtion Guide'
17. Click on the widget dropdown for post and click 'Delete'
18. Click on the 'Ok' Button.
19. Verify the post is Deleted.
* */

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class S6_87_DeleteNewlyCreated  extends LocalTestBase{

    @Test
    public void deleteClassicNewAccount() throws InterruptedException{

        WebElement home = driver.findElement(By.xpath("//*[@title='Home Tab - Selected']"));
        home.click();

        //Click on the 'File'
        WebElement ele = driver.findElement(By.xpath("//*[@class='publisherattachtext '][text()='File']"));
        ele.click();

        //Click on 'Select a file from Salesforce'
        driver.findElement(By.xpath("//*[@title='Select a file from Salesforce']")).click();

        //Switch to New Window
        String defWin = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        List<String> listWin = new ArrayList<>(windows);

        driver.switchTo().window(listWin.get(listWin.size()-1));

        //Click on 'Owned by Me'
        driver.findElement(By.xpath("//*[text()='Owned by Me']")).click();

        //Search for 'Maven'
        //Click on 'Search'
        driver.findElement(By.xpath("//*[@title='Search Files I Own...']")).click();
        driver.findElement(By.xpath("//*[@title='Search Files I Own...']")).sendKeys("Maven");

        Thread.sleep(3000);

        //Click on the 'Attach' for Maven file
        driver.findElement(By.xpath("//span[text()='Attach']")).click();

        //Switch to Parent Window
        driver.switchTo().window(defWin);

        //Click on the 'Share' Button
        driver.findElement(By.name("publishersharebutton")).click();


        //Click on the 'More Actions'
        driver.findElement(By.xpath("//*[@title='Open More Actions list'][1]")).click();

        //Click on the 'File Sharing Settings'
        driver.findElement(By.xpath("//*[text()='File Sharing Settings']")).click();

        //Change permissions as 'Collaborators'
        //check if 'Collaborators' is selected
        if(!driver.findElement(By.xpath("//*[@id='sharedWithList']/tbody/tr[1]/td[3]")).getText().contains("Collaborators")){

            driver.findElement(By.xpath("//*[@id='sharedWithList']/tbody/tr[1]/td[3]")).click();
            driver.findElement(By.xpath("//span[normalize-space(text()) = 'Collaborators']")).click();

        }

        //Enable the checkBox for 'Prevent others from sharing and unsharing'
        if(!driver.findElement(By.xpath("//*[@id='sharingOption']")).isEnabled()){
            driver.findElement(By.xpath("//*[@id='sharingOption']")).click();
        }

        //click on 'Close' button
        driver.findElement(By.xpath("//input[@value='Close']")).click();

        //Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
        driver.findElement(By.xpath("//*[text()='Click to add topics:']")).click();

        driver.findElement(By.xpath("//*[@class='topicInput']")).click();
        driver.findElement(By.xpath("//*[@class='topicInput']")).sendKeys("Maven Installtion Guide Stalin");
        driver.findElement(By.xpath("//*[@value='Done']")).click();

        //Verify the Topics as 'Maven Installtion Guide'
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='editLink'][text()='Topics:']")).getText().contains("Maven Installtion Guide_Stalin"));

        //Click on the widget dropdown for post
        driver.findElement(By.xpath("//div[1]/following::a[@title='More Actions']")).click();

        // click 'Delete'
        driver.findElement(By.xpath("//*[text()='Delete']")).click();

        //Switch to new window
        //Switch to New Window
        defWin = driver.getWindowHandle();
        windows = driver.getWindowHandles();
        listWin = new ArrayList<>(windows);

        driver.switchTo().window(listWin.get(listWin.size()-1));

        //Click on the 'Ok' Button.
        driver.findElement(By.xpath("//*[@value='OK']")).click();

        //Switch to Parent Window
        driver.switchTo().window(defWin);

        //Verify the post is Deleted.
        Assert.assertTrue(!driver.findElement(By.xpath("")).isDisplayed());


    }
}
