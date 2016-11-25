package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.support.FindBy;
import pageObjects.SearchBar;
import pageObjects.pages.*;

@JSite(domain = "https://jdi-framework.github.io/tests")
public class TestingEpamSite extends WebSite
{

    @JPage(url = "/index.htm", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/page1.htm", title = "Contact Form")
    public static ContactForm contactForm;

    @JPage (url = "/page2.htm", title = "Metal and Colors")
    public static MetalAndColors metalAndColors;

    @JPage (url = "/page3.htm", title = "Support")
    public static SupportPage supportPage;

    @JPage (url = "/page8.htm", title = "Different Element")
    public static DifferentElement differentElement;

    @FindBy (css = "span.icon-search")
    public static Button openSearchBar;

    @FindBy(css = "div.search-active")
    public static SearchBar searchBar;

}
