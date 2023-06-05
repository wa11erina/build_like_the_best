package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutions {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void selenideWikiPage() {
    // Open GitHub main page
    open("https://github.com/");
    // Open Solutions dropdown
    $("[aria-label='Global']").$(byText("Solutions")).hover();
    // Navigate to Enterprise
    $$("ul [aria-labelledby='solutions-for-heading']").first().$("a").click();
    $("h1").shouldHave(text("Build like the best"));


    }
}
