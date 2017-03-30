package skype.home_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.SocketLock;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import skype.BasePage;

import static org.apache.commons.lang3.BooleanUtils.and;
import static utils.Timeouts.DEFAULT_WAIT_SECONDS;

/**
 * Created by nastia on 2/26/17.
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "swx-avatar.Me-avatar")
    WebElement displayName;

    @FindBy(css = "div.Me-small")
    WebElement nameArea;
    @FindBy(xpath = "//div[@class='swxMe']/swx-me-area/div[@class='Me']")
    WebElement nameArea2;
    @FindBy(xpath = ".//*[@id='meComponent']/div/swx-me-area/div/div")
    WebElement nameArea3;

    @FindBy(css = "span.iconfont.skypeAddressBook")
    WebElement contactsBtn;
    @FindBy(css = ".iconfont.dialpad")
    WebElement callPhonesBtn;
    @FindBy(css = "span.iconfont.settings")
    WebElement settingsBtn;

    @FindBy(xpath = "//div[@class='search beforeMenuItems']/swx-search-input/div[@class='input']")
    WebElement searchSkypeField;
    @FindBy(xpath = "//div[@class='search beforeMenuItems']/swx-search-input/div[@class='input active']")
    WebElement focusedSearchSkypeField;

    @FindBy(xpath = "//p[contains(text(),'People')]")
    WebElement separatorPeople;
    @FindBy(xpath = "//p[contains(text(),'Directory')]")
    WebElement separatorDirectory;

    @FindBy(xpath = "//div[@class='scrollViewport-inner']//ul[@class='directory']//p[.='No results found']")
    WebElement noResultsFoundDirectory;
    ////*[@class='separator']/p[.='Directory']/following::p[.='No results found']


    //@FindBy(xpath = "//div[@class='scrollViewport-inner']//ul[@class='people']//p[.='No results found']]")
    @FindBy(xpath = "//ul[@class='people']//p[.='No results found']")
    WebElement noResultsFoundPeople;

    @FindBy(xpath = "//button/span[.='Search Skype Directory']")
    WebElement searchSkypeDirectoryBtn;
    @FindBy(css = "button.btn.primary.searchDirectory.list-selectable")
    WebElement searchSkypeDirectoryBtn2;

    @FindBy(xpath = "//*[@class='separator']/p[.='Directory']/following::li[1]/*[@class='text']")
    WebElement newFoundContact;
    @FindBy(xpath = "//div[@class='scrollViewport-inner']//ul[@class='people']//li/span[@class='text']")
    WebElement existingFoundContact;
    @FindBy(xpath = "//div[@class='separator']/following-sibling::li[@class='list-selectable searchItem clearfix Avatar-whiteThemeHover']")
    WebElement newFoundContact2;

    @FindBy(xpath = "//button[@class='btn primary circle small transparent searchReset']/span[@class='iconfont cross']")
    WebElement clearSearchBtn;

    @FindBy(css = ".side.themeWhite.slideLeftToRight.inactive")
    WebElement side;


    ////div[@class='separator']/following-sibling::li/p[.='No results found']
    ////div[@class='separator']/p[.='Directory']/following-sibling::li/p[.='No results found']


    public void clickDisplayName() throws InterruptedException {
        if (!isVisibleWithTryCatch(nameArea2, 100000))
            throw new RuntimeException("666");
        //waitForElementToBeDisplayed(nameArea2);
        //isVisible(nameArea2, 60);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(nameArea2).click().perform();
        click(nameArea2);
        System.out.println("Clicked nameArea2");
    }

    public void clickContactsBtn() throws InterruptedException {
        if (!isVisibleWithTryCatch(contactsBtn, 1000000))
            throw new RuntimeException("runtime exception");
        //isElementVisibleCustom2(contactsBtn);
        //isVisible(contactsBtn, 30);
        //waitForElementToBeDisplayed(contactsBtn);
        click(contactsBtn);
    }

    public void clickCallPhonesBtn() throws InterruptedException {
        if (!isVisibleWithTryCatch(callPhonesBtn, 1000000))
            throw new RuntimeException("runtime exception");
        //waitForElementToBeDisplayed(callPhonesBtn);
        //isVisible(callPhonesBtn, 30);
        click(callPhonesBtn);
    }

    public void clickSettingsBtn() throws InterruptedException {
        isVisibleWithTryCatch(settingsBtn, 1000000);
        //waitForElementToBeDisplayed(settingsBtn);
        //isVisible(settingsBtn, 30);
        click(settingsBtn);
    }

    public void clickClearchSearchBtn() {
        Actions actions = new Actions(driver);
        actions.moveToElement(clearSearchBtn).click().build().perform();
    }

    public void clickNewFoundContact() {
        waitForElementToBeDisplayed(newFoundContact);
        click(newFoundContact);
    }

    public void clickExistingFoundContact() {
        click(existingFoundContact);
    }


    //searchForExistingNewContact
    public void searchForExistingNewContact(String text) throws InterruptedException {
        waitForElementToBeDisplayed(searchSkypeField);
        click(searchSkypeField);
        Actions actions = new Actions(driver);
        actions.moveToElement(focusedSearchSkypeField).click().sendKeys(text).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchSkypeDirectoryBtn2));
        actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();
        //webDriverWait.until(ExpectedConditions.visibilityOf(newFoundContact));
        Thread.sleep(4000);
        try {
            if (noResultsFoundPeople.isDisplayed() & newFoundContact.isDisplayed()) {
                webDriverWait.until(ExpectedConditions.visibilityOf(newFoundContact));
                {
                    System.out.println("New contact is found. You can add the contact to contact list");
                }
            }
        } catch (Exception e) {
            System.out.println("Contact is not new or it is non existing contact");
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(clearSearchBtn));
        actions.moveToElement(clearSearchBtn).click().build().perform();
        webDriverWait.until(elementNotVisibleCustom(clearSearchBtn));
        click(side);

//        try {
//            if ((existingFoundContact.isDisplayed() & (searchSkypeDirectoryBtn2.isDisplayed()))) {
//                actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();
//                //webDriverWait.until(ExpectedConditions.visibilityOf(noResultsFoundDirectory));
//                Thread.sleep(3000);
//                if (existingFoundContact.isDisplayed()) {
//                    System.out.println("This contact is in your contact list.");
//                }
//
//            }
//        } catch (Exception e) {
//            System.out.println("exception2");
//        }


//            }  else {
//                    if (noResultsFoundPeople.isDisplayed()& searchSkypeDirectoryBtn2.isDisplayed()) {
//                        actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();
//                    }
//                    if (noResultsFoundDirectory.isDisplayed()) {
//                        System.out.println("No results found. Please, refine your search");
//                    }
//                }
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("Exception");
//        }
//        Thread.sleep(3000);

//        click(newFoundContact);
//        click(side);

//
//        if (driver.findElement(By.xpath("//li[@class='grid container']/p[.='No results found']")).getText() == "No results found"){
//            click(searchSkypeDirectoryBtn);
//        }  else {
//            System.out.println("Contact is already in contact list");
//        }

//        try {
//            if (noResultsFound.getText() == "No results found"){
//                Thread.sleep(1000);
//                actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();
//            }  else {
//            System.out.println("Contact is already in contact list");
//            }
//        }catch (Exception e){
//            System.out.println("Exception");
//        }
    }

    public void searchForExistingNewContact2(String text) throws InterruptedException {
        waitForElementToBeDisplayed(searchSkypeField);
        click(searchSkypeField);
        Actions actions = new Actions(driver);
        actions.moveToElement(focusedSearchSkypeField).click().sendKeys(text).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchSkypeDirectoryBtn2));
        actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();
        //webDriverWait.until(ExpectedConditions.visibilityOf(newFoundContact));
        Thread.sleep(4000);
        try {
            if (noResultsFoundPeople.isDisplayed() & newFoundContact.isDisplayed()) {
                webDriverWait.until(ExpectedConditions.visibilityOf(newFoundContact));
                {
                    System.out.println("New contact is found. You can add the contact to contact list");
                }
            }
        } catch (Exception e) {
            System.out.println("Contact is not new or it is non existing contact");
        }
    }

    //searchForNonExistingNewContact
    public void searchForNonExistingNewContact(String text) throws InterruptedException {
        waitForElementToBeDisplayed(searchSkypeField);
        click(searchSkypeField);
        Actions actions = new Actions(driver);
        actions.moveToElement(focusedSearchSkypeField).click().sendKeys(text).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchSkypeDirectoryBtn2));
        actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();

        // webDriverWait.until(ExpectedConditions.visibilityOf(newFoundContact));

        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(noResultsFoundDirectory));
            if (noResultsFoundDirectory.isDisplayed() & noResultsFoundPeople.isDisplayed()) {

                System.out.println("No results found. Please, refine your search");
            }
        } catch (Exception e) {
            System.out.println("Contact is not non existing");
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(clearSearchBtn));
        actions.moveToElement(clearSearchBtn).click().build().perform();
        webDriverWait.until(elementNotVisibleCustom(clearSearchBtn));
        click(side);

    }


    public void searchForContactInContactList(String text) throws InterruptedException {
        waitForElementToBeDisplayed(searchSkypeField);
        click(searchSkypeField);
        Actions actions = new Actions(driver);
        actions.moveToElement(focusedSearchSkypeField).click().sendKeys(text).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchSkypeDirectoryBtn2));
        actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();

        try {
            if (existingFoundContact.isDisplayed()) {
                System.out.println("This contact is in your contact list.");
                //click(existingFoundContact);
            }
        } catch (Exception e) {
            System.out.println("This contact is not in your contact list or it is non existing contact");
        }

        webDriverWait.until(ExpectedConditions.visibilityOf(clearSearchBtn));
        actions.moveToElement(clearSearchBtn).click().build().perform();
        webDriverWait.until(elementNotVisibleCustom(clearSearchBtn));
        click(side);
    }

    public void searchForContactInContactList2(String text) throws InterruptedException {
        waitForElementToBeDisplayed(searchSkypeField);
        click(searchSkypeField);
        Actions actions = new Actions(driver);
        actions.moveToElement(focusedSearchSkypeField).click().sendKeys(text).build().perform();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchSkypeDirectoryBtn2));
        actions.moveToElement(searchSkypeDirectoryBtn2).click().build().perform();

        try {
            if (existingFoundContact.isDisplayed()) {
                System.out.println("This contact is in your contact list.");
                //click(existingFoundContact);
            }
        } catch (Exception e) {
            System.out.println("This contact is not in your contact list or it is non existing contact");
        }
        click(existingFoundContact);
    }


}
