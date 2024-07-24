package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    
    WebDriverWait wait;
    Wrappers wrappers = new Wrappers();
    
    @Test
    public void testCase01() throws InterruptedException{
        
        System.out.println("Start Test case: TC_01");
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
        
        wrappers.WPgeturl(driver, url);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_01");
    }

    
   
    @Test
    public void testCase02()throws InterruptedException{
        
        System.out.println("Start Test case: TC_02");
        WebElement weName = driver.findElement(By.xpath("//div//span[text()='Name']/ancestor::div[@class='geS5n']//input"));
        String userName = "Crio Learner";
        wrappers.WP_Sendkeys(driver, weName, userName);
        System.out.println("End Test case: TC_02");



    }

    @Test
    public void testCase03() throws InterruptedException{
        try{

        System.out.println("Start Test case: TC_03");
        long epochTime = System.currentTimeMillis()/1000;
        String A = "I want to be the best QA Engineer! "+epochTime;
        WebElement Q= driver.findElement(By.xpath("//span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea"));
        wrappers.WP_Sendkeys(driver, Q, A);
        System.out.println("End Test case: TC_03");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

 
    @Test
    public void testCase04() throws InterruptedException{

        System.out.println("Start Test case: TC_04");
        List<WebElement> opt = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        String exp = "0 - 2";
        wrappers.WPExp(driver, opt ,exp);

        System.out.println("End Test case: TC_04");

    }

    
    @Test
    public void testCase05() throws InterruptedException{

        System.out.println("Start Test case: TC_05");
        List<WebElement> opt = driver.findElements(By.xpath("//div[@class='eBFwI']"));
        String[] skills = {"Java","Selenium","TestNG"};

        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //scroll into the view to find the desired web element.
        js.executeScript("arguments[0].scrollIntoView(true);",opt.get(0));

        wrappers.WPSelectSkills(driver,opt, skills);

        System.out.println("End Test case: TC_05");

    }

    @Test
    public void testCase06() throws InterruptedException{

        System.out.println("Start Test case: TC_06");
        List<WebElement> Titles= driver.findElements(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']"));
        String Title = "Mr";
        wrappers.WPSelectTitle(driver, Titles, Title);
     
        System.out.println("End Test case: TC_06");

    }

  
    @Test
    public void testCase07() throws InterruptedException{

        System.out.println("Start Test case: TC_07");
        Thread.sleep(10000);
        wrappers.WPCurrentDateminus7(driver);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_07");


    }

    @Test
    public void testCase08() throws InterruptedException{

        System.out.println("Start Test case: TC_08");

        wrappers.WPCurrentTime24hrsformat(driver);

        System.out.println("End Test case: TC_08");

    }

    @Test
    public void testCase09() throws InterruptedException{

        System.out.println("Start Test case: TC_09");

        String url = "https://www.amazon.in/";
        wrappers.WPgeturl(driver, url);
        Thread.sleep(2000);
        wrappers.WPCancelClick(driver);
        System.out.println("End Test case: TC_09");
    

    }

    @Test
    public void testCase10() throws InterruptedException{

        System.out.println("Start Test case: TC_10");

        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
        wrappers.WPSubmitClick(driver, submit);

        System.out.println("End Test case: TC_10");
        Thread.sleep(2000);
        
        
    }
    @Test
    public void testCase11(){

        System.out.println("Start Test case: TC_11");
     WebElement Actual= driver.findElement(By.xpath("//div[@class='vHW8K']"));
  String expected = "Thanks for your response, Automation Wizard!";
        wrappers.WPCompareText(driver, Actual, expected);  
    
        System.out.println("End Test case:");

    }

    @BeforeTest
    public void startBrowser()
    {
        
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        //For each webElement search, wait implicitly for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
        

    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}