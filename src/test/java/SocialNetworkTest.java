import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SocialNetworkTest {
    WebDriver driver;

    @DataProvider
    public Object[][] logVk() {
        return new Object[][] {
                {"380954513346","139d931"},
//                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
        };
    }
    @DataProvider
    public Object[][] logFacebook() {
        return new Object[][] {
                {"380669189838","qawsed2408"},
//                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
        };
    }
    @DataProvider
    public Object[][] logTwitter() {
        return new Object[][] {
                {"380669189838","qawsed2408"},
                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
        };
    }
    @DataProvider
    public Object[][] logGoogle() {
        return new Object[][] {
                {"bdmitriy64@gmail.com","139dd931"},
//                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
        };
    }
    @DataProvider
    public Object[][] logMail() {
        return new Object[][] {
                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
                {"test_bondarenko@biz.com","149f61"},

        };
    }

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", MainPage.class.getResource("geckodriver.exe").getPath());
        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", MainPage.class.getResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void startTest() throws InterruptedException {
        driver.get("https://www.prostoy.ru/");
        WebDriverWait wait = new WebDriverWait (driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Вход')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Вход')]")).click();


    }

    @Test(dataProvider = "logVk")
    @Ignore
    public void LogInVk(String email, String password){
        LogSocialNetwork logSoc = new LogSocialNetwork(driver);
        ScreenPage screenPage = new ScreenPage(driver);
        try {
            logSoc.clickIcoVk();
            Thread.sleep(6000);
            System.out.println(driver.getTitle());
            screenPage.screen();
            System.out.println(screenPage.nameFile);
        }
        catch(Exception ex){
        }
    }

    @Test(dataProvider = "logFacebook")
    public void LogInFacebook(String email, String password){
        LogSocialNetwork logSoc = new LogSocialNetwork(driver);
        ScreenPage screenPage = new ScreenPage(driver);
        try {
            logSoc.logInFacebook(email, password);
            Thread.sleep(6000);
            System.out.println(driver.getTitle());
            screenPage.screen();
            System.out.println(screenPage.nameFile);
        }
        catch(Exception ex){
        }
    }

    @Test(dataProvider = "logTwitter")
    @Ignore
    public void LogInTwitter(String email, String password){
        LogSocialNetwork logSoc = new LogSocialNetwork(driver);
        ScreenPage screenPage = new ScreenPage(driver);
        try {
            logSoc.logInTwitter(email, password);
            Thread.sleep(6000);
            System.out.println(driver.getTitle());
            screenPage.screen();
            System.out.println(screenPage.nameFile);
        }
        catch(Exception ex){
        }
    }

    @Test(dataProvider = "logGoogle")
    @Ignore
    public void LogInGoogle(String email, String password, String number){
        LogSocialNetwork logSoc = new LogSocialNetwork(driver);
        ScreenPage screenPage = new ScreenPage(driver);
        try {
            logSoc.clickIcoGoogle();
            Thread.sleep(2000);
            logSoc.clickAddGoogle();
            logSoc.emailGoogle(email);
            logSoc.clickNext1();
            Thread.sleep(6000);
            System.out.println(driver.getTitle());
            screenPage.screen();
            System.out.println(screenPage.nameFile);
        }
        catch(Exception ex){
        }
    }

    @Test(dataProvider = "logMail")
    @Ignore
    public void LogInMail(String email, String password){
        LogSocialNetwork logSoc = new LogSocialNetwork(driver);
        ScreenPage screenPage = new ScreenPage(driver);
        try {
            if (logSoc.getTitle().equals("Выберите аккаунт")){
                logSoc.clickSelectUser();
                logSoc.logInMail(email, password);
                Thread.sleep(6000);
                System.out.println(driver.getTitle());
                screenPage.screen();
                System.out.println(screenPage.nameFile);
            }else {
                logSoc.logInMail(email, password);
                Thread.sleep(6000);
                System.out.println(driver.getTitle());
                screenPage.screen();
                System.out.println(screenPage.nameFile);
            }
        }
        catch(Exception ex){
        }
    }

    @AfterMethod
    public void pageBack(){
        driver.get("https://www.prostoy.ru/");
    }



}
