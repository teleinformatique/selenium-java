package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTests {

    @Test
    public void testWysiwyg(){
        WysiwygEditorPage wysiwygEditor = homePage.clickWysiwygEditor();
        String text1 = "Hello";
        String text2 = "world";
        wysiwygEditor.clearTextArea();
        wysiwygEditor.setTextArea(text1);
        wysiwygEditor.decreaseIndent();
        wysiwygEditor.setTextArea(text2);

        assertEquals(wysiwygEditor.getTextFromEditor(), text1+text2, "Text from editor incorrect");
    }
}
