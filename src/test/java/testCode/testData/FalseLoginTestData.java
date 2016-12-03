package testCode.testData;

import org.testng.annotations.DataProvider;
import pageObjects.business.User;

public class FalseLoginTestData
{

    @DataProvider(name = "LoginTest")
    public static Object[][] test1() {
        return new Object[][] {{new User("Fire", "1234")},
                                {new User("Piter", "Chailovsky")},
                                {new User("Login", "1234")},
                                {new User("epam", "123")}};
    }

}
