package base.pages;

import base.utils.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public final String HOME_PAGE_TITLE = "Home | Salesforce";

    public HomePage() {
        waitForLoad();
    }

    @FindBy(xpath = ".//a[@title=\"Home\"]")
    private WebElement homeButton;

    @Override
    public void waitForLoad() {
        WebDriverActions.waitForElementToBeClickable(homeButton);
    }
}
