package pageObjects.composite;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.User;

import static com.epam.web.matcher.testng.Assert.assertTrue;

public class LoginForm extends Form<User>
{
    @FindBy(id = "Login")
    private TextField login;

    @FindBy(id = "Password")
    private TextField password;

    @FindBy(xpath = "//button[@type='submit']")
    private Button loginButton;

    @FindBy(css = ".logout")
    private Button logoutButton;

    @FindBy(css = "span.login-txt")
    private TextField loginFaild;

    @FindBy(css = "li.dropdown.uui-profile-menu > a.dropdown-toggle")
    public Button loginFormOpenButton;

    public void submit(String loginText, String passwordText)
    {
        login.newInput(loginText);
        password.newInput(passwordText);
        loginButton.click();
    }

    public void checkingLoginResult(User user)
    {
        if(user.loginResult)
        {
            assertTrue(logoutButton.isDisplayed());
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

    public void loginOut()
    {
        loginFormOpenButton.click();
        if(logoutButton.isDisplayed()) logoutButton.click();
        if(loginButton.isDisplayed()) loginFormOpenButton.click();
    }
}
