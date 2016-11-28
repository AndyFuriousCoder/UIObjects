package pageObjects.enums;


public enum SiteMenu {
    HOME("HOME"), CONTACT_FORM("CONTACT FORM"), SERVICE("SERVICE"), METALS_COLORS("METALS & COLORS");

    public String value;

    SiteMenu(String value)
    {
        this.value = value;
    }
}
