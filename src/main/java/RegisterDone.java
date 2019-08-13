import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterDone {
    WebElement driver;

    public RegisterDone(WebDriver driver) {

    }


    private By title = By.xpath("//h3[contains(text(),'Благодарим за регистрацию!')]");

    public String getTitle(){
        return driver.findElement(title).getText();
    }

}
