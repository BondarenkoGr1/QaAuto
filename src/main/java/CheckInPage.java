import com.google.common.io.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckInPage {
    WebDriver driver;
    public CheckInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inName = By.xpath("//input[@id='name_formreg1']");
    private By inEmail = By.xpath("//input[@id='email_formreg1']");
    private By inNumber = By.xpath("//input[@id='mobile_formreg1']");
    private By inSMS = By.xpath("//input[@id='smsCode_formreg1']");
    private By inSubmit = By.xpath("//form[@id='formreg1']//input[(@value='Зарегистрироваться')]");
    private By error = By.xpath("//div[@class='formErrorContent']");
    private By title = By.xpath("//h3[contains(text(),'Благодарим за регистрацию!')]");

    public String getTitle() {
        return driver.findElement(title).getText();
    }

        public CheckInPage typeUserName(String username){
        driver.findElement(inName).sendKeys(username);
        return this;
    }
    public CheckInPage typeUserEmail(String email){
        driver.findElement(inEmail).sendKeys(email);
        return this;
    }
    public CheckInPage typeUserNumber(String number){
        driver.findElement(inNumber).clear();
        driver.findElement(inNumber).sendKeys(number);
        return this;
    }
    public CheckInPage typeNumberSMS(String sms){
        driver.findElement(inSMS).sendKeys(sms);
        return this;
    }
    public CheckInPage clickRegUser(){
        driver.findElement(inSubmit).click();
        return new CheckInPage(driver);
    }

    public String getErrorMsg(){
        return driver.findElement(error).getText();

    }


    public CheckInPage clickCheckInUser(String username,String email,String number,String sms){

        driver.findElement(inName).clear();
        driver.findElement(inEmail).clear();
        driver.findElement(inNumber).clear();
        driver.findElement(inSMS).clear();
        this.typeUserName(username);
        this.typeUserEmail(email);
        this.typeUserNumber(number);
        this.typeNumberSMS(sms);
        this.clickRegUser();
        return new CheckInPage(driver);
    }
    public CheckInPage invalidLogin(String username,String email,String number,String sms){
        this.typeUserName(username);
        this.typeUserEmail(email);
        this.typeUserNumber(number);
        this.typeNumberSMS(sms);
        this.clickRegUser();
        return new CheckInPage(driver);
    }
    public String getErrorName(){
        return driver.findElement(inName).getText();
    }
    public String getErrorEmail()
    {
        return driver.findElement(inEmail).getText();
    }
    public String getErrorNumber()
    {
        return driver.findElement(inNumber).getText();
    }
    public String getErrorSMS()
    {
        return driver.findElement(inSMS).getText();
    }
}
