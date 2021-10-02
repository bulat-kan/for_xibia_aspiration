package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;
    private final String productsURL ="https://www.aspiration.com/our-products";

    @FindBy(css = ".spend-save-plans h1")
    private WebElement title;

    @FindBy(css = ".plan-content")
    List<WebElement> plans;

    @FindBy(css = ".plan-original h2")
    private WebElement originalPlanTitle;

    @FindBy(css = ".plan-a-plus h2")
    private WebElement plusPlanTitle;

    @FindBy(xpath = "//button[normalize-space()='Get Aspiration']")
    private WebElement btnGetOriginalPlan;

    @FindBy(xpath = "//button[normalize-space()='Get Aspiration Plus']")
    private WebElement btnGetPlusPlan;

    @FindBy(id = "join-waitlist-input")
    private WebElement txtBxEmailOriginalPlan;

    @FindBy(css = "p.fonts-v3.text-center.p-choose")
    private WebElement mdlWindowTitle;

    @FindBy(xpath = "//div[@class='option selected']//h3[1]/following-sibling::p")
    private WebElement radioYearlyPlan;

    @FindBy(css = "div[class='option'] p")
    private WebElement radioMonthlyPlan;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageTitleDisplayed() {
        return title.isDisplayed();
    }

    public int getPlansCount() {
        return plans.size();
    }

    public String getFirstPlanName() {
        return originalPlanTitle.getText();
    }

    public String getSecondPlanName() {
        return plusPlanTitle.getText();
    }

    public void pickPlusPlan() {
        btnGetPlusPlan.click();
    }

    public void pickOriginalPlan() {
        btnGetOriginalPlan.click();
    }

    public boolean isSignupEmailFieldVisible() {
        return txtBxEmailOriginalPlan.isDisplayed();
    }

    public boolean isPlusPlanWindowAppear() {
        return mdlWindowTitle.isDisplayed();
    }

    public void openPage() {
        driver.get(productsURL);
    }

    public String getYearlyPlanPriceInfo() {
        return radioYearlyPlan.getText();
    }

    public String getMonthlyPlanPriceInfo() {
        return radioMonthlyPlan.getText();
    }
}
