package data;

import org.testng.annotations.DataProvider;

/**
 * Created by nastia on 2/26/17.
 */

// Args: URL, PAGE TITLE
public class Pages {
    @DataProvider(name = "pages")
    public static Object[][] pagesData(){
        return new Object[][]{
                {"https://web.skype.com/", "Sign into your Skype account"}
        };
    }
}
