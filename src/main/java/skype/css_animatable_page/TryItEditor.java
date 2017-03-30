package skype.css_animatable_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by nastia on 3/6/17.
 */
public class TryItEditor {
    @FindBy(css  = ".w3-green.w3-hover-white.w3-hover-text-green") WebElement button_Run;
    @FindBy(css = "iframe[id=iframeResult]") WebElement iframeResult;
    @FindBy(xpath = "//body[@contenteditable=\"false\"]/p[1]") WebElement textInIframe;
    //@FindBy(xpath = "//body[@contenteditable=\"false\"]/p[1]") WebElement textInIframe;

    public TryItEditor(WebDriver driver) {
         String pageTitle = "Tryit Editor v3.3";

    }

    public void getTextFromRunBtn(){
        button_Run.getText();
    }

    public void getTextFromIframe(){
        textInIframe.getText();
        System.out.println(textInIframe.getText());
    }
}
