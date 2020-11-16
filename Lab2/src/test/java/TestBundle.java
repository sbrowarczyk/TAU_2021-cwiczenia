import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestBundle {


    @org.testng.annotations.Test
    public void Cyberpunk2077ChromeTest() throws InterruptedException {

        TestsScenarios.cyberpunkTestScenario(Utils.getChromeDriver(), "Chrome");
    }

    @org.testng.annotations.Test
    public void Cyberpunk2077FirefoxTest() throws InterruptedException {
        TestsScenarios.cyberpunkTestScenario(Utils.getFirefoxDriver(), "Firefox");
    }

    @org.testng.annotations.Test
    public void Cyberpunk2077OperaTest() throws InterruptedException {
        TestsScenarios.cyberpunkTestScenario(Utils.getOperaDriver(), "Opera");
    }

    @org.testng.annotations.Test
    public void EobuwieChromeTest() {
        TestsScenarios.eobuwieTestScenario(Utils.getChromeDriver(), "Chrome");
    }

    @org.testng.annotations.Test
    public void EobuwieFirefoxTest() {
        TestsScenarios.eobuwieTestScenario(Utils.getFirefoxDriver(), "Firefox");
    }

    @org.testng.annotations.Test
    public void EobuwieOperaTest() {
        TestsScenarios.eobuwieTestScenario(Utils.getOperaDriver(), "Opera");
    }


}
