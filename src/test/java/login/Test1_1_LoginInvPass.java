package login;

import data.LoginData;
import data.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;
import skype.login_pages.MSSigninPage;
import skype.profile_pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nastia on 3/19/17.
 */
public class Test1_1_LoginInvPass {
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
        System.setProperty("webdriver.chrome.driver", "Users/nastia/IdeaProjects/webskype/chromedriver-2.27");
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
    @Test(dataProvider = "pages", dataProviderClass = Pages.class)
    public void loadPage(String url, String title) {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }

    //login with invalid password
    @Test(dataProvider = "logindataInvPass", dataProviderClass = LoginData.class)
    public void loginInvalidPass(String skypeId, String password, String error) throws InterruptedException {
        loginPage1.populateEmail(skypeId);
        loginPage2.populatePassField(password);
        loginPage2.clickSigninBtn2Inv2();
        String passError = driver.findElement(By.xpath("//div[contains(text(), 'Your account or password is incorrect.')]")).getText();
        Assert.assertEquals(passError, error);
        System.out.println(passError);
        Thread.sleep(1000);
        driver.navigate().back();
        driver.navigate().back();

    }
}
