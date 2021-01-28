import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideExampleTest {
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

    @Before
    public void setSystemProperty() {
        Configuration.reportsFolder = "test-result/reports";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("selenide.browser", "chrome");
    }

    @Test
    public void checkGoogleSearch() {

        open("http://google.com");
        getWebDriver().switchTo().frame(getWebDriver().findElement(byXpath("//iframe[contains(@src, 'consent.google.com')]")));
        $(By.xpath("//form //div[@role = 'button' and @id = 'introAgreeButton']")).pressEnter();
        $(By.name("q")).setValue("Selenide").pressEnter();
        $("div.g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org")
        );
    }

    @Test
    public void checkOnetIncorrectLoginDataMessage() {
        open("https://www.onet.pl/poczta");
        $(By.className("cmp-intro_acceptAll")).click();
        $(By.id("mailFormLogin")).setValue("123@tst.pl");
        $(By.id("mailFormPassword")).setValue("123");
        $(By.xpath("//input[@value='Zaloguj się']")).click();
        $(By.className("messageContent")).shouldHave(text("Niepoprawny e-mail lub hasło."));
    }
}
