package demo;
import java.net.MalformedURLException;



public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        
        
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        TestCases tests = new TestCases(); 
        
        tests.TestCase_01();
        tests.TestCase_02();
        tests.TestCase_03();
        tests.TestCase_04();
        tests.TestCase_05();
        tests.TestCase_06();
        tests.TestCase_07();
        tests.TestCase_08();
        tests.TestCase_09();
        tests.TestCase_10();
        tests.TestCase_11();
        


        tests.endTest(); 
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
