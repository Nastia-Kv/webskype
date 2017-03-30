package skype;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static utils.Timeouts.DEFAULT_WAIT_SECONDS;


/**
 * Created by nastia on 2/26/17.
 */
public class BasePage {
    public String PAGE_URL;
    public String PAGE_TITLE;
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    //basic methods
    public void loadPage() {
        driver.get(getPageUrl());
        Assert.assertEquals(driver.getTitle(), PAGE_TITLE);

    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void setElementText(WebElement element, String text) {
        //element.clear();
        element.sendKeys(text);
    }

    //waits
    //webDriver wait with custom condition


    public boolean isVisible(WebElement element, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
//        if (webDriverWait.until(isElementVisibleCustom2(element))) {
//            System.out.println("Element " + element + "  is visible after " + seconds + "seconds");
//            return true;
//        } else {
//            System.out.println("Element " + element + "  is not visible after " + seconds + "seconds");
//            return false;
//        }
        try {
            //webDriverWait.until(isElementVisibleCustom2(element));
            webDriverWait.until(isElementVisibleCustom2(element));
            return true;
//            System.out.println("Element " + element + "  is visible after " + seconds + "seconds");
        } catch (TimeoutException e) {
            System.out.println("Element " + element + "  is not visible after " + seconds + "seconds");
        }
        return false;
//        return webDriverWait.until(isElementVisibleCustom2(element));
    }

    //custom condition
    public static ExpectedCondition<Boolean> isElementVisibleCustom2(WebElement element) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }

            @Override
            public String toString() {
                return "element to be visible";
            }
        };
    }

    public static ExpectedCondition<Boolean> elementNotVisibleCustom(WebElement element) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return !element.isDisplayed();
            }

            @Override
            public String toString() {
                return "element to be visible";
            }
        };
    }

    public boolean isVisibleWithTryCatch(WebElement element, int miliseconds) throws InterruptedException {
          driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  //case1
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  //case2
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //case3
//        driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);  //case4


//         wait logic while loop (test)
        System.out.println("loop start");
        long start = System.currentTimeMillis();
        long end = start + miliseconds; // 1000 ms/sec
        while (System.currentTimeMillis() < end) {
            try {
                if (element.isDisplayed()) {
                    System.out.println(element + " element is displayed");
                    //break; or
                    return true;
                } else {
//                    System.out.println("Element present but not visible");
                }
            } catch (NoSuchElementException e) {
                System.out.println("NO element in DOM");
            }
        }
        System.out.println("Time  " + (System.currentTimeMillis() - start));
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS);
        return false;
    }

    public void waitForElementToBeDisplayed2(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        element = webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeDisplayed(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 80);
        element = webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


}
