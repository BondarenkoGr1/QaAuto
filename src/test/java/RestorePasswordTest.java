import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RestorePasswordTest {
    WebDriver driver;

    @DataProvider
    public Object[][] logIN() {
        return new Object[][] {
                {"+12223334455","456311"},
                {"+12223334455","456311"},
                {"+12223334455","456311"},
//                {"test_bondarenko@biz.com","139f61"},
//                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
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

    @Test(dataProvider="logIN")
    @Ignore
    public void letsIt(String number, String sms) throws InterruptedException {
        LoginPage logPage = new LoginPage(driver);
        RestorePassword restorePassword = new RestorePassword(driver);
        try
        {
            logPage.logInUser("","");
            Thread.sleep(2000);
            restorePassword.resPassword(number,sms);
            System.out.println(driver.getTitle());

        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println(logPage.errorMsg());
        }
    }

    @Test
    public void start() {

    }
}
