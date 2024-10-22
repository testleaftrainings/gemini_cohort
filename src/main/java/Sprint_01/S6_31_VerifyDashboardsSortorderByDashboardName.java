package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S6_31_VerifyDashboardsSortorderByDashboardName extends TestBase{
    @Test
    public void S6_31_VerifyDashboardsSortorderByDashboardName() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        //Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement Dashboard = driver.findElement(By.xpath("//p[contains(text(),'Dashboards')]"));
        //Scroll to Dashboard
        js.executeScript("arguments[0].scrollIntoView();", Dashboard);
        js.executeScript("arguments[0].click()", Dashboard);
        //4. Click on the Dashboards tab
        Thread.sleep(3000);
        WebElement DashboardsTab = driver.findElement(By.xpath("//a[@title='Dashboards']/span[contains(text(),'Dashboards')]"));
        js.executeScript("arguments[0].click()",DashboardsTab);
        //Scroll to reload the table
        String noOfItemsInTotal= driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span[contains(text(),'items')]")).getText();
        String[] s = noOfItemsInTotal.split(" ");
        int actualCount = driver.findElements(By.xpath("//table/tbody/tr[@role='row']")).size();
        //String actualCountStr =""+actualCount;
        String actualCountStr= String.valueOf(actualCount);
        Actions action = new Actions(driver);
        while (!(actualCountStr.equals(s[0]))){
            List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr[@role='row']"));
            action.moveToElement(elements.get(elements.size()-1)).perform();
            noOfItemsInTotal = driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span[contains(text(),'items')]")).getText();
            s = noOfItemsInTotal.split(" ");
            actualCount = driver.findElements(By.xpath("//table/tbody/tr[@role='row']")).size();
            //actualCountStr = ""+actualCount;
            actualCountStr=String.valueOf(actualCount);
        }
        //List of dashboardnames befor sorting
        List<WebElement> DashboardNames = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
        ArrayList<String> beforeSortDnames = new ArrayList<>();
        ArrayList<String>ExpectedSortDnames = new ArrayList<>();
        System.out.println("Displayed DashboardNames");
        for(int i=0;i<DashboardNames.size();i++){
            beforeSortDnames.add(DashboardNames.get(i).getText());
            System.out.println(beforeSortDnames.get(i));
        }
        System.out.println("DashboardNames sort expected");
        for (int i = 0; i<DashboardNames.size(); i++){
            //Sorting assending using collections
            Collections.sort(beforeSortDnames);
            ExpectedSortDnames.add(beforeSortDnames.get(i));
            System.out.println(ExpectedSortDnames);
        }
        //5. Click the sort arrow in the Dashboard Name.
        driver.findElement(By.xpath("(//span[contains(text(),'Dashboard Name')])[1]")).click();
        Thread.sleep(3000);
        //Scroll to reload the table
        String noOfItemsInTotalAfterSort= driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span[contains(text(),'items')]")).getText();
        String[] afterSo = noOfItemsInTotal.split(" ");
        int actualCountAfterSort = driver.findElements(By.xpath("//table/tbody/tr[@role='row']")).size();
        //String actualCountStr =""+actualCount;
        String actualCountStrAfterSort= String.valueOf(actualCountAfterSort);
        Actions actionSecondSortScroll = new Actions(driver);
        while (!(actualCountStrAfterSort.equals(afterSo[0]))){
            List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr[@role='row']"));
            actionSecondSortScroll.moveToElement(elements.get(elements.size()-1)).perform();
            noOfItemsInTotalAfterSort = driver.findElement(By.xpath("//div[@class='test-listViewStatusInfo']/span[contains(text(),'items')]")).getText();
            afterSo = noOfItemsInTotalAfterSort.split(" ");
            actualCountAfterSort = driver.findElements(By.xpath("//table/tbody/tr[@role='row']")).size();
            //actualCountStr = ""+actualCount;
            actualCountStrAfterSort=String.valueOf(actualCountAfterSort);
        }
        //Sorting the DashboardNAmes
        List<WebElement> DashboardNamesAfterSort = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']"));
        ArrayList<String>ActualSortedDnames = new ArrayList<>();
        System.out.println("The Sorted Dashboard Names");
        for (int i=0; i<DashboardNamesAfterSort.size();i++){
            ActualSortedDnames.add(DashboardNamesAfterSort.get(i).getText());
            System.out.println(ActualSortedDnames.get(i));
        }
        //Assertion
        Assert.assertNotEquals(ActualSortedDnames,beforeSortDnames);
    }
}
