package testCode;

import org.testng.annotations.DataProvider;
import pageObjects.Contact;
import pageObjects.Plate;
import pageObjects.enums.Even;
import pageObjects.enums.Odds;

public class ContactData
{
    @DataProvider(name = "ContactFormTest")
    public static Object[][] test1() {
        return new Object[][] {{new Contact("Elena", "Isinbaeva", "Olimpic Games Champion", Odds.THREE, Even.FOUR)},
                                {new Contact("Silvestr", "Stalone", "True man", Odds.FIVE, Even.TWO)},
                                {new Contact("Jim", "Carry", "Comedian", Odds.SEVEN, Even.SIX)},
                                {new Contact("Georgy", "Leps", "Singer", Odds.ONE, Even.EIGHT)},
                                {new Contact("Han", "Solo", "Fictional person", Odds.FIVE, Even.FOUR)}};
    }
}
