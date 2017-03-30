package skype.chat_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import skype.BasePage;

/**
 * Created by nastia on 3/5/17.
 */
public class ChatPage extends BasePage {

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.contactRequestSend") WebElement addToContactsBtn;

    @FindBy(xpath = "//*[@id='chatInputContainer']/textarea[@id='chatInputAreaWithQuotes']") WebElement imArea;
    @FindBy(css = "textarea#chatInputAreaWithQuotes") WebElement imArea2;
    @FindBy(css = "textarea#chatInputAreaWithQuotes.inputField.fontSize-p") WebElement imArea3;
    @FindBy(css = ".history.scrollViewport-inner") WebElement historyArea;

    @FindBy(xpath = "//button[@title='Send']") WebElement sendBtn;


    public void clickAddToContactsBtn(){
        Actions actions = new Actions(driver);
        actions.moveToElement(addToContactsBtn).click().build().perform();
        System.out.println("Contact request is sent");
    }

    public void clickImArea(){
        Actions actions = new Actions(driver);
        actions.moveToElement(imArea2).click().build().perform();
    }

    public void sendMessage() throws InterruptedException {
        //isVisibleWithTryCatch(imArea2, 10);
        Actions actions = new Actions(driver);
        actions.moveToElement(imArea2).click().perform();
        imArea2.sendKeys("hi");
        //imArea2.sendKeys("hi");
    }


    public void populateIMarea(String text) throws InterruptedException {
        isVisibleWithTryCatch(imArea, 100000);
        Actions actions = new Actions(driver);
        actions.moveToElement(imArea).click().perform();
        imArea.sendKeys(text);
        System.out.println("populateIMArea method ");
    }

    public void sendMsg(String text) throws InterruptedException {
        WebDriverWait webdriverWait = new WebDriverWait(driver, 60, 2);
        webdriverWait.until(ExpectedConditions.visibilityOf(historyArea));

        Actions actions = new Actions(driver);
        actions.moveToElement(historyArea).click().perform();

        isVisibleWithTryCatch(imArea3, 60000);

        actions.moveToElement(imArea3).click().perform();
        imArea3.sendKeys(text);

    }

    public void send() throws InterruptedException {
        isVisibleWithTryCatch(sendBtn, 100000);
        click(sendBtn);
    }



}
