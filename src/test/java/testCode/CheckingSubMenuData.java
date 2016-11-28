package testCode;

import org.testng.annotations.DataProvider;
import pageObjects.enums.SiteMenu;
import pageObjects.enums.SubMenu;
import pageObjects.enums.Titles;

public class CheckingSubMenuData
{
    @DataProvider(name = "CheckingSubMenuTest")
    public static Object[][] test1() {
        return new Object[][] {{SubMenu.SUPPORT, Titles.SUPPORT},
                                {SubMenu.DATES, Titles.DATES},
                                {SubMenu.COMPLEX_TABLE, Titles.COMPLEX_TABLE},
                                {SubMenu.SIMPLE_TABLE, Titles.SIMPLE_TABLE},
                                {SubMenu.TABLE_WITH_PAGES, Titles.TABLE_WITH_PAGES},
                                {SubMenu.DIFFERENT_ELEMENTS, Titles.DIFFERENT_ELEMENTS}};
    }
}
