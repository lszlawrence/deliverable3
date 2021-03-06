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


    @Then("the title should be (.*)")
    public void checkPageTitle(String title) {
        assertEquals(title, driver.getTitle());
    }


    @After
    public void cleanUp() {driver.quit();}



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




}
