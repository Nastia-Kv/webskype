//package login;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Factory;
//
///**
// * Created by nastia on 2/26/17.
// */
//public class LoginData1 {
//
//    @Factory(dataProvider = "logindata")
//    public Object[] createInstances(String skypeId, String password){
//        return new Object[] {
//                new Test1_LoginPositive(skypeId, password)
//        };
//    }
//
//    @DataProvider(name = "logindata")
//    public static Object[][] loginData(){
//        Object[][] dataArray = {
//                {"kvas.test_8", "123Cat123"},
//                {"kvas.test_8", "123"},
//                {"kvas.test"}
//        };
//        return dataArray;
//    }
//}
//
//
