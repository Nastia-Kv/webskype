package login;

import data.LoginData;
import data.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;
import skype.profile_pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by nastia on 2/26/17.
 */
@Test(groups = "p1")
public class Test1_LoginPositive {
    public WebDriver driver;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;
    HomePage homePage;
    ProfilePage profilePage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "/Users/nastia/Documents/workspace_2/Drivers/chromedriver-2.27");
        driver = new ChromeDriver(options);
        loginPage1 = new LoginPage1(driver);
        loginPage2 = new LoginPage2(driver);
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    //loads page using data provider
    @Test(dataProvider = "pages", dataProviderClass = Pages.class, groups = {"p1", "p2", "win.smoke", "regression"})
    public void loadPage(String url, String title) {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }

    //login tests with valid credentials
    @Test(dataProvider = "logindataPositive", dataProviderClass = LoginData.class, dependsOnMethods = "loadPage", groups = {"p2", "win.smoke", "regression"})
    public void loginPositive(String skypeId, String password, String title) throws InterruptedException {
        //loginPage1.isEmailFieldVisible();
        loginPage1.populateEmail(skypeId);
        loginPage2.populatePassField(password);
        loginPage2.clickSigninBtn2();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), title);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".shellSplashContent")));
        homePage.clickDisplayName();
        profilePage.signout();
    }

    @Test(groups = {"p2", "win.smoke", "broken"})
    public void testMethod1() {
        System.out.println("test method1");
    }

    @Test(groups = {"p2", "linux.smoke"})
    public void testMethod2() {
        System.out.println("test method2");
    }

    @Test(groups = "simpletest")
    public void testMethod3() {
        System.out.println("test method3");
    }

    @Test(groups = "simpletest")
    public void testMethod4() {
        System.out.println("test method4");
    }

//    @Test(dataProvider = "logindata", dataProviderClass = LoginData.class)
//    public void loginInvalidPass(String skypeId, String password) throws InterruptedException {
//        //loginPage1.isEmailFieldVisible();
//        loginPage1.populateEmail(skypeId);
//        loginPage2.populatePassField(password);
//        loginPage2.clickSigninBtn2Inv();
//    }

}


