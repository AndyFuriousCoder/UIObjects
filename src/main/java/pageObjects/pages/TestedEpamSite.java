package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.support.FindBy;
import pageObjects.SearchBar;
import pageObjects.enums.SiteMenu;
import pageObjects.enums.SubMenu;
import pageObjects.enums.Titles;

import static com.epam.jdi.uitests.web.selenium.elements.composite.WebPage.getTitle;

@JSite(domain = "https://jdi-framework.github.io/tests")
public class TestedEpamSite extends WebSite
{

    @FindBy(css = " div.uui-header.dark-gray nav ul.uui-navigation.nav.navbar-nav.m-l8")
    public static Menu<SiteMenu> menu;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li.dropdown.open ul.dropdown-menu")
    public static Menu<SubMenu> subMenu;

    @FindBy (css = "span.icon-search")
    public static Button openSearchBar;

    @FindBy(css = "div.search-active")
    public static SearchBar searchBar;

    @JPage(url = "/index.htm", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/page1.htm", title = "Contact Form")
    public static ContactFormPage contactFormPage;

    @JPage (url = "/page2.htm", title = "Metal and Colors")
    public static MetalAndColorsPage metalAndColorsPage;

    @JPage (url = "/page3.htm", title = "Support")
    public static SupportPage supportPage;

    @JPage (url = "/page4.htm", title = "Dates")
    public static DatesPage datesPage;

    @JPage (url = "/page8.htm", title = "Different Element")
    public static DifferentElementPage differentElementPage;

    public static void checkSelectedPageTitle(Titles titles)
    {
        Assert.areEquals(getTitle(), titles.value);
    }


}
