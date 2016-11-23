package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import pageObjects.LoginForm;


public class HomePage extends WebPage
{

    @FindBy(css = "li.dropdown.uui-profile-menu")
    public LoginForm loginForm;

}
