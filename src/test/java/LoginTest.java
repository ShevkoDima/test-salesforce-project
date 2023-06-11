
import base.pages.AccountsPage;
import base.pages.HomePage;
import base.pages.PageNavigator;
import constants.FieldNames;
import constants.PageNames;
import org.testng.Assert;
import org.testng.annotations.Test;
import jdk.jfr.Description;

public class LoginTest extends BaseTest {
    public HomePage homePage;
    public PageNavigator pageNavigator;
    public AccountsPage accountsPage;

    @Test
    @Description("Check home page is opened")
    public void loginSalesforce() {
        loginPage.loginSalesForce();
        homePage = new HomePage();
        Assert.assertEquals(homePage.getPageTitle(), homePage.HOME_PAGE_TITLE);
    }

    @Test
    @Description("Create and edit an account. Verify changes")
    public void createAndModifyNewAccount(){
        String newAccountName = "testAccountName";
        String phoneNumber = "1234567890";
        String updatedAccountName = "updateTestAccountName";
        String updatedPhoneNumber = "0987654321";
        String expectedAccountsListStatus = "No items to display.";
        loginPage.loginSalesForce();
        pageNavigator = new PageNavigator();
        pageNavigator.navigateToPage(PageNames.ACCOUNTS.getValue());
        accountsPage = new AccountsPage();
        accountsPage.clickNewAccountButton();
        accountsPage.inputTextToAccountInformationTextField(FieldNames.NAME.getValue(), newAccountName);
        accountsPage.inputTextToAccountInformationTextField(FieldNames.PHONE.getValue(), phoneNumber);
        accountsPage.clickSaveAccountButton();
        pageNavigator.navigateToPage(PageNames.ACCOUNTS.getValue());
        accountsPage.isAccountTitleClickable(newAccountName);
        accountsPage.clickAccountTitle(newAccountName);
        accountsPage.clickEditButton();
        accountsPage.inputTextToAccountInformationTextField(FieldNames.NAME.getValue(), updatedAccountName);
        accountsPage.inputTextToAccountInformationTextField(FieldNames.PHONE.getValue(), updatedPhoneNumber);
        accountsPage.clickSaveEditButton();
        String actualAccountName = accountsPage.getAccountNameText();
        Assert.assertEquals(actualAccountName, updatedAccountName, "Account name field has wrong value - field wasn't updated");
        String actualPhoneNumber = accountsPage.getPhoneNumber();
        Assert.assertEquals(actualPhoneNumber, updatedPhoneNumber, "Phone number field has wrong value - field wasn't updated");
        accountsPage.deleteAccount();
        accountsPage.searchAccount(updatedAccountName);
        Assert.assertEquals(accountsPage.getAccountsListStatus(), expectedAccountsListStatus, "Account wasn't deleted");
    }
}
