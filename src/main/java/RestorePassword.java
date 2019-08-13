import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePassword {
    WebDriver driver;

    public RestorePassword(WebDriver driver){
        this.driver = driver;
    }

    private By butSettings = By.xpath("//div[@class='icon settings']");
    private By account = By.xpath("//a[contains(text(),'Учетная запись')]");
    private By oldPass = By.xpath("//input[@id='old']");
    private By newPass = By.xpath("//input[@id='new']");
    private By repeatPass = By.xpath("//input[@id='rep']");
    private By butSave = By.xpath("//a[contains(text(),'Изменить пароль')]");
    //RES PASS
    private By clickRes = By.xpath("//a[contains(text(),'Напомнить пароль')]");
    private By inNumber = By.xpath("//input[@id='mobile']");
    private By smsCode = By.xpath("//input[@id='smsCode']");
    private By checkCode = By.xpath("//input[@id='checkCode']");

    public RestorePassword clickRes(){
        driver.findElement(clickRes).click();
        return new RestorePassword(driver);
    }
    public RestorePassword typeNumber(String number){
        driver.findElement(inNumber).sendKeys(number);
        return this;
    }
    public RestorePassword typeSmsCode(String sms){
        driver.findElement(smsCode).sendKeys(sms);
        return this;
    }
    public RestorePassword clickButRes(){
        driver.findElement(checkCode).click();
        return new RestorePassword(driver);
    }
    public RestorePassword resPassword(String number,String sms){
        this.clickRes();
        this.typeNumber(number);
        this.typeSmsCode(sms);
        this.clickButRes();
        return new RestorePassword(driver);
    }


}
