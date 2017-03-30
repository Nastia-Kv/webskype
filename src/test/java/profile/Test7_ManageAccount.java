package profile;

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
import skype.css_animatable_page.CssAnimatablePage;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;
import skype.profile_pages.ProfilePage;
import utils.Windows;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by nastia on 3/6/17.
 */
public class Test7_ManageAccount {
    public WebDriver driver;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;
    HomePage homePage;
    ProfilePage profilePage;
    CssAnimatablePage cssAnimatablePage;

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
        profilePage = new ProfilePage(driver);
        cssAnimatablePage = new CssAnimatablePage(driver);
    }

    @AfterClass
    private void teardown() {
        driver.quit();
    }

    @Test
    private void loginPositive() throws InterruptedException {
        loginPage1.loadPage();
        loginPage1.populateEmail("kvas.test_8");
        loginPage2.populatePassField("123Cat123");
        loginPage2.clickSigninBtn2();

    }

    @Test(dependsOnMethods = "loginPositive")
    private void manageAccountOnWebsite() throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shellSplashContent")));
        homePage.clickDisplayName();
        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window handle " + parentWindow);
        profilePage.clickManageAccount();
        System.out.println(driver.getTitle());
        for (String childTab : driver.getWindowHandles()) {
            driver.switchTo().window(childTab);
        }
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());

        Windows.winHandlesSize(driver);
        Windows.switchByName("Skype My Account", driver);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindow);
        // driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
    }


}
