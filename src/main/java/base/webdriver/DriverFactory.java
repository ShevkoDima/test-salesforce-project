package base.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.EnumMap;

public final class DriverFactory {
    private DriverFactory() {

    }

    public static WebDriver getDriver(final DriverType type) {
        EnumMap<DriverType, Browser> driverMap = new EnumMap<>(DriverType.class);
        driverMap.put(DriverType.CHROME, new ChromeBrowser());
        return driverMap.get(type).getDriver();
    }
}
