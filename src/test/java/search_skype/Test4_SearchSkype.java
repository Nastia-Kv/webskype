package search_skype;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import skype.BasePage;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nastia on 3/2/17.
 */
public class Test4_SearchSkype {
    public WebDriver driver;
    HomePage homePage;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;

    @BeforeClass(alwaysRun = true)
    private void setup() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "/Users/nastia/IdeaProjects/webskype/chromedriver-2.27");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        loginPage1 = new LoginPage1(driver);
        loginPage2 = new LoginPage2(driver);
    }
//
//    @AfterTest
//    private void clearSearchResults(){
//        homePage.clickClearchSearchBtn();
//    }

//    @AfterClass(alwaysRun = true)
//    private void teardown(){
//        driver.quit();
//    }


    @Test
    private void loginPositive() throws InterruptedException {
        loginPage1.loadPage();
        //loginPage1.isEmailFieldVisible();
        loginPage1.populateEmail("kvas.test_8");
        loginPage2.populatePassField("123Cat123");
        loginPage2.clickSigninBtn2();

    }

    @Test(dependsOnMethods = "loginPositive")
    private void searchForContact() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shellSplashContent")));
        homePage.searchForExistingNewContact("kvas3.test3@outlook.com");
        homePage.searchForExistingNewContact("kvas.tererest_6");
        homePage.searchForExistingNewContact("kvas.test_6");

        homePage.searchForNonExistingNewContact("kvasdd.test4");
        homePage.searchForNonExistingNewContact("kvas3.test3@outlook.com");
        homePage.searchForNonExistingNewContact("kvas.test_6");

        homePage.searchForContactInContactList("kvas.test_6");
        homePage.searchForContactInContactList("kvas.tfdsfgdfgest_6");
        homePage.searchForContactInContactList("kvas3.test3@outlook.com");
    }


}
