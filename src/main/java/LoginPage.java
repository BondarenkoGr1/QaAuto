import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By butEntrance = By.xpath("//a[contains(text(),'Вход')]");
    private By inEmail = By.xpath("//input[@id='email']");
    private By pass = By.xpath("//input[@name='pass']");
    private By logInBut = By.xpath("//input[@value='Войти']");
    private By error = By.xpath("//div[@class='form-validation-field-0formError parentFormlogin_form formError']");
    private By titleName = By.xpath("//div[@class='welcome-block']//div[@class='title']");



    public LoginPage typeUserEmail(String email) {
        driver.findElement(inEmail).sendKeys(email);
        return this;
    }
    public LoginPage typeUserPass(String password) {
        driver.findElement(pass).sendKeys(password);
        return this;
    }
    public LoginPage titleName() {
        driver.findElement(titleName).getText();
        return this;
    }
    public LoginPage clickEntrance(){
        driver.findElement(By.xpath("//a[contains(text(),'Вход')]")).click();
        return new LoginPage(driver);
    }
    public LoginPage clickLogin(){
        driver.findElement(logInBut).click();
        return new LoginPage(driver);
    }
    public LoginPage logInUser(String email,String password){

        this.typeUserEmail(email);
        this.typeUserPass(password);
        this.clickLogin();
        return new LoginPage(driver);
    }
    public LoginPage invalidLogin(String email, String password){
        this.typeUserEmail(email);
        this.typeUserPass(password);
        driver.findElement(logInBut).click();
        return new LoginPage(driver);
    }
    public String  errorMsg(){
        return driver.findElement(error).getText();
    }
}
