package at.fhhagenberg.sqe;

import at.fhhagenberg.sqe.pageobjects.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.util.concurrent.TimeUnit;


public class StepDefinitions {
	
	private static WebDriver driver;
	private static final DriverManagerType DRIVER_TYPE = DriverManagerType.CHROME;
	
	private SearchPage searchPage;
	private ResultsPage resultsPage;

	@Before
	public void setUp() { 
		WebDriverManager.getInstance(DRIVER_TYPE).setup(); 
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@After
    public void tearDown() {
		driver.close();
		driver.quit();
	}

    @Given("the search page {string} is open")
    public void openSeachPage(String url) {
		driver.get(url);
		searchPage = new SearchPage(driver);
		searchPage.confirmTerms();
    }

    @When("I enter the term {string}")
    public void searchFor(String searchTerm) {
		resultsPage = searchPage.searchFor(searchTerm);
    }

    @Then("I should see the results on the page {string}")
    public void verifyResultsPage(String pageTitle) {
		assertEquals(pageTitle, resultsPage.getTitle());
    }

}
