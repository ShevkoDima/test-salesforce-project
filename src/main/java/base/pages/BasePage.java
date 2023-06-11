package base.pages;

import org.apache.log4j.Logger;


public abstract class BasePage extends BaseComponent {

    private static final Logger log = Logger.getLogger(BasePage.class);

    public String getPageTitle() {
        return webDriver.getTitle();
    }
}
