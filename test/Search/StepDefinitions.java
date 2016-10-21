package Search;

/**
 * Created by lszlawrence on 16/10/20.
 */

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



    @Then("^I should receive (.*)$")
    public void iShouldReceiveAnErrorMessageIncorrectPasswordEntered(String expected)  {
        // Write code here that turns the phrase above into concrete actions
        String s = driver.findElement(By.className("response")).getText();

        assertTrue(s.contains(expected));
    }


    @After
    public void cleanUp() {driver.quit();}



    @Then("^the result should contain (.*)$")
    public void theResultShouldContain(String expect)  {
        String s = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(s.contains(expect));
    }


    @Then("^the site should be the item i click$")
    public void theSiteShouldBeTheItemIClick() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"additional-tab\"]/h2")).getText().contains("Additional Information"));

    }

}
