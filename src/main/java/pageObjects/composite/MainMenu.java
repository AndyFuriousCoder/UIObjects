package pageObjects.composite;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import pageObjects.enums.SiteMenu;
import pageObjects.enums.SubMenu;
import static pageObjects.pages.TestedEpamSite.subMenu;

public class MainMenu extends Menu<SiteMenu>
{
    public void select(SiteMenu siteMenu, SubMenu subMenuElement)
    {
        select(siteMenu.value);
        subMenu.select(subMenuElement.value);
    }
}
