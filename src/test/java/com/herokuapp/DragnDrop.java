package com.herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragnDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void selenideWikiPage() {
        // Open 'The Internet'
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Wait so to see changes
        sleep(4000);
        // Drag element A to element B space
        $("#column-a").dragAndDropTo("#column-b");
        // Check that elements have truly changed their spaces
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

        // Wait so to see changes
        sleep(4000);
        // Drag element B to element A space (This method doesn't work)
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        // Check that no changes has happened
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));



    }
}

