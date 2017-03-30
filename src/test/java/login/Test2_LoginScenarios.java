package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static utils.Timeouts.DEFAULT_WAIT_SECONDS;

/**
 * Created by nastia on 2/26/17.
 */
public class Test2_LoginScenarios {
    public WebDriver driver;
    LoginPage1 loginPage1;
    LoginPage2 loginPage2;
    HomePage homePage;

    @BeforeTest(alwaysRun = true)
    private void setup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "Users/nastia/IdeaProjects/webskype/chromedriver-2.27");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS);
        loginPage1 = new LoginPage1(driver);
        loginPage2 = new LoginPage2(driver);
        homePage = new HomePage(driver);

    }

    @AfterTest(alwaysRun = true)
    private void teardown(){
        driver.quit();

 }
    //login with valid credentials
    @Test
    private void loginPositive() throws InterruptedException {
        loginPage1.loadPage();
        loginPage1.populateEmail("kvas.test_8");
        loginPage2.populatePassField("123Cat123");
        loginPage2.clickSigninBtn2();
    }
    //login with valid username and invalid password
    @Test
    private void loginInvalidPass() throws InterruptedException {
        loginPage1.loadPage();
        loginPage1.populateEmail("kvas.test_8");
        loginPage2.populatePassField("123");
        loginPage2.clickSigninBtn2Inv();

    }

    //login with invalid username
    @Test
    private void loginInvalidEmail(){
        loginPage1.loadPage();
        loginPage1.populateEmailInvalid("kvas.test_8889");
    }


}
