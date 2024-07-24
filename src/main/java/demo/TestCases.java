package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


public class TestCases {
    
    ChromeDriver driver;
    
  
    WebDriverWait wait;

    public TestCases()
    {
        System.out.println("Constructor: TestCases");
       
       
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        //For each webElement search, wait implicitly for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            
        
    
    }

    

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        
        driver.close();
        
        driver.quit();

    }

    
    public void TestCase_01() throws InterruptedException{

        System.out.println("Start Test case: TC_01");
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
        WPgeturl(driver, url);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_01_");
    }

    
    
    public void TestCase_02()throws InterruptedException{
        
        System.out.println("Start Test case: TC_02");
        WebElement weName = driver.findElement(By.xpath("//div//span[text()='Name']/ancestor::div[@class='geS5n']//input"));
        String userName = "Crio Learner";
        wrapperMethod_SendKeys(driver, weName, userName);
        System.out.println("End Test case: TC_02");



    }

   
    public void TestCase_03() throws InterruptedException{
        try{

        System.out.println("Start Test case: TC_03");
       
        long epoch = System.currentTimeMillis()/1000;
        
        String Answer = "I want to be the best QA Engineer! "+epoch;
        
        WebElement Question = driver.findElement(By.xpath("//span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea"));
        
        wrapperMethod_SendKeys(driver, Question, Answer);
        System.out.println("End Test case: TC_03");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

   
    public void TestCase_04() throws InterruptedException{

        System.out.println("Start Test case: TC_04");
        List<WebElement> opts = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        String exp = "0 - 2";
        WPExp(driver, opts, exp);

        System.out.println("End Test case: TC_04");

    }

    public void TestCase_05() throws InterruptedException{

        System.out.println("Start Test case: TC_05");
        List<WebElement> opts = driver.findElements(By.xpath("//div[@class='eBFwI']"));
        String[] skills= {"Java","Selenium","TestNG"};

       
        JavascriptExecutor js = (JavascriptExecutor)driver;

        
        js.executeScript("arguments[0].scrollIntoView(true);",opts.get(0));
        Thread.sleep(2000);
        WPSelectSkills(driver, opts,skills);

        System.out.println("End Test case: TC_05");
        Thread.sleep(3000);

    }

    public void TestCase_06() {
        System.out.println("Start Test case: TC_06");
        List<WebElement> titles= driver.findElements(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']"));
        String act = "Mrs";
        try {
            WPSelectTitle(driver, titles, act);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("End Test case: TC_06");

    }

    public void TestCase_07() throws InterruptedException{

        System.out.println("Start Test case: TC_07");
        Thread.sleep(10000);
        WPCurrentDateminus7(driver);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_07");


    }

    
    public void TestCase_08() throws InterruptedException{

        System.out.println("Start Test case: TC_08");

        WPCurrentTime24hrsformat(driver);

        System.out.println("End Test case: TC_08");

    }

    public void TestCase_09() throws InterruptedException{

        System.out.println("Start Test case: TC_09");

        String url = "https://www.amazon.in/";
        WPgeturl(driver, url);
        Thread.sleep(2000);
        WPCancelClick(driver);
        System.out.println("End Test case: TC");
    

    }
    public void TestCase_10() throws InterruptedException{

        System.out.println("Start Test case: TC_10");

        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
        WPSubmitClick(driver, submit);

        System.out.println("End Test case: TC_10");
        
    }
    public void TestCase_11() throws InterruptedException{

        System.out.println("Start Test case: TC_11");
        Thread.sleep(5000);
        WebElement actualmessage= driver.findElement(By.xpath("//div[@class='vHW8K']"));
    
        String expected = "Thanks for your response, Automation Wizard!";

        
        WPCompareText(driver, actualmessage,expected);  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));  

        System.out.println("End Test case: TC_11");

    }

    public void WPgeturl(ChromeDriver driver, String url){
        
        if(!driver.getCurrentUrl().equals(url))
            driver.get(url);
    }


    
    public void wrapperMethod_SendKeys(ChromeDriver driver, WebElement webelement, String inputString) throws InterruptedException{
        
        webelement.sendKeys(inputString);
            Thread.sleep(5000);

    }

    
    public void WPExp(ChromeDriver driver, List<WebElement> opt, String input) throws InterruptedException{
        
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
      
        for(WebElement exp : opt){
            
            if(exp.getText().equals(input)){
                
                WebElement year = driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//div[@class='Od2TWd hYsg7c' and @data-value='"+input+"']"));
                js.executeScript("arguments[0].scrollIntoView(true);",year);
               
                year.click();
               
                Thread.sleep(3000);
                

            }

        }

    }

   
    public void WPSelectSkills(ChromeDriver driver, List<WebElement> Skills, String[] input) throws InterruptedException{
    
        for(WebElement eachskills : Skills){
            for(String inpskill : input){
           
                if(eachskills.getText().equals(inpskill)){
                    
                    WebElement skillselect = driver.findElement(By.xpath("//div[@class='uVccjd aiSeRd FXLARc wGQFbe BJHAP oLlshd' and @aria-label='"+inpskill+"']"));
                   
                    skillselect.click();
                 
                    Thread.sleep(3000);
                    
                }
            }

        }

    }

    

    public void WPSelectTitle(ChromeDriver driver, List<WebElement> Actual, String expected) throws InterruptedException{
 
        WebElement Choose = driver.findElement(By.xpath("(//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R'])[1]"));
        Choose.click();
        
       
        for(WebElement title :Actual){
            
         
            if(title.getAttribute("data-value").equals(expected)){
               
                Thread.sleep(3000);
                WebElement Click = driver.findElement(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option' and @data-value='"+expected+"']"));
             
                Click.click();
                break;
                
            }
            

        }

    }

    
    public void WPCurrentDateminus7(ChromeDriver driver){

      
        LocalDate date = LocalDate.now();

       
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        
        LocalDate newdate = date.minusDays(7);

      
        WebElement Calendar = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));

       
        Calendar.sendKeys(newdate.format(dateFormatter).toString());

    }


   
    public void WPCurrentTime24hrsformat(ChromeDriver driver) throws InterruptedException{

       
        LocalTime currentTime = LocalTime.now();

       
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        String[] HrsMinsStr = currentTime.format(timeFormatter).split(":");
       
        WebElement AnsIn24hrFormat = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
        
       
        AnsIn24hrFormat.sendKeys(HrsMinsStr[0]);

        
        WebElement AnsMinIn24hrFormat = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
        
        AnsMinIn24hrFormat.sendKeys(HrsMinsStr[1]);

        

    }

    public void WPCancelClick(ChromeDriver driver) throws InterruptedException{

      
       Thread.sleep(3000);

       
        Alert alert = driver.switchTo().alert();
        
       
        alert.dismiss();


    }


    public void WPSubmitClick(ChromeDriver driver, WebElement weSubmitButton){

        weSubmitButton.click();

    }

    
    public void WPCompareText(ChromeDriver driver, WebElement Actual, String expectedMessage){

         
         if(Actual.getText().equals("Thanks for your response, Automation Wizard!")){
            
            System.out.println(Actual.getText());
        }  


    }


}










