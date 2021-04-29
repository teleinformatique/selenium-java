package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {
    @Test
    public void TestHoverUser1(){
        HoversPage hoverPage = homePage.clickHovers();
        HoversPage.FigureCaption caption = hoverPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplay(),"Caption is not displayed");
        assertEquals(caption.getTitle(),"name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
