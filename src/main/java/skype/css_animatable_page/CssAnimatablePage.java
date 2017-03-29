package skype.css_animatable_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by nastia on 3/6/17.
 */
public class CssAnimatablePage {

    @FindBy(css = ".w3-btn.w3-margin-bottom") WebElement button_tryItYourself;

    public CssAnimatablePage(WebDriver driver) {
        String pageUrl = "http://www.w3schools.com/cssref/css_animatable.asp";
        String pageTitle = "CSS Animatable";
    }

    public void clickTryItYourself(){
        button_tryItYourself.click();
    }
}
