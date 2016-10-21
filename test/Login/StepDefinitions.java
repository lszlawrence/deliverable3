package Login;

/**
 * Created by lszlawrence on 16/10/20.
 */
import cucumber.api.PendingException;
        import cucumber.api.java.After;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import static junit.framework.Assert.assertEquals;
        import static junit.framework.Assert.assertTrue;

        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;
public class StepDefinitions {


    private WebDriver driver;
    private WebDriverWait wait;

    private final String HOME_PAGE = "http://store.demoqa.com/";

    @Given("a Firefox browser")
    public void openFirefox() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }


    @When("I navigate to the home page")
    public void navigateHome() {
        driver.get(HOME_PAGE);
    }


    @Given("^a login page$")
    public void aLoginPage()  {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get(HOME_PAGE);
        driver.findElement(By.className("account_icon")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @And("^a correct usrname (.*)$")
    public void aCorrectUsername(String usrName)  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys(usrName);
    }

    @And("^an incorrect password (.*)$")
    public void anIncorrectPassword(String passWord) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys(passWord);
    }

    @When("^I try to log in with those credentials$")
    public void iTryToLogInWithThoseCredentials()  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (driver.findElement(By.className("response")).isDisplayed());
            }

        };
        wait.until(e);
    }

    @Then("^I should receive (.*)$")
    public void iShouldReceiveAnErrorMessageIncorrectPasswordEntered(String expected)  {
        // Write code here that turns the phrase above into concrete actions
        String s = driver.findElement(By.className("response")).getText();

        assertTrue(s.contains(expected));
    }


    @After
    public void cleanUp() {driver.quit();}

    @And("^an incorrect usrname (.*)$")
    public void anIncorrectUsrnameUsername(String usrName)  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys(usrName);
    }

    @And("^an  correct password (.*)$")
    public void anCorrectPasswordPassword(String passWord) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys(passWord);
    }

    @And("an empty password")
    public void anEmptyPassword(){
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("");
    }

    @And("an correct usrname lsz")
    public void anCorrectUsrnameLsz() {
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("lsz");
    }
    @And("an correct password 12345")
    public void anCorrectPassword(){
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("12345");
    }
    @Then("i should enter my personal site")
    public void enterMypersonalSite(){
        Assert.assertTrue(driver.findElement(By.className("user-profile-links")).getText().contains("Your Details"));
    }

    @When("^I try to log in with those right credentials$")
    public void iTryToLogInWithThoseRightCredentials()  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (driver.findElement(By.className("user-profile-links")).isDisplayed());
            }

        };
        wait.until(e);
    }


    @And("^an empty usrname$")
    public void anEmptyUsrname()  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("");
    }
}
