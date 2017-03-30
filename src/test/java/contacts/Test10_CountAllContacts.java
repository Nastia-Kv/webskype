package contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skype.contacts_pages.ContactsPage;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;
import skype.profile_pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nastia on 3/9/17.
 */
public class Test10_CountAllContacts {
    public WebDriver driver;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;
    HomePage homePage;
    ContactsPage contactsPage;


    @BeforeClass(alwaysRun = true)
    private void setup() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "/Users/nastia/IdeaProjects/webskype/chromedriver-2.27");
        driver = new ChromeDriver(options);

        homePage = new HomePage(driver);
        loginPage1 = new LoginPage1(driver);
        loginPage2 = new LoginPage2(driver);
        contactsPage = new ContactsPage(driver);

    }
//
    @AfterClass
    private void teardown(){
        driver.quit();
    }

    @Test(alwaysRun = true, groups = "p1")
    private void countAllContacts() throws InterruptedException {
        loginPage1.loadPage();
        loginPage1.populateEmail("kvas.test_8");
        loginPage2.populatePassField("123Cat123");
        loginPage2.clickSigninBtn2();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shellSplashContent")));
        homePage.clickContactsBtn();
        contactsPage.countAllContacts();

    }
}
