package testCode;


import org.testng.annotations.DataProvider;
import pageObjects.Contact;
import pageObjects.enums.Even;
import pageObjects.enums.Odds;
import pageObjects.enums.SiteMenu;
import pageObjects.enums.Titles;

public class CheckingMenuData
{
    @DataProvider(name = "CheckingMenuTest")
    public static Object[][] test1() {
        return new Object[][] {{SiteMenu.METALS_COLORS, Titles.METALS_COLORS},
                                {SiteMenu.CONTACT_FORM, Titles.CONTACT_FORM},
                                {SiteMenu.HOME, Titles.HOME}};
    }
}
