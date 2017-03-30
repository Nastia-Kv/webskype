package skype.call_phones_pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import skype.BasePage;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * Created by nastia on 2/27/17.
 */
public class CallPhonesPage extends BasePage {

    public CallPhonesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".SkypeOutHeader-input") WebElement enterNumberField;
    @FindBy(css = ".SelectBox-header") WebElement chooseCountryDropdown;
    @FindBy(xpath = "//ul[@role='listbox']") WebElement listBox;

    @FindBy(xpath = "//ul[@role='listbox']") List<WebElement> listBox2;

    @FindBy(xpath = "//ul[@role='listbox']/li/span[@class='SelectBox-optionName']") WebElement countryOptions;
    @FindBy(css = ".SelectBox-options") WebElement optionsBox;
    @FindBy(css = ".SelectBox-optionName") WebElement optionName;
    @FindBy(xpath = "//div[@class='SelectBox-options']//ul[@role='listbox']/li[@role='option' and @title='Ukraine']") WebElement countryUkraine;
    @FindBy(xpath = "//div[@class='SelectBox-options']//ul[@role='listbox']/li[@role='option' and @title='Albania']") WebElement countryAlbania;
    @FindBy(css = ".btn.disabled.primary.circle") WebElement callBtnDisabled;
    @FindBy(xpath = "//button[@class='btn primary circle' and @title='Call']") WebElement callBtnEnabled;




    public void makeCall() throws InterruptedException {
        enterNumberField.sendKeys("0680077626");
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
//        webDriverWait.until(ExpectedConditions.stalenessOf(chooseCountryDropdown));
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".SelectBox-header")));

//
        if (!isVisibleWithTryCatch(chooseCountryDropdown, 1000000))
            throw new RuntimeException("runtime exception");
        Actions actions = new Actions(driver);
        actions.click(chooseCountryDropdown).perform();


//        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']"));
//        for (WebElement element : list){
//           // String countryName = element.findElement(By.xpath("//li[@class='SelectBox-option list-selectable']")).getText();
//            System.out.println(element.getText());
//        }

        //or

        for (WebElement element : listBox2){
            System.out.println(element.getText());
        }

        for (WebElement element : listBox2){
            click(countryUkraine);
        }

        click(callBtnEnabled);






















//
//        //Thread.sleep(3000);
//        actions.click(countryAlbania).build().perform();
//        //Thread.sleep(1000);
//        click(callBtnEnabled);


    }

//    List<WebElement> contacts = driver.findElements(By.cssSelector("swx-recent-item.list-selectable"));
//    for (WebElement contact : contacts){
//        String contactName = contact.findElement(By.cssSelector("span.topic")).getText();
//        String notification = contact.findElement(By.cssSelector("p.fontSize-h4")).getText();
//        System.out.println(contactName + "- " + notification);
//
//
//    }

}
