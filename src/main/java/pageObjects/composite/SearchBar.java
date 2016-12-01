package pageObjects.composite;


import com.epam.jdi.uitests.core.interfaces.complex.ISearch;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.support.FindBy;
import pageObjects.enums.Titles;

import static com.epam.jdi.uitests.web.selenium.elements.composite.WebPage.getTitle;
import static pageObjects.pages.TestedEpamSite.supportPage;

public class SearchBar extends Search implements ISearch
{
    @FindBy(css = "div.search-field > input[type=\"text\"]")
    public TextField searchText;

    @FindBy(css = "span.icon-search")
    public Button searchButton;

    public void searchByStringText(String text)
    {
        searchText.clear();
        searchText.input(text);
        searchButton.click();
    }

    public void checkSearchResult()
    {
        Assert.areEquals(getTitle(), Titles.SUPPORT.value);
    }
}
