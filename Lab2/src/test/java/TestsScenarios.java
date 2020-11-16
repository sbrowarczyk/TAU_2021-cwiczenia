import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TestsScenarios {
    private static final Logger logger = Utils.getLogger();

    public static void cyberpunkTestScenario(WebDriver driver, String browser) throws InterruptedException {
        logger.info(browser + ": Początek testu procesu zakupowego Cyberpunka2077");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.cyberpunk.net/pl/pl");
        logger.info(browser + ": Wejście na stronę: " + driver.getCurrentUrl());
        driver.findElement(By.className("video-modal__close")).click();
        driver.findElement(By.className("btn-preorder")).click();
        driver.findElement(By.className("platform-standard-pc")).click();
        driver.findElement(By.className("version-standard-pc-retail")).click();
        driver.findElement(By.className("vendor-standard-pc-retail-empik")).click();
        logger.info(browser + ": Przejście przez etapy zamówienia. Wybranie opcji zakupu wersji pudełkowej na PC w Empiku");
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        logger.info(browser + ": Zmiana karty na stronę: " + driver.getCurrentUrl());
        driver.findElement(By.className("cookies-accept__close--button")).click();
        driver.findElement(By.className("ta-add-to-cart-btn")).click();
        logger.info(browser + ": Dodanie Cyberpunka do koszyka");
        TimeUnit.SECONDS.sleep(5);
        driver.get(driver.findElement(By.id("simple-dropdown4")).getAttribute("href"));
        driver.findElement(By.className("addToCartDayProduct")).click();
        logger.info(browser + ": Dodanie do koszyka pozycji z sekcji proponowane");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.className("proceedButton")).click();
        logger.info(browser + ": Potwierdzenie zakupu. Przejście na  " + driver.getCurrentUrl());
        driver.navigate().back();
        logger.info(browser + ": Powrót na : " + driver.getCurrentUrl());
        driver.findElement(By.className("removeProduct")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.className("removeProduct")).click();
        logger.info(browser + ": Usunięcie obydwóch pozycji z koszyka ");
        logger.info(browser + ": Koniec testu procesu zakupowego Cyberpunka2077 \n");


    }

    public static void eobuwieTestScenario(WebDriver driver, String browser) {
        logger.info(browser + ": Początek testu strony eobuwie.com ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.eobuwie.com.pl/");
        logger.info(browser + ": Wejście na stronę: " + driver.getCurrentUrl());
        driver.findElement(By.cssSelector("[data-testid=\"permission-popup-accept\"]"))
                .click();
        logger.info(browser + ": Akceptacja plików cookies");
        driver.findElement(By.className("header-content__search-wrapper"))
                .findElement(By.className("header-search__input"))
                .sendKeys("trampki");
        driver.findElement(By.className("header-content__search-wrapper"))
                .findElement(By.className("header-search__submit")).click();
        logger.info(browser + ": Wyszukanie \"trampki\" w wyszukiwarce");
        driver.findElement(By.linkText("Bordowy")).click();
        driver.findElement(By.linkText("Materiał")).click();
        logger.info(browser + ": Zaznaczenie opcji Bordowy i Materiał. Wybranie 2 elementu z listy produktów");
        driver.findElement(By.className("products-list"))
                .findElements(By.tagName("li"))
                .get(1).click();
        driver.findElement(By.className("add-to-cart")).click();
        driver.findElement(By.className("e-size-picker-popup__wrapper"))
                .findElements(By.className("e-size-picker-option__label"))
                .stream()
                .filter(webElement -> webElement.getText().equals("41"))
                .collect(Collectors.toList())
                .get(0).click();

        driver.findElement(By.className("precart-popup__actions"))
                .findElement(By.tagName("button")).click();
        logger.info(browser + ": Dodanie butów do koszyku, wybranie rozmiaru 41");
        driver.findElements(By.xpath("//li[@class='\n" +
                "            e-list-item\n" +
                "            e-mega-menu__item\n" +
                "        ']"))
                .stream()
                .filter(webElement -> webElement.getText().trim().toLowerCase().equals("akcesoria"))
                .findFirst()
                .get()
                .click();
        driver.findElement(By.linkText("Torby i plecaki sportowe")).click();
        driver.findElement(By.linkText("Czarny")).click();
        logger.info(browser + ": Przejście na " + driver.getCurrentUrl() + " . Wybranie opcji Czarny");
        driver.findElement(By.className("select2-selection__arrow")).click();
        driver.findElement(By.className("select2-results__options"))
                .findElements(By.tagName("li"))
                .get(3).click();
        logger.info(browser + ": Przejście na " + driver.getCurrentUrl() + " . Wybranie opcji Czarny");
        driver.findElement(By.className("products-list"))
                .findElements(By.tagName("li"))
                .get(3).click();
        logger.info(browser + ": Posortowanie po najświeszych produktach");
        driver.findElement(By.className("add-to-cart")).click();
        driver.findElement(By.className("precart-popup__actions"))
                .findElement(By.className("e-button--type-primary")).click();
        logger.info(browser + ": Dodanie plecaka do koszyka. Potwierdzenie zakupu. Przejście na  " + driver.getCurrentUrl());
        driver.findElement(By.cssSelector("[data-testid=\"cart-go-to-checkout-top-button\"]")).click();
        driver.navigate().back();
        logger.info(browser + ": Powrót na : " + driver.getCurrentUrl());
        driver.findElement(By.className("cart-item__remove")).click();
        driver.findElement(By.className("cart-item__remove")).click();
        logger.info(browser + ": Koniec testu strony eobuwie.com \n");

    }

}
