package testCode.testData;


import org.testng.annotations.DataProvider;
import pageObjects.business.User;

public class SuccessLoginTestData
{
    @DataProvider(name = "LoginTest")
    public static Object[][] test1() {
        return new Object[][] {{new User("epam", "1234")}};
    }
}
