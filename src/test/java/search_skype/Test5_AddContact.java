package search_skype;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skype.chat_pages.ChatPage;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nastia on 3/5/17.
 */
public class Test5_AddContact {
    public WebDriver driver;
    HomePage homePage;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;
    ChatPage chatPage;

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
        chatPage = new ChatPage(driver);
    }

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
    private void addContact() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shellSplashContent")));
        homePage.searchForExistingNewContact2("vvpp02");
        homePage.clickNewFoundContact();
        chatPage.clickAddToContactsBtn();


    }
}
