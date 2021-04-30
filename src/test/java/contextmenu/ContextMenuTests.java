package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu(){
        ContextMenuPage contextMenuPage = homePage.clickContextMenuLink();
        contextMenuPage.moveToContextMenuZone();
        contextMenuPage.acceptAlert();
    }
}
