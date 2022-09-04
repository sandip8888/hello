package home.sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppTest {
    
    WebDriver driver;
    WebElement element;
    @Test
    public void getTitle() {       
        String title = driver.getTitle();
        System.out.println("Implicitly waiting for 420 seconds");
        //driver.manage().timeouts().implicitlyWait(420, TimeUnit.SECONDS);
        System.out.println(title);
    }

    @Test
    public void logIn() throws IOException { 
        ReadExcel read = new ReadExcel();
        String starting = System.getProperty("user.dir");
        //File fileToBeRead = new File(starting,"my_file.txt");
        String[] credential = read.readExcel(starting, "Cred.xls", "Credantial");
        System.out.println("Login window opened");
        System.out.println("ID: "+credential[0] +" Pwd: "+ credential[1]);
        driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(credential[0]); 
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(credential[1]);
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        System.out.println("Login Successful");
    }

    @BeforeMethod
    public void beforeMethod() {
      System.out.println("in beforeMethod");
   }

   @AfterMethod
   public void afterMethod() {
      System.out.println("in afterMethod");
   }

   @BeforeClass
   public void beforeClass() {
      System.out.println("in beforeClass");
   }

   @AfterClass
   public void afterClass() {
      System.out.println("in afterClass");
   }

   @BeforeTest
   public void beforeTest() {
      System.out.println("in beforeTest");
   }

   @AfterTest
   public void afterTest() {
      System.out.println("in afterTest");
   }
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting Test On Chrome Browser (in beforeSuite)");
        System.setProperty("webdriver.chrome.driver", "/home/sandy/chromedriver");
        String baseUrl = "https://www.flipkart.com/";          
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    
    @AfterSuite
    public void afterSuite() {
        driver.quit();
        System.out.println("Finished Test On Chrome Browser (in afterSuite)");
    }
}
