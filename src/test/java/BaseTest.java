
import base.webdriver.DriverManager;
import base.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getInstance().getDriver();
        driver.navigate().to("https://login.salesforce.com/");
        loginPage = new LoginPage();
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
