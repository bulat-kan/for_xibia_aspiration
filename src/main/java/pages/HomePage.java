package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final String homeURL = "https://www.aspiration.com/";
    private final WebDriver driver;

    @FindBy(xpath = "//li[@class='Flex-sc-1kj10zc-0 dPEQCs']/a[contains(.,'Spend')]")
    private WebElement lnkSpendNSave;

    public HomePage(WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openPage(){
        driver.get(homeURL);
    }

    public void navigateToProductsPage() {
        lnkSpendNSave.click();
    }
}
