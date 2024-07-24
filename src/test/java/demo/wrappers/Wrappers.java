package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    WebDriverWait wait;
    public void WPgeturl(ChromeDriver driver, String url){
        
        if(!driver.getCurrentUrl().equals(url))
            driver.get(url);
    }


    
    public void WP_Sendkeys(ChromeDriver driver, WebElement webelement, String inputString) throws InterruptedException{
        
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
             //   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement Click = driver.findElement(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option' and @data-value='"+expected+"']"));;
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

      
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

       
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
