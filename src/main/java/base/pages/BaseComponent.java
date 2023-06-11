package base.pages;

import base.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseComponent {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BaseComponent() {
        webDriver = DriverManager.getInstance().getDriver();
        webDriverWait = DriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
        waitForLoad();
    }

    public abstract void waitForLoad();
}
