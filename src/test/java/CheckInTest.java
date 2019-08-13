import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckInTest {
    WebDriver driver;

    @DataProvider
    public Object[][] checkIn() {
        return new Object[][] {
                {"test","dmitestP@prostoy.biz","+12223334455","456311"},
//                {"TECT","checkInTest@prostoy.ru","12223334455","456311"},
//                {"teст","bondarenko.@prostoy.ru","380993214576","456351"},
//                {"PeTRo","petya.ivan@mail.ru","1222939495","456351"},

        };
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", MainPage.class.getResource("geckodriver.exe").getPath());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.prostoy.ru/");
    }

    @Test(dataProvider = "checkIn")
    public void checkIn(String username,String email,String number,String sms) throws IOException {
        CheckInPage  checkInPage = new CheckInPage(driver);
        ScreenPage screen = new ScreenPage(driver);
        try{
            checkInPage.clickCheckInUser(username,email, number,sms);
            Thread.sleep(8000);
            WebDriverWait wait = new WebDriverWait (driver, 120);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Благодарим за регистрацию!')]")));
            System.out.println("Название вкладки: "+driver.getTitle());
            System.out.println("Зарегестрированные данные: "+checkInPage.getTitle());
            screen.screen();
            driver.navigate().back();
            }
        catch(Exception ex){
            screen.screenError();
            driver.get("https://www.prostoy.ru/");
            System.out.println(checkInPage.getErrorMsg());
        }
    }
    @Test(dataProvider = "checkIn")
    @Ignore
    public void invalName(String username,String email,String number,String sms) throws InterruptedException {
        CheckInPage  checkInPage = new CheckInPage(driver);
        checkInPage.clickCheckInUser(username,email, number,sms);

        Thread.sleep(10000);
        String error = checkInPage.getErrorMsg();
        if (error == null){

            Assert.assertEquals("Пожалуйста, заполните поле «Имя» корректно (допустимы только буквы).",error);
        }
        else{
            System.out.println(checkInPage.getErrorMsg());
            Assert.assertEquals("Пожалуйста, заполните поле «Имя».",error);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
