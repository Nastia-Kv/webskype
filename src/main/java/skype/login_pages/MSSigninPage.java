package skype.login_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import skype.BasePage;

/**
 * Created by nastia on 3/19/17.
 */
public class MSSigninPage extends BasePage{
    @FindBy(xpath = "//div[@id='usernameError']") WebElement errorLogin;

    public MSSigninPage(WebDriver driver) {
        super(driver);
    }


    public void validateLoginError(String text) {
        Assert.assertEquals(errorLogin.getText(), text);
    }
}
