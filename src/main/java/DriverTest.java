import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", MainPage.class.getResource("chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();


        driver.get("https://github.com");
    }
}




