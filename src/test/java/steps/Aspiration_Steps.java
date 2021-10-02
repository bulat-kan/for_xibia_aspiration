package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Aspiration_Steps {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("user visits home page")
    public void user_visits_home_page() {
        homePage = new HomePage(driver);
        homePage.openPage();

    }

    @When("user navigates to products page through spend&save")
    public void user_navigates_to_products_page_through_spend_save() {
        homePage.navigateToProductsPage();
    }

    @Then("user can see products page")
    public void user_can_see_products_page() {
        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isPageTitleDisplayed());
    }

    @Then("user can see {int} products")
    public void user_can_see_products(int expectedProductCount, DataTable dataTable) {
        productsPage = new ProductsPage(driver);
        List<String> products = dataTable.asList();
        assertEquals("Incorrect number of products", expectedProductCount, productsPage.getPlansCount());
        assertEquals(productsPage.getFirstPlanName(), products.get(0));
        assertEquals(productsPage.getSecondPlanName(), products.get(1));
    }

    @When("user selects original Aspiration plan")
    public void user_selects_original_aspiration_plan() {
        productsPage = new ProductsPage(driver);
        productsPage.pickOriginalPlan();
    }

    @Then("email signup input appears")
    public void email_signup_input_appears() {
        assertTrue("signup email is not visible",productsPage.isSignupEmailFieldVisible());
    }

    @When("user selects Plus plan")
    public void user_selects_plus_plan() {
      productsPage = new ProductsPage(driver);
      productsPage.pickPlusPlan();
    }
    @Then("user can see monthly and yearly plans window")
    public void user_can_see_monthly_and_yearly_plans_window() {
        assertTrue(productsPage.isPlusPlanWindowAppear());
    }

    @Given("user is on products page")
    public void userIsOnProductsPage() {
        productsPage = new ProductsPage(driver);
        productsPage.openPage();
    }

    @Then("user can see yearly plan is {string}")
    public void user_can_see_yearly_plan_is(String expected) {
        assertTrue(productsPage.getYearlyPlanPriceInfo().toLowerCase().contains(expected.toLowerCase()));
    }
    @Then("user can see monthly plan is  {string}")
    public void user_can_see_monthly_plan_is(String expected) {
        assertTrue(productsPage.getMonthlyPlanPriceInfo().toLowerCase().contains(expected.toLowerCase()));
    }
}
