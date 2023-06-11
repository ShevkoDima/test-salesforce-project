package base.pages;

import base.utils.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final String USERNAME = "dmishevko-mkhw@force.com";
    private final String PASSWORD = "testpassword123";

    public LoginPage() {
        waitForLoad();
    }

    @Override
    public void waitForLoad() {
        WebDriverActions.waitForElementToBeVisible(salesForceLogo);
    }

    @FindBy(className = "standard_logo")
    private WebElement salesForceLogo;
    @FindBy(id = "username")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public HomePage loginSalesForce() {
        WebDriverActions.clearAndInputText(loginField, USERNAME);
        WebDriverActions.clearAndInputText(passwordField, PASSWORD);
        WebDriverActions.clickElement(loginButton);
        return new HomePage();
    }
}
