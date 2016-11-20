package testCode;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Plate;
import static pageObjects.TestingEpamSite.*;


public class SiteTest extends TestBase
{

    @BeforeTest
    public void beforeTest() {
        homePage.isOpened();
        homePage.checkOpened();
        homePage.loginForm.loginFormOpenButton.click();
        homePage.loginForm.submitLogin();
    }

    //Тест для UI Objects
    @Test(enabled = false, dataProviderClass = MetalAndColorsData.class, dataProvider = "MetalAndColorsTest")
    public void checkingMetalAndColorsForm(Plate plate) {
        metalAndColors.open();
        metalAndColors.componentForm.submit(plate);
    }

    //Тест для поисковой строки сверху
    @Test(enabled = true, dataProviderClass = SearchData.class, dataProvider = "SearchTest")
    public void checkingSearch(String text)
    {
        openSearchBar.click();//открываем текстовое поле для ввода
        searchBar.search(text);//запрос поиска по строке text
    }

    // Тест навигации на странице 2
    @Test(enabled = true)
    public void checkingNavigation()
    {
        metalAndColors.open();
        metalAndColors.navigation.next(); //переход вправо
        metalAndColors.navigation.previous();//переход влево
        metalAndColors.navigation.first();//переход на первую страницу
        metalAndColors.navigation.last();//попытка перехода с последней страницы на страницу "Last"
        contactForm.open();
        contactForm.navigation.first();//попытка перехода с первой страницы на страницу "First"
    }


}
