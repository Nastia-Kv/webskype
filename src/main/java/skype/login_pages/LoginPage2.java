package skype.login_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import skype.BasePage;

import static utils.Timeouts.DEFAULT_WAIT_SECONDS;

/**
 * Created by nastia on 2/26/17.
 */
public class LoginPage2 extends BasePage {
    @FindBy(id = "i0118") WebElement field_Password;
    @FindBy(xpath = "//*[@id='signIn' or @id='idSIButton9']") WebElement signinbtn2;
    @FindBy(id = "idBtn_Back") WebElement backbtn;
    @FindBy(xpath = "//div[contains(text(), 'Your account or password is incorrect.')]") WebElement errorText;
    @FindBy(xpath = "//div[contains(text(), \"That Microsoft account doesn't exist. Enter a different account or\")]") WebElement errorEmail2;
    public LoginPage2(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Sign in to your Microsoft account";
    }

    public void populatePassField(String text) throws InterruptedException {
        //isVisibleWithTryCatch(field_Password, DEFAULT_WAIT_SECONDS);
        waitForElementToBeDisplayed(field_Password);
        setElementText(field_Password, text);
    }

    public void clickSigninBtn2() {
        waitForElementToBeDisplayed(signinbtn2);
        click(signinbtn2);
    }


    public void clickSigninBtn2Inv() {
        waitForElementToBeDisplayed(signinbtn2);
        click(signinbtn2);
        Assert.assertEquals(errorText.getText(), "Your account or password is incorrect. If you don't remember your password, reset it now.");
    }

    //method to use is case of data providers
    public void clickSigninBtn2Inv2() {
        waitForElementToBeDisplayed(signinbtn2);
        click(signinbtn2);
        waitForElementToBeDisplayed(errorText);
    }


    public void clickBackBtn(){
        click(backbtn);
    }

}

