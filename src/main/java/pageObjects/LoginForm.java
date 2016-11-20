package pageObjects;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

import static com.epam.web.matcher.testng.Assert.assertTrue;

public class LoginForm extends Form
{
    @FindBy(id = "Login")
    private TextField login;

    @FindBy(id = "Password")
    private TextField password;

    @FindBy(css = "li.dropdown.uui-profile-menu > a.dropdown-toggle")
    public Button loginFormOpenButton;

    @FindBy(xpath = "//button[@type='submit']")
    private Button loginButton;

    @FindBy(css = ".logout")
    private Button logoutButton;

    @FindBy(css = "span.login-txt")
    private TextField loginFaild;

    public void submit(String loginText, String passwordText)
    {
        login.newInput(loginText);
        password.newInput(passwordText);
        loginButton.click();
    }

    public void checkingAuthorize(boolean status, String loginText, String passwordText)
    {
        submit(loginText, passwordText);

        if(status)
        {
            assertTrue(logoutButton.isDisplayed());
            logoutButton.click();
        }
        else
        {
            assertTrue(loginFaild.isDisplayed());
        }
    }

    public void submitLogin()
    {
        submit("epam", "1234");
    }
}
