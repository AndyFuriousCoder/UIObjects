package pageObjects.composite;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.User;

import static com.epam.web.matcher.testng.Assert.assertTrue;
import static pageObjects.pages.TestedEpamSite.homePage;

public class LoginForm extends Form<User>
{
    @FindBy(id = "Login")
    public TextField login;

    @FindBy(id = "Password")
    public TextField password;

    @FindBy(xpath = "//button[@type='submit']")
    public Button loginButton;

    @FindBy(css = ".logout")
    public Button logoutButton;

    @FindBy(css = "span.login-txt")
    public TextField loginFaild;

    @FindBy(css = "li.dropdown.uui-profile-menu > a.dropdown-toggle")
    public Button loginFormOpenButton;

    @FindBy(css = "div.profile-photo i.fa.fa-user")
    public Button profilePhoto;

    @FindBy(css = "a.dropdown-toggle div.profile-photo span")
    public Button piterChailovsky;

    public void isInState()
    {
        homePage.isOpened();
        homePage.checkOpened();
        if(profilePhoto.isDisplayed())
        {
            homePage.loginForm.loginFormOpenButton.click();
            homePage.loginForm.submitLogin();
        }

    }
    public void moveToState()
    {
        homePage.open();
        homePage.checkOpened();
        homePage.loginForm.loginFormOpenButton.click();
        homePage.loginForm.submitLogin();
        homePage.loginForm.loginFormOpenButton.click();
    }

    public void submit(String loginText, String passwordText)
    {
        login.newInput(loginText);
        password.newInput(passwordText);
        loginButton.click();
    }

    public void submitLogin()
    {
        submit("epam", "1234");
    }

    public void logining(User user)
    {
        loginFormOpenButton.click();
        if(logoutButton.isDisplayed())
        {
            logoutButton.click();
            loginFormOpenButton.click();
        }
        if(loginButton.isDisplayed()) submit(user.name, user.password);
        else
        {
            loginFormOpenButton.click();
            submit(user.name, user.password);
        }

    }

    public void successLogin(User user)
    {
        homePage.isOpened();
        if(!(piterChailovsky.isDisplayed())) homePage.loginForm.login(user);
        else loginFormOpenButton.click();
    }
}
