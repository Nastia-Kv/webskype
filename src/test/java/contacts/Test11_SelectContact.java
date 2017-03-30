package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skype.chat_pages.ChatPage;
import skype.contacts_pages.ContactsPage;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nastia on 3/9/17.
 */
public class Test11_SelectContact {

    public WebDriver driver;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;
    HomePage homePage;
    ContactsPage contactsPage;
    ChatPage chatPage;


    @BeforeClass(alwaysRun = true)
    private void setup() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "/Users/nastia/Documents/workspace_2/Drivers/chromedriver-2.27");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        loginPage1 = new LoginPage1(driver);
        loginPage2 = new LoginPage2(driver);
        contactsPage = new ContactsPage(driver);

    }

    @Test(alwaysRun = true)
    private void loginPositive() throws InterruptedException {
        loginPage1.loadPage();
        //loginPage1.isEmailFieldVisible();
        loginPage1.populateEmail("kvas.test_8");
        loginPage2.populatePassField("123Cat123");
        loginPage2.clickSigninBtn2();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shellSplashContent")));

    }

    @Test(dependsOnMethods = "loginPositive")
    private void selectContact() throws InterruptedException {
        try {
            homePage.clickContactsBtn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contactsPage.selectKContact();

    }
}