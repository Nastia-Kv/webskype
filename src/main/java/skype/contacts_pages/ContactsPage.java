package skype.contacts_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import skype.BasePage;

import java.util.List;

import static utils.Timeouts.DEFAULT_WAIT_SECONDS;

/**
 * Created by nastia on 2/26/17.
 */
public class ContactsPage extends BasePage {

    @FindBy(xpath = "//a[.='Online']")
    WebElement onlineStatus;
    @FindBy(xpath = "//span[.='Echo / Sound Test Service']")
    WebElement soundTestService;
    @FindBy(xpath = "//div[@class='row separator swx-hide']/following-sibling::div[@class='row separator']//li")
    List<WebElement> allContacts;
    @FindBy(xpath = "//div[@class='row separator']/p[.='K']/following-sibling::div/li")
    List<WebElement> allKContacts;
    @FindBy(xpath = "//div[@class='row separator']/p[.='K']/following-sibling::div/li//span[@class='topic']")
    List<WebElement> namesKContacts;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnlineStatus() throws InterruptedException {
        isVisibleWithTryCatch(onlineStatus, 60);
        //isElementVisibleCustom2(onlineStatus);
        //isVisible(onlineStatus, 30);
        waitForElementToBeDisplayed(onlineStatus);
        click(onlineStatus);
    }

    public void clickSoundTestService() throws InterruptedException {
        isVisibleWithTryCatch(soundTestService, 60);
        //waitForElementToBeDisplayed(soundTestService);
        //isVisible(soundTestService, 30);
        click(soundTestService);
    }

    public int countAllContacts() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(soundTestService));
        int contactsNumber = 0;
        for (WebElement contact : allContacts) {
            contactsNumber += 1;
        }
        System.out.println(contactsNumber);
        return contactsNumber;
    }

    public void selectKContact() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(soundTestService));

        int n = 0;
        for (WebElement element : namesKContacts) {
            System.out.println(element.getText());
            n++;
            if (n==1){
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().build().perform();
                break;

            }
        }





    }
}
