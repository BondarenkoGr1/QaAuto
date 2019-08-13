import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogSocialNetwork {
    WebDriver driver;

    public LogSocialNetwork(WebDriver driver){
        this.driver = driver;
    }

    private By link = By.xpath("//a[contains(text(),'Вход')]");
    private By title = By.xpath("//h1[contains(text(),'Выберите аккаунт')]");

    private By butVk = By.xpath("//img[@title='Войти через Вконтакте']/parent::a");
        private By emailVk = By.xpath("//input[@name='email']");
        private By passVk = By.xpath("//input[@name='pass']");
        private By logInVk = By.xpath("//button[@id='install_allow']");
        private By confirmVk = By.xpath("//button[contains(text(),'Разрешить')]");

    private By butFacebook = By.xpath("//img[@title='Войти через Facebook']/parent::a");
        private By emailFacebook = By.xpath("//input[@id='email']");
        private By passFacebook = By.xpath("//input[@id='pass']");
        private By logInFacebook = By.xpath("//button[@name='login']");

    private By butTwitter = By.xpath("//div[@class='icons']//img[@title='Войти через Twitter']");
        private By emailTwitter = By.xpath("//input[@id='username_or_email']");
        private By passTwitter = By.xpath("//input[@id='password']");
        private By logInTwitter = By.xpath("//input[@id='allow']");

    private By butGoogle = By.xpath("//div[@class='icons']//img[@title='Войти через Google+']");
        private By clickAddAcc = By.xpath("//div[contains(text(),'Сменить аккаунт')]");
        private By emailGoogle = By.xpath("//input[@type='email']");
        private By butNext1 = By.xpath("//span[contains(text(),'Далее')]//parent::*/parent::div");

        private By passGoogle = By.xpath("//input[@type='password']");
        private By butNext2 = By.xpath("//span[contains(text(),'Далее')]//parent::*/parent::div");

        private By numberGoogle = By.xpath("//input[@id='mobile']");
        private By butContinue = By.xpath("//input[@class='butsend']");

    private By butMail = By.xpath("//div[@class='icons']//img[@title='Войти через Mail.Ru']");
        private By selectUser = By.xpath("//span[contains(text(),'Войти другим пользователем')]//parent::button");
        private By emailMail = By.xpath("//input[@name='Login']");
        private By passMail = By.xpath("//input[@name='Password']");
        private By logInMail = By.xpath("//span[contains(text(),'Войти')]/parent::button");

    public By getTitle() {
        return title;
    }

    public LogSocialNetwork clickLink(){
        driver.findElement(link).click();
        return new LogSocialNetwork(driver);
    }

    public LogSocialNetwork clickIcoVk(){
        driver.findElement(butVk).click();
        return new LogSocialNetwork(driver);
    }
        public LogSocialNetwork emailVk(String email){
            driver.findElement(emailVk).sendKeys(email);
            return this;
        }
        public LogSocialNetwork passVk(String password){
            driver.findElement(passVk).sendKeys(password);
            return this;
        }
        public LogSocialNetwork clickLogInVk(){
            driver.findElement(logInVk).submit();
            return new LogSocialNetwork(driver);
        }
        public LogSocialNetwork clickConfirmVk(){
            driver.findElement(confirmVk).submit();
            return new LogSocialNetwork(driver);
        }

    public LogSocialNetwork logInVk(String email,String password){
        this.clickLink();
        this.clickIcoVk();
        this.emailVk(email);
        this.passVk(password);
        this.clickLogInVk();
        this.clickConfirmVk();
        return new LogSocialNetwork(driver);
    }

    public LogSocialNetwork clickIcoFacebook(){
        driver.findElement(butFacebook).click();
        return new LogSocialNetwork(driver);
    }

        public LogSocialNetwork emailFacebook(String email){
            driver.findElement(emailFacebook).sendKeys(email);
            return this;
        }
        public LogSocialNetwork passFacebook(String password){
            driver.findElement(passFacebook).sendKeys(password);
            return this;
        }
         public LogSocialNetwork clickLogInFacebook(){
            driver.findElement(logInFacebook).submit();
            return new LogSocialNetwork(driver);
        }

    public LogSocialNetwork logInFacebook(String email,String password){
        this.clickIcoFacebook();
        this.emailFacebook(email);
        this.passFacebook(password);
        this.clickLogInFacebook();
        return new LogSocialNetwork(driver);
    }

    public LogSocialNetwork clickIcoTwitter(){
        driver.findElement(butTwitter).click();
        return new LogSocialNetwork(driver);
    }
        public LogSocialNetwork emailTwitter(String email){
            driver.findElement(emailTwitter).sendKeys(email);
            return this;
        }
        public LogSocialNetwork passTwitter(String password){
            driver.findElement(passTwitter).sendKeys(password);
            return this;
        }
        public LogSocialNetwork clickLogInTwitter(){
            driver.findElement(logInTwitter).submit();
            return new LogSocialNetwork(driver);
        }

    public LogSocialNetwork logInTwitter(String email,String password){
        this.clickIcoTwitter();
        this.emailTwitter(email);
        this.passTwitter(password);
        this.clickLogInTwitter();
        return new LogSocialNetwork(driver);
    }

    public LogSocialNetwork clickIcoGoogle(){
        driver.findElement(butGoogle).click();
        return new LogSocialNetwork(driver);
    }
        public LogSocialNetwork clickAddGoogle(){
            driver.findElement(clickAddAcc).click();
            return new LogSocialNetwork(driver);
        }
        public LogSocialNetwork emailGoogle(String email){
            driver.findElement(emailGoogle).sendKeys(email);
            return this;
        }
        public LogSocialNetwork clickNext1(){
            driver.findElement(butNext1).click();
            return new LogSocialNetwork(driver);
        }
        public LogSocialNetwork passGoogle(String password){
            driver.findElement(passGoogle).sendKeys(password);
            return this;
        }
        public LogSocialNetwork clickNext2(){
            driver.findElement(butNext2).click();
            return new LogSocialNetwork(driver);
        }
        public LogSocialNetwork numberGoogle(String number){
            driver.findElement(numberGoogle).sendKeys(number);
            return this;
        }
        public LogSocialNetwork clicContinue(){
            driver.findElement(butContinue).click();
            return new LogSocialNetwork(driver);
        }

    public LogSocialNetwork logInGoogle(String email,String password,String number){
        this.clickIcoGoogle();
        this.clickAddGoogle();
        this.emailGoogle(email);
        this.clickNext1();
        this.passGoogle(password);
        this.clickNext2();
        this.numberGoogle(number);
        this.clicContinue();
        return new LogSocialNetwork(driver);
    }

    public LogSocialNetwork clickIcoMail(){
        driver.findElement(butMail).click();
        return new LogSocialNetwork(driver);
    }
        public LogSocialNetwork clickSelectUser(){
            driver.findElement(selectUser).submit();
            return new LogSocialNetwork(driver);
        }
        public LogSocialNetwork emailMail(String email){
            driver.findElement(emailMail).sendKeys(email);
            return this;
        }
        public LogSocialNetwork passMail(String password){
            driver.findElement(passMail).sendKeys(password);
            return this;
        }
        public LogSocialNetwork clickLogInMail(){
            driver.findElement(logInMail).submit();
            return new LogSocialNetwork(driver);
        }

    public LogSocialNetwork logInMail(String email,String password){
        this.clickIcoMail();
        this.emailMail(email);
        this.passMail(password);
        this.clickLogInMail();
        return new LogSocialNetwork(driver);
    }

}
