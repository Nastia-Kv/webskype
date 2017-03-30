package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by nastia on 3/6/17.
 */
public class Windows {

    //public static WebDriver driver;

    public static void switchByName(String name, WebDriver driver) throws Exception {
        for (String windowHandle : driver.getWindowHandles()) {
            WebDriver window = driver.switchTo().window(windowHandle);
            if (window.getTitle().equals(name)) {
                return;
            }
        }
        throw new Exception("message");
    }

    public static void switchToParent(WebDriver driver){
        Set<String> windowHandle = driver.getWindowHandles();
        WebDriver parentWindow = driver.switchTo().defaultContent();
    }

    public static int winHandlesSize(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        int size = windowHandles.size();
        System.out.println(size);
        return size;
    }


}
