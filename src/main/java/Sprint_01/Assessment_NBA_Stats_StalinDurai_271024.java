package Sprint_01;

/*
* Assessment
----------
Test steps:
1. Navigate to https://www.nba.com/stats
2. Click on 'See All Player Stats'
3. Choose 'Season' as '2023-24'
4. Choose 'Season Type' as 'NBA Cup'
5. Choose 'Per Mode' as 'Per Game'
6. Choose 'Season Segment' as 'Last Game'
7. Click on the player name with lowest age
8. Click on the Profile
9. Get the Experience of the player
10. Verify the player experience as 1.
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assessment_NBA_Stats_StalinDurai_271024 extends TestBase{

    @Test
    public void verifyYoungestPlayer() throws InterruptedException{

        //Accept cookies
        try{
            driver.findElement(By.xpath("//*[text()='I Accept']")).click();
        }catch (Exception e){
            System.out.println("No cookies notification");
        }

        //Click on 'See All Player Stats'
        driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();

        //Choose 'Season' as '2023-24'
        WebElement eleSeason = driver.findElement(By.xpath("//p[text()='Season']/following::div[1]/select"));
        Select select = new Select(eleSeason);
        select.selectByVisibleText("2023-24");


        //Choose 'Season Type' as 'NBA Cup'
        WebElement eleSeasonType = driver.findElement(By.xpath("//p[text()='Season Type']/following::div[1]/select"));
        select = new Select(eleSeasonType);
        select.selectByVisibleText("NBA Cup");

        //Choose 'Per Mode' as 'Per Game'
        WebElement elePerMode = driver.findElement(By.xpath("//p[text()='Per Mode']/following::div[1]/select"));
        select = new Select(elePerMode);
        select.selectByVisibleText("Per Game");

        //Choose 'Season Segment' as 'Last Game'
        WebElement eleLastGame = driver.findElement(By.xpath("//p[text()='Season Segment']/following::div[1]/select"));
        select = new Select(eleLastGame);
        select.selectByVisibleText("Last Game");

        Thread.sleep(2000);

        //Click on the player name with lowest age
        List<WebElement> table = driver.findElements(By.xpath("//*[@class='Crom_body__UYOcU']/tr[*]/td[4]"));
        Map<Integer, Integer> least = new HashMap<Integer, Integer>();
        Thread.sleep(3000);
        int row =0;
        for(int i=0;i< table.size();i++){

            try{
                if(least.get(0) > Integer.parseInt(table.get(i).getText())){
                    int val = Integer.parseInt(table.get(i).getText());
                    least.put(0,least.getOrDefault(table.get(i).getText(), val));
                    row = i;
                }
            }catch(NullPointerException e){
                Thread.sleep(2000);
                int val = Integer.parseInt(table.get(i).getText());
                least.put(0,least.getOrDefault(table.get(i).getText(), val));

            }
        }
        row++;

        String age = least.get(0).toString();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='Crom_body__UYOcU']/tr["+row+"]/td[2]")).click();

        /*for(int i=1;i< table.size();i++){
           if(driver.findElement(By.xpath("//*[@class='Crom_body__UYOcU']/tr["+i+"]/td[4]")).getText().contains(age)){
               try{
                   driver.findElement(By.xpath("//*[@class='Crom_body__UYOcU']/tr["+i+"]/td[2]")).click();
                   break;
               }catch (StaleElementReferenceException e){
                   JavascriptExecutor js1 = (JavascriptExecutor) driver;
                   js1.executeScript("window.scrollBy(0,250)", "");

                   driver.findElement(By.xpath("//*[@class='Crom_body__UYOcU']/tr["+i+"]/td[2]")).click();
               }

           }
       }*/

       //Get the Experience of the player
        driver.findElement(By.xpath("//p[text()='EXPERIENCE']")).click();

       //Verify the player experience as 1.
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='EXPERIENCE']/following::p[1]")).getText().contains("1 Year"));
    }
}
