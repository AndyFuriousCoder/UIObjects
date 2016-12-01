package testCode;

import org.testng.annotations.Test;
import pageObjects.business.*;
import pageObjects.enums.*;
import testCode.testData.*;

import static pageObjects.pages.TestedEpamSite.*;


public class SiteTest extends TestBase
{
    // 1) Тест для логина
    @Test(enabled = true, dataProviderClass = LoginTestData.class, dataProvider = "LoginTest")
    public void checkingLoginTest(User user)
    {
        homePage.open();
        homePage.loginForm.loginOut();
        homePage.loginForm.login(user);
        homePage.loginForm.checkingLoginResult(user);
        homePage.loginForm.submitLogin();
    }

    // 2) Тест навигации по главному меню
    @Test(enabled = true, dataProviderClass = CheckingMenuData.class, dataProvider = "CheckingMenuTest")
    public void checkingMenu(SiteMenu siteMenu, Titles titles)
    {
        menu.select(siteMenu);
        checkSelectedPageTitle(titles);
    }

    // 3) Тест навигации по меню сервиса
    @Test(enabled = true, dataProviderClass = CheckingSubMenuData.class, dataProvider = "CheckingSubMenuTest")
    public void checkingSubMenu(SubMenu subMenuElement, Titles titles)
    {
        menu.select(SiteMenu.SERVICE);
        subMenu.select(subMenuElement);
        checkSelectedPageTitle(titles);
    }

    // 4) Тест для поисковой строки сверху
    @Test(enabled = true, dataProviderClass = SearchData.class, dataProvider = "SearchTest")
    public void checkingSearch(String text)
    {
        openSearchBar.click();
        searchBar.searchByStringText(text);
        searchBar.checkSearchResult();
    }

    // 5) Тест для проверкии ContactForm
    @Test(enabled = true, dataProviderClass = ContactData.class, dataProvider = "ContactFormTest")
    public void checkingContactForm(Contact contact)
    {
        contactFormPage.open();
        contactFormPage.contactForm.inputContactData(contact);
        contactFormPage.contactForm.checkResult(contact);
    }

    // 6) Тест для страницы Different Elements
    @Test(enabled = true, dataProviderClass = DifferentElementsData.class, dataProvider = "DifferentElementsTest")
    public void checkingDifferentElementsForm(DifferentElement differentElement)
    {
        differentElementPage.open();
        differentElementPage.differentElementForm.selectDifferentElements(differentElement);
        differentElementPage.differentElementForm.checkDifferentElementSelection(differentElement);
    }

    // 7) Тест для страницы Metals and Colors
    @Test(enabled = true, dataProviderClass = MetalAndColorsData.class, dataProvider = "MetalAndColorsTest")
    public void checkingMetalAndColorsForm(Plate plate)
    {
        metalAndColorsPage.open();
        metalAndColorsPage.componentForm.selectElements(plate);
        metalAndColorsPage.componentForm.checkResult(plate);
    }

    // 8) Тест навигации на странице Metals and Colors, Contact Form
    @Test(enabled = true)
    public void checkingSiteNavigation()
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
    @Test(enabled = true, dataProviderClass = DatesInputData.class, dataProvider = "DatesPageTest")
    public void checkingDatesPage(DatesInput datesInput)
    {
        datesPage.open();
        datesPage.datesPageForm.inputDataOnPage(datesInput);
        datesPage.datesPageForm.checkResult(datesInput);

    }

    //10) Тест страницы Complex Table
    @Test(enabled = true, dataProviderClass = CheckingComplexTableData.class, dataProvider = "CheckingComplexTableTest")
    public void checkingComplexTable(TableColumns tableColumns)
    {
        complexTablePage.open();
        complexTablePage.complexPageForm.selectNothingColumns();
        complexTablePage.complexPageForm.selectColumn(tableColumns);
        complexTablePage.complexPageForm.checkColumnVisible(tableColumns);
    }

}
