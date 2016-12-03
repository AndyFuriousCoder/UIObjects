package pageObjects.business;

public class User
{

    public String name;
    public String password;

    public User(String login, String password)
    {
        this.name = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User(" + name + ", " + password + ")";
    }
}
