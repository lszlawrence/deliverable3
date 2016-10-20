/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

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

/**
 *
 * @author AsphaltPanthers
 */
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

    @And("I click the Product Category")
    public void clickButton(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"menu-item-33\"]/a"));
        element.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         ExpectedCondition e = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
        return (!d.getCurrentUrl().endsWith(".com/"));
        }

        };
        wait.until(e);
    }

    @And ("search (.*)")
    public void sendSynatx(String item){
        driver.findElement(By.xpath("//*[@id=\"main-nav\"]/form/fieldset/input[1]")).clear();
        driver.findElement(By.xpath("//*[@id=\"main-nav\"]/form/fieldset/input[1]")).sendKeys(item);
        driver.findElement(By.xpath("//*[@id=\"main-nav\"]/form/fieldset/input[1]")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().endsWith(".com/"));
            }

        };
        wait.until(e);
    }
    @Then("the title should be (.*)")
    public void checkPageTitle(String title) {
        assertEquals(title, driver.getTitle());
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

    @Then("^the result should contain (.*)$")
    public void theResultShouldContain(String expect)  {
       String s = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(s.contains(expect));
    }

    @And("^I click the iphone5 picture in the homepage$")
    public void iClickTheIphonePictureInTheHomepage()  {
        // Write code here that turns the phrase above into concrete actions
       // String s = driver.findElement(By.xpath("//*[@id=\"footer\"]/section[2]/ul/li[1]/a[1]")).getText();
        driver.findElement(By.xpath("//*[@id=\"footer\"]/section[2]/ul/li[1]/a[2]/img")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().endsWith(".com/"));
            }

        };
        wait.until(e);

    }
    @Then("^the site should be the item i click$")
    public void theSiteShouldBeTheItemIClick() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"additional-tab\"]/h2")).getText().contains("Additional Information"));

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
}
