package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projectStorage.StorageString;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @BeforeAll
    public static void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        TestBase.setDriver(driver);
        driver.get(StorageString.URL);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
