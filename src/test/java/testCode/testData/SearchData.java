package testCode.testData;


import org.testng.annotations.DataProvider;

public class SearchData
{
    @DataProvider(name = "SearchTest")
    public static Object[][] search1() {
        return new Object[][] {{"Support"},
                                {"TestNG"},
                                {"Allure"},
                                {"Selenium"},
                                {"Jenkins"}};
    }
}
