package skype.login_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import skype.BasePage;

import static utils.Timeouts.DEFAULT_WAIT_SECONDS;

/**
 * Created by nastia on 2/26/17.
 */
public class LoginPage1 extends BasePage {
    @FindBy(xpath = "//input[@id='username' or @id='i0116']") WebElement field_Email;
    //@FindBy(xpath = "//button[@id='signIn' or @id='idSIButton9']") WebElement signInBtn;
    @FindBy(xpath = "//*[@id='signIn' or @id='idSIButton9']") WebElement signInBtn;


    public LoginPage1(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Sign into your Skype account";
        this.PAGE_URL = "https://web.skype.com/";
    }

    public void populateEmail(String text) {
        waitForElementToBeDisplayed(field_Email);
        setElementText(field_Email, text);
        waitForElementToBeDisplayed(signInBtn);
        click(signInBtn);
    }

    public void populateEmailInvalid(String s) {
    }
}

