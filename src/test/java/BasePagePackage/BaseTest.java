package BasePagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import skype.contacts_pages.ContactsPage;
import skype.home_pages.HomePage;
import skype.login_pages.LoginPage1;
import skype.login_pages.LoginPage2;
import skype.profile_pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nastia on 3/23/17.
 */
public class BaseTest {
    public WebDriver driver;
    @BeforeClass(alwaysRun = true)
    private void setup() throws InterruptedException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "/Users/nastia/Documents/workspace_2/Drivers/chromedriver-2.27");
        driver = new ChromeDriver(options);

    }
}
