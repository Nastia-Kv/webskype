package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

/**
 * Created by nastia on 2/26/17.
 */
public class LoginData {

//    @Factory(dataProvider = "logindata")
//    public Object[][] createInstances(String skypeId, String password){
//        return new Object[][] {
//                (skypeId, password)
//        };
//    }
//
//    @DataProvider(name = "logindata")
//    public static Object[][] loginData(){
//        String[][] dataArray = {
//                {"kvas.test_8", "123Cat123"},
//                {"kvas.test_8", "123"},
//                {"kvas.test", ""}
//        };
//        return dataArray;
//    }

    @DataProvider(name = "logindataPositive")
    public static Object[][] loginDataPositive() {
        String[][] dataArray = {
                {"kvas.test_8", "123Cat123", "Skype"},
                {"zolotovoloska11.kvas11@outlook.com", "123Cat123", "Skype"},
        };
        return dataArray;
    }

    @DataProvider(name = "logindataInvPass")
    public static Object[][] loginDataInvPass() {
        String[][] dataArray = {
                {"kvas.test_8", "123", "Your account or password is incorrect. If you don't remember your password, reset it now."},
                {"zolotovoloska11.kvas11@outlook.com", "123", "Your account or password is incorrect. If you don't remember your password, reset it now."},
        };
        return dataArray;
    }

    @DataProvider(name = "logindataInvLogin")
    public static Object[][] loginDataInvLogin() {
        String[][] dataArray = {
                {"kvas.test_8212221", "That Microsoft account doesn't exist. Enter a different account or get a new one."},
                //{"zolotovoloska11.kvas11@ou4tlook.com", "That Microsoft account doesn't exist. Enter a different account or get a new one."},
        };
        return dataArray;
    }
}


