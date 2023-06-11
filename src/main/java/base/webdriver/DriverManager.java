package base.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class DriverManager {

    private static DriverManager instance;

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;


    private DriverManager() {
        initializeDriver();
    }

    public static DriverManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void initializeDriver() {
        webDriver = DriverFactory.getDriver(DriverType.CHROME);
        setDefaultTimeWaits();
    }

    public WebDriver getDriver() {
        if (Objects.isNull(webDriver) || getSessionId() == null) {
            initializeDriver();
        }
        return webDriver;
    }

    private SessionId getSessionId() {
        SessionId session = null;
        if (webDriver != null) {
            session = ((ChromeDriver) webDriver).getSessionId();
        }
        return session;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void setImplicitTimeWait(final Duration implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait);
    }

    public void setExplicitTimeWait(final Duration explicitTimeWait) {
        webDriverWait = new WebDriverWait(webDriver, explicitTimeWait, Duration.ofSeconds(10));
    }

    public void setPageLoadTimeWait(final Duration pageLoadTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(pageLoadTimeWait);
    }

    public void setDefaultTimeWaits() {
        Duration implicitWait = Duration.ofSeconds(5);
        Duration explicitWait = Duration.ofSeconds(10);
        Duration pageTimeoutWait = Duration.ofSeconds(10);
        setImplicitTimeWait(implicitWait);
        setExplicitTimeWait(explicitWait);
        setPageLoadTimeWait(pageTimeoutWait);
    }
}
