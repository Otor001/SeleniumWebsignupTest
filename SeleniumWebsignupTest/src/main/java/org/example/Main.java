package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstProjectTest {

    //import the selenium webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //find where chromedriver is located
        System.setProperty("webDriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your chrome driver.
        //driver = new ChromeDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        //2. input the URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. verify that user input the right Url on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(10000);
        //3. maximize the  browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //4. click on signup button to open the sign up page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test3. verify that user is successfully signed up with valid details
        //5. input username on username field
        driver.findElement(By.id("user_username")).sendKeys( ...KeysToSend: "otor001");
        //6. input email for email field
        driver.findElement(By.id("user_email")).sendKeys( ...KeysToSend: "otor4real@gmail.com");
        //7. locate the password field and input the password
        driver.findElement(By.id("user_password")).sendKeys( ...KeysToSend: "admins");
        //8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep( millis: 10000);
    }
    @Test (priority = 1)
    public void clickuser1Item() throws InterruptedException {
        //9. click on user1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2. verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void verifyUser1() throws InterruptedException {
        //Test8. verify that the user1 item is present on the item list page
        // 10. search for an item (using python with selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle))
            //pass
            System.out.println("correct User1Page");
        else
            //fail
            System.out.println("wrong User1Page");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void logoutSuccessfully() {
        //11. click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10> verify that when user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(expectedTitle.contains(actualTitle))
            //pass
            System.out.println("correct User1Page");
        else
            //fail
            System.out.println("wrong User1Page");

    }
    @Test (priority = 4)
    public void negativeSignup1() throws InterruptedException {
        //4. click on signup button to open the sign up page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test6. verify that user cannot signup with all the fields blank
        //5. input username on username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6. input email for email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7. locate the password field and input the password
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @AfterTest
    public void closeBrowser() {
        //quit browser
        driver.quit();
    }
}



