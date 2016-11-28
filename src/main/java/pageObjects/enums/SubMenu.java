package pageObjects.enums;


public enum SubMenu
{
    SUPPORT("SUPPORT"), DATES("DATES"), COMPLEX_TABLE("COMPLEX TABLE"), SIMPLE_TABLE("SIMPLE TABLE"), TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    public String value;

    SubMenu(String value)
    {
        this.value = value;
    }
}
