package testCode;

import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.enums.SiteMenu;
import pageObjects.enums.SubMenu;
import pageObjects.enums.Titles;
import static pageObjects.pages.TestedEpamSite.*;


public class SiteTest extends TestBase
{
    // 1) Тест для логина
    @Test(enabled = false, dataProviderClass = LoginTestData.class, dataProvider = "LoginTest")
    public void checkingLoginTest(User user)
    {
        homePage.loginForm.loginOut();
        homePage.loginForm.login(user);
        homePage.loginForm.checkingLoginResult(user);
    }

    // 2) Тест навигации по главному меню
    @Test(enabled = false, dataProviderClass = CheckingMenuData.class, dataProvider = "CheckingMenuTest")
    public void checkingMenu(SiteMenu siteMenu, Titles titles)
    {
        menu.select(siteMenu);
        checkSelectedPageTitle(titles);
    }

    // 3) Тест навигации по меню сервиса
    @Test(enabled = false, dataProviderClass = CheckingSubMenuData.class, dataProvider = "CheckingSubMenuTest")
    public void checkingSubMenu(SubMenu subMenuElement, Titles titles)
    {
        menu.select(SiteMenu.SERVICE);
        subMenu.select(subMenuElement);
        checkSelectedPageTitle(titles);
    }

    // 4) Тест для поисковой строки сверху
    @Test(enabled = false, dataProviderClass = SearchData.class, dataProvider = "SearchTest")
    public void checkingSearch(String text)
    {
        openSearchBar.click();
        searchBar.searchByStringText(text);
        searchBar.checkSearchResult();
    }

    // 5) Тест для проверкии ContactForm
    @Test(enabled = false, dataProviderClass = ContactData.class, dataProvider = "ContactFormTest")
    public void checkingContactForm(Contact contact)
    {
        contactFormPage.open();
        contactFormPage.contactForm.inputContactData(contact);
        contactFormPage.contactForm.checkResult(contact);
    }

    // 6) Тест для страницы Different Elements
    @Test(enabled = false, dataProviderClass = DifferentElementsData.class, dataProvider = "DifferentElementsTest")
    public void checkingDifferentElementsForm(DifferentElement differentElement)
    {
        differentElementPage.open();
        differentElementPage.differentElementForm.selectDifferentElements(differentElement);
        differentElementPage.differentElementForm.checkDifferentElementSelection(differentElement);
    }

    // 7) Тест для страницы Metals and Colors
    @Test(enabled = false, dataProviderClass = MetalAndColorsData.class, dataProvider = "MetalAndColorsTest")
    public void checkingMetalAndColorsForm(Plate plate) {
        metalAndColorsPage.open();
        metalAndColorsPage.componentForm.submit(plate);
        metalAndColorsPage.componentForm.checkResult(plate);
    }

    // 8) Тест навигации на странице Metals and Colors, Contact Form
    @Test(enabled = false)
    public void checkingNavigation()
    {
        metalAndColorsPage.open();
        metalAndColorsPage.navigation.next(); //переход вправо
        metalAndColorsPage.checkNext();
        metalAndColorsPage.navigation.previous();//переход влево
        metalAndColorsPage.checkPrevious();
        metalAndColorsPage.navigation.first();//переход на первую страницу
        metalAndColorsPage.checkFirst();
        metalAndColorsPage.navigation.last();//попытка перехода с последней страницы на страницу "Last"
        metalAndColorsPage.checkLast();
        contactFormPage.open();
        contactFormPage.navigation.first();//попытка перехода с первой страницы на страницу "First"
        contactFormPage.checkFirst();
    }

    // 9) Тест страницы Dates
    @Test(enabled = false, dataProviderClass = DatesInputData.class, dataProvider = "DatesPageTest")
    public void checkingDatesPage(DatesInput datesInput)
    {
        datesPage.open();
        datesPage.datesPageForm.inputDataOnPage(datesInput);
        datesPage.datesPageForm.checkResult(datesInput);

    }

}
