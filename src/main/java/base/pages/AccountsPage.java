package base.pages;

import base.utils.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage {

    @FindBy(xpath = ".//a[@title='Accounts']")
    private WebElement accountsButton;

    @FindBy(xpath = ".//a[@title='New']/parent::*")
    private WebElement newAccountButton;

    @FindBy(xpath = ".//button[@title='Save']")
    private WebElement saveAccountButton;

    @FindBy(xpath = ".//button[@name='Edit']")
    private WebElement editAccountButton;

    @FindBy(xpath = ".//records-record-layout-item[@field-label='Account Name']//lightning-formatted-text")
    private WebElement accountNameText;

    @FindBy(xpath = ".//records-record-layout-item[@field-label='Phone']//a")
    private WebElement phoneNumber;

    @FindBy(xpath = ".//button[@name='SaveEdit']")
    private WebElement saveEditButton;

    @FindBy(xpath = ".//div[@role='alertdialog']")
    private WebElement alertDialogPopup;

    @FindBy(xpath = ".//lightning-button-menu[contains(@class, 'menu-button-item')]//button")
    private WebElement menuDropDown;

    @FindBy(xpath = ".//lightning-button-menu[contains(@class, 'menu-button-item')]/parent::li//a[@name='Delete']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = ".//button[@title='Delete']")
    private WebElement deleteAccountButtonInAlertWindow;

    @FindBy(xpath = ".//input[@name='Account-search-input']")
    private WebElement accountSearchInputField;

    @FindBy(xpath = ".//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']")
    private WebElement accountListStatus;

    @FindBy(xpath = ".//div[@class='emptyContent slds-is-absolute hidden']")
    private WebElement disappearingWaitElement;

    private final String fieldNameInput = ".//div[@data-target-selection-name='sfdc:RecordField.Account.%s']//input";
    private final String accountTitle = ".//a[@title='%s' and @data-refid='recordId']";

    public AccountsPage() {
        waitForLoad();
    }

    @Override
    public void waitForLoad() {
        WebDriverActions.waitForElementToBeClickable(accountsButton);
    }

    public void clickNewAccountButton() {
        newAccountButton.click();
    }

    public void clickSaveAccountButton() {
        saveAccountButton.click();
        WebDriverActions.waitForElementToDisappear(alertDialogPopup);
    }

    public void clickSaveEditButton() {
        saveEditButton.click();
        WebDriverActions.waitForElementToDisappear(alertDialogPopup);
    }

    public void inputTextToAccountInformationTextField(final String fieldName, final String text) {
        WebDriverActions.clearAndInputText(By.xpath(String.format(fieldNameInput, fieldName)), text);
    }

    public Boolean isAccountTitleClickable(final String title) {
        return WebDriverActions.isElementClickable(By.xpath(String.format(accountTitle, title)));
    }

    public void clickAccountTitle(final String title) {
        WebDriverActions.clickElement(By.xpath(String.format(accountTitle, title)));
    }

    public void clickEditButton() {
        editAccountButton.click();
    }

    public String getAccountNameText() {
        WebDriverActions.waitForElementToBeVisible(accountNameText);
        return WebDriverActions.getElementText(accountNameText);
    }

    public String getPhoneNumber() {
        return WebDriverActions.getElementText(phoneNumber);
    }

    public void clickMenuDropDown() {
        menuDropDown.click();
    }

    public void deleteAccount() {
        clickMenuDropDown();
        deleteAccountButton.click();
        deleteAccountButtonInAlertWindow.click();
        WebDriverActions.waitForElementToDisappear(alertDialogPopup);
    }

    public void searchAccount(final String text) {
        WebDriverActions.clearAndInputText(accountSearchInputField, text);
        accountSearchInputField.sendKeys(Keys.ENTER);
        WebDriverActions.waitForElementToDisappear(disappearingWaitElement);
    }

    public String getAccountsListStatus() {
        WebDriverActions.waitForElementToBeVisible(accountListStatus);
        return accountListStatus.getText();
    }
}
