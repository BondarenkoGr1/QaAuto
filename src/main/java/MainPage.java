import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class MainPage {
    static WebDriver driver;



    public static void main(String[] args) throws IOException {
        driver = initChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.prostoy.ru/");

        LoginPage logPage = new LoginPage(driver);

        logPage.logInUser("test_dmitriy@prostoy.biz","149d61");

        //div[@object-name='button_exit']
        //li[@class='separator']
//        WebElement explicitWait = (new WebDriverWait(driver, 10))
//        // или пока не появился элемент с id=bar
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tile-main-page__title'])[7]")));
//
//        explicitWait.click();

//        Date datenow = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy-hh-mm");
//        String nameFile = format.format(datenow) + ".png";
////
//        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////        FileUtils.copyFile(temp, new File("C:\\Screenshots\\screen"+System.currentTimeMillis() + ".png"));
//        File month = new File("screen-" + nameFile);
//        Files.copy(temp,month);


//        WebElement dynamicElement = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='title']")));
//        WebElement titleName = driver.findElement(By.xpath("//div[@class='title']"));
//        System.out.println("Аваторизированный пользователь: "+dynamicElement);

    }
    public static WebDriver initDriver(){
        System.setProperty("webdriver.gecko.driver", MainPage.class.getResource("geckodriver.exe").getPath());
        return new FirefoxDriver();
    }

    private static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", MainPage.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
