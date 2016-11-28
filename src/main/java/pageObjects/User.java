package pageObjects;

public class User
{

    public String login;
    public String password;
    public boolean loginResult;

    public User(String login, String password, boolean loginResult)
    {
        this.login = login;
        this.password = password;
        this.loginResult = loginResult;
    }
}
