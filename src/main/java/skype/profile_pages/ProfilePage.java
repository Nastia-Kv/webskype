package skype.profile_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import skype.BasePage;

import static utils.Timeouts.DEFAULT_WAIT_SECONDS;

/**
 * Created by nastia on 2/26/17.
 */
public class ProfilePage extends BasePage {
    @FindBy(css = "chevronDown.Me-availabilityChevron") WebElement dropdown;
    @FindBy(xpath = "//span[contains(text(), 'Sign out')]") WebElement signoutBtn;
    @FindBy(css = ".iconfont.chevronUp") WebElement returnToHomeBtn;
    @FindBy(xpath = "//span[.='Manage account']") WebElement manageAccountLink;
    @FindBy(xpath = "//title[contains(text(), 'Skype')]") WebElement title;
    @FindBy(css = ".Me-moodMessage-editButton.iconfont.edit") WebElement editActivityMsgBtn;
    @FindBy(css = ".Me-moodMessage-editMoodContainer--input") WebElement editMoodContainer;
    @FindBy(css = ".Me-moodMessage-editMoodContainer--button.iconfont.ok") WebElement okBtn;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

//    public void selectPresence(){
//        click(dropdown);
//        driver.findElement(By.cssSelector(""));
//    }

    public void returnToHome() throws InterruptedException {
//        isVisibleWithTryCatch(returnToHomeBtn, 60);
        if (!isVisibleWithTryCatch(returnToHomeBtn, 60))
            throw new RuntimeException("666");
        //waitForElementToBeDisplayed(returnToHomeBtn);
        //isVisible(returnToHomeBtn, 30);
        Actions actions = new Actions(driver);
        actions.moveToElement(returnToHomeBtn).click().perform();
    }

    public void clickManageAccount(){
        click(manageAccountLink);
    }

    public void editMoodMessage(){
        waitForElementToBeDisplayed(editActivityMsgBtn);
        click(editActivityMsgBtn);
        editMoodContainer.clear();
        editMoodContainer.sendKeys("What a wonderful life");
        click(okBtn);
    }

    public void signout(){
        waitForElementToBeDisplayed(signoutBtn);
        click(signoutBtn);
    }



}
