package testCode;

import org.testng.annotations.DataProvider;
import pageObjects.Plate;
import pageObjects.User;

public class LoginTestData
{

    @DataProvider(name = "LoginTest")
    public static Object[][] test1() {
        return new Object[][] {{new User("Fire", "1234", false)},
                                {new User("Piter", "Chailovsky", false)},
                                {new User("Login", "1234", false)},
                                {new User("epam", "123", false)}};
    }

}
