import org.junit.*;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;



public class LogInTest {
    WebDriver driver;
//    String username = "dmitriy.bondarenko.9494@mail.ru";
//    String accesskey = "1aKGafWvZ6P3WWG0PX5vHCkgcSTMxTx2WpFwvpcVId6xttuzy4";
//    static RemoteWebDriver driver = null;
//    String gridURL = "@hub.lambdatest.com/wd/hub";
//    boolean status = false;
//    public static void main(String[] args) {
//        new LogInTest().testGrid();
//    }
    @Test
    public void File(){
        File myfile = new File("login.txt");
        try
        {
            FileReader fRead = new FileReader(myfile);
            BufferedReader br = new BufferedReader(fRead);
            String line;
            List<String> list = new ArrayList<String>();
            while ((line = br.readLine()) != null){
                list.add(line);

            }
            br.close();
            System.out.println(list);

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] logIN() {
        return new Object[][] {
                {"test_bondarenko@biz.com","149f61"},
                {"dmitriy.bondarenko.9494@mail.ru","qawsed2408"},
                {"test_dmitriy@prostoy.biz","149d61"},
                {"test_dmitriy@mail.ru","22222"},
                {"test_bondarenko@biz.com", "1111111"}
        };
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("firefox");
//        capabilities.setPlatform(Platform.WIN10);
//
//
//        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.23:5557/grid/register"), capabilities);
        System.setProperty("webdriver.gecko.driver", MainPage.class.getResource("geckodriver.exe").getPath());
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.edge.driver", MainPage.class.getResource("MicrosoftWebDriver.exe").getPath());
//        driver = new EdgeDriver();
        driver.get("https://www.prostoy.ru/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement butLogin = driver.findElement(By.xpath("//a[contains(text(),'Вход')]"));
        butLogin.click();


    }
//    private void setUp() {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("version", "70.0");
//        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
//        capabilities.setCapability("build", "LambdaTestSampleApp");
//        capabilities.setCapability("name", "LambdaTestJavaSample");
//        capabilities.setCapability("network", true); // To enable network logs
//        capabilities.setCapability("visual", true); // To enable step by step screenshot
//        capabilities.setCapability("video", true); // To enable video recording
//        capabilities.setCapability("console", true); // To capture console logs
//        try {
//            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
//        } catch (MalformedURLException e) {
//            System.out.println("Invalid grid URL");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    @AfterClass
//    private void tearDown() {
//        if (driver != null) {
//            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
//            driver.quit(); //really important statement for preventing your test execution from a timeout.
//        }
//    }

    @Test
    public void test(){

    }

    @Test(dataProvider="logIN")
    public void logIn(String typeUserEmail, String typeUserPass) throws InterruptedException {


        LoginPage logPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait (driver, 120);
        try
        {

            logPage.logInUser(typeUserEmail,typeUserPass);



            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='icon exit']")));
            System.out.println(driver.getTitle());
            driver.get("https://www.prostoy.ru/");
            driver.findElement(By.xpath("//div[@class='col-lg-7 chunk_auth']//span[contains(text(),'Выход')]")).click();
            Thread.sleep(5000);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            String error = logPage.errorMsg();
            System.out.println(error);
            Assert.assertEquals("Проверьте правильность ввода пароля!",error);

            driver.quit();
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
