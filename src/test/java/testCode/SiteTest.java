package testCode;

import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.business.*;
import pageObjects.enums.*;
import testCode.testData.*;
import static com.epam.jdi.uitests.web.selenium.elements.composite.WebPage.getTitle;
import static pageObjects.pages.TestedEpamSite.*;

public class SiteTest extends TestBase
{
    // 1) Тест для логина
    @Test(enabled = true, dataProviderClass = FalseLoginTestData.class, dataProvider = "LoginTest", groups = "LoginCheck")
    public void checkingLoginFalseTest(User user)
    {
        homePage.loginForm.logining(user);
        Assert.assertTrue(homePage.loginForm.loginFaild.isDisplayed());
    }

    // 2) Тест для ОК логина
    @Test(enabled = true, dataProviderClass = SuccessLoginTestData.class, dataProvider = "LoginTest", groups = "LoginCheck")
    public void checkingLoginSuccessTest(User user)
    {
        homePage.loginForm.successLogin(user);
        Assert.assertTrue(homePage.loginForm.logoutButton.isDisplayed());
    }

    // 3) Тест навигации по главному меню
    @Test(enabled = true, dataProviderClass = CheckingMenuData.class, dataProvider = "CheckingMenuTest", groups = "NavigationCheck")
    public void checkingMenu(SiteMenu siteMenu, Titles titles)
    {
        menu.select(siteMenu);
        Assert.areEquals(getTitle(), titles.value);
    }

    // 4) Тест навигации по меню сервиса
    @Test(enabled = true, dataProviderClass = CheckingSubMenuData.class, dataProvider = "CheckingSubMenuTest", groups = "NavigationCheck")
    public void checkingSubMenu(SubMenu subMenuElement, Titles titles)
    {
        menu.select(SiteMenu.SERVICE, subMenuElement);
        Assert.areEquals(getTitle(), titles.value);
    }

    // 5) Тест для поисковой строки сверху
    @Test(enabled = true, dataProviderClass = SearchData.class, dataProvider = "SearchTest", groups = "NavigationCheck")
    public void checkingSearch(String text)
    {
        openSearchBar.click();
        searchBar.searchByStringText(text);
        Assert.areEquals(getTitle(), Titles.SUPPORT.value);
    }

    // 6) Тест для проверкии ContactForm
    @Test(enabled = true, dataProviderClass = ContactData.class, dataProvider = "ContactFormTest", groups = "PageElementsCheck")
    public void checkingContactForm(Contact contact)
    {
        contactFormPage.contactForm.inputContactData(contact);
        Assertion.checkContactFormResult(contact);
    }

    // 7) Тест для страницы Different Elements
    @Test(enabled = true, dataProviderClass = DifferentElementsData.class, dataProvider = "DifferentElementsTest", groups = "PageElementsCheck")
    public void checkingDifferentElementsForm(DifferentElement differentElement)
    {
        differentElementPage.differentElementForm.selectDifferentElements(differentElement);
        Assertion.checkDifferentElementSelection(differentElement);
    }

    // 8) Тест для страницы Metals and Colors
    @Test(enabled = true, dataProviderClass = MetalAndColorsData.class, dataProvider = "MetalAndColorsTest", groups = "PageElementsCheck")
    public void checkingMetalAndColorsForm(Plate plate)
    {
        metalAndColorsPage.componentForm.selectElements(plate);
        Assertion.checkMetalAndColorsComponentFormResult(plate);
    }

    // 9) Тест навигации на странице Metals and Colors, Contact Form
    @Test(enabled = true, groups = "NavigationCheck")
    public void checkingSiteNavigation()
    {
        metalAndColorsPage.open();
        metalAndColorsPage.navigation.next(); //переход вправо
        Assert.areEquals(getTitle(), Titles.METALS_COLORS.value);
        metalAndColorsPage.navigation.previous();//переход влево
        Assert.areEquals(getTitle(), Titles.DIFFERENT_ELEMENTS.value);
        metalAndColorsPage.navigation.first();//переход на первую страницу
        Assert.areEquals(getTitle(), Titles.CONTACT_FORM.value);
        metalAndColorsPage.navigation.last();//попытка перехода с последней страницы на страницу "Last"
        Assert.areEquals(getTitle(), Titles.METALS_COLORS.value);
        contactFormPage.open();
        contactFormPage.navigation.first();//попытка перехода с первой страницы на страницу "First"
        Assert.areEquals(getTitle(), Titles.CONTACT_FORM.value);
    }

    // 10) Тест страницы Dates
    @Test(enabled = true, dataProviderClass = DatesInputData.class, dataProvider = "DatesPageTest", groups = "PageElementsCheck")
    public void checkingDatesPage(DatesInput datesInput)
    {
        datesPage.datesPageForm.inputDataOnPage(datesInput);
        Assertion.checkDatesPageResult(datesInput);
    }

    //11) Тест страницы Complex Table
    @Test(enabled = true, dataProviderClass = CheckingComplexTableData.class, dataProvider = "CheckingComplexTableTest", groups = "PageElementsCheck")
    public void checkingComplexTable(TableColumns tableColumns)
    {
        complexTablePage.complexPageForm.selectColumn(tableColumns);
        Assert.assertTrue(complexTablePage.complexPageForm.complexTable.header(tableColumns.value).isDisplayed());
    }
}