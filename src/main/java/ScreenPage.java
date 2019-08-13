import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenPage {
    WebDriver driver;
    Date datenow = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy-hh-mm");
    String nameFile = format.format(datenow) + ".png";
    public ScreenPage(WebDriver driver){
        this.driver = driver;
    }

    public CheckInPage screen() throws IOException {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File month = new File("screen-" + nameFile);
        Files.copy(temp,month);
        return new CheckInPage(driver);
    }
    public CheckInPage screenError() throws IOException {

        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File month = new File("ERROR-" + nameFile);
        Files.copy(temp,month);
        return new CheckInPage(driver);
    }
}
