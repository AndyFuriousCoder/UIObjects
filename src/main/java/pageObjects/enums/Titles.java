package pageObjects.enums;

public enum Titles
{
    HOME("Index Page"), CONTACT_FORM("Contact Form"), METALS_COLORS("Metal and Colors"), SUPPORT("Support"), DATES("Dates"), COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"), TABLE_WITH_PAGES("Table with pages"), DIFFERENT_ELEMENTS("Different Element");

    public String value;

    Titles(String value) {
        this.value = value;
    }
}
