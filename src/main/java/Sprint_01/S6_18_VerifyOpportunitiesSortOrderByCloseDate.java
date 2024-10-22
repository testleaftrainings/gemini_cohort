package Sprint_01;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S6_18_VerifyOpportunitiesSortOrderByCloseDate extends TestBase{
    @Test
    public void S6_18_VerifyOpportunitiesSortOrderByCloseDate() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        //Click view All and click Sales from App Launcher
        /*ToggleButton.click();
        ViewAll.click();*/
        driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
        driver.executeScript("arguments[0].click()", sales);
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        //Click on Opportunity tab
        WebElement opportunities = driver.findElement(By.xpath("(//span[contains(text(),'Opportunities')])[1]"));
        driver.executeScript("arguments[0].click()", opportunities);
        Thread.sleep(2000);
        //Select the Table view
        driver.findElement(By.xpath("//button[@title='Select list display']")).click();
        driver.findElement(By.xpath("//li[@title='Display as table']")).click();
        Thread.sleep(3000);
        System.out.println("Table view displayed");
        //Escape
        driver.findElement(By.xpath("//button[@title='Select list display']")).sendKeys(Keys.ESCAPE);
        //Click to Sort table based on close date
        //Sort the Opportunities by Close Date in ascending order
        Thread.sleep(3000);
        WebElement CloseDateColumn = driver.findElement(By.xpath("//span[@title='Close Date']"));
        js.executeScript("arguments[0].click()", CloseDateColumn);
        //Sorting using List
        List<WebElement> closeDateValues = driver.findElements(By.xpath("//span[@class='uiOutputDate']"));
        ArrayList<String> beforesort = new ArrayList<>();
        ArrayList<String> sort = new ArrayList<>();
        System.out.println("Displayed Close Date valus");
        for (int i = 0; i < closeDateValues.size(); i++) {
            beforesort.add(closeDateValues.get(i).getText());
            System.out.println(beforesort.get(i));
        }
        System.out.println("Sorting in application");
        for (int i = 0; i < closeDateValues.size(); i++) {
            Collections.sort(beforesort);
            //Collections.reverse(sort);
            sort.add(beforesort.get(i));
            System.out.println(sort);
        }
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()", CloseDateColumn);
        Thread.sleep(3000);
        List<WebElement> closeDateValuesAfterSortAssending = driver.findElements(By.xpath("//span[@data-aura-class='uiOutputDate']"));
        ArrayList<String> aftersort = new ArrayList<>();
        System.out.println("After sorting");
        for (int i = 0; i < closeDateValuesAfterSortAssending.size(); i++) {
            aftersort.add(closeDateValuesAfterSortAssending.get(i).getText());
            System.out.println(aftersort.get(i));
        }
        Assert.assertNotEquals(beforesort, aftersort);
    }
}
