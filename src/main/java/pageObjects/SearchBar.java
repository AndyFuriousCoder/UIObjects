package pageObjects;


import com.epam.jdi.uitests.core.interfaces.complex.ISearch;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends Search implements ISearch
{
    @FindBy(css = "div.search-field > input[type=\"text\"]")
    public TextField searchText;

    @FindBy(css = "span.icon-search")
    public Button searchButton;

    public void search(String text)
    {
        searchText.clear();
        searchText.input(text);
        searchButton.click();
    }
}
