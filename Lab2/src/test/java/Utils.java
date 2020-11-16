import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;
import java.sql.Driver;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Utils {



    public static Logger getLogger() {
        FileHandler fh=null;
        Logger logger = Logger.getLogger(Utils.class.getName());
        logger.setUseParentHandlers(false);
        try {
            fh = new FileHandler("src/test/logs/logs.txt");
            fh.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] %3$s %n";

                @Override
                public synchronized String format(LogRecord record) {
                    return String.format(format,
                            new Date(record.getMillis()),
                            record.getLevel().getLocalizedName(),
                            record.getMessage() );


                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        return logger;
    }


    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    public static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        return new FirefoxDriver();
    }

    public static WebDriver getOperaDriver() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver");
        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
