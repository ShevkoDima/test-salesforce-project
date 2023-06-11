package base.pages;

import base.utils.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageNavigator extends BasePage {

    public PageNavigator() {
        waitForLoad();
    }

    @FindBy(xpath = ".//a[@title='Home']")
    private WebElement homeButton;

    @Override
    public void waitForLoad() {
        WebDriverActions.waitForElementToBeClickable(homeButton);
    }

    private String pageButtonLocator = ".//a[@title='%s']/parent::*";

    public void navigateToPage(final String pageName) {
        WebDriverActions.clickElement(By.xpath(String.format(pageButtonLocator, pageName)));
    }
}
