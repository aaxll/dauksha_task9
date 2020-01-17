import listeners.WebDriverListener;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    // URLs
    String loginPageURL = "http://open-eshop.stqa.ru/oc-panel/auth/login/";
    String adminPanelURL = "http://open-eshop.stqa.ru/oc-panel";
    String couponsPageURL = "http://open-eshop.stqa.ru/oc-panel/coupon";

    // Admin credentials
    String adminEmail = "demo@open-eshop.com";
    String adminPassword = "demo";

    // Coupon data
    String couponNameField = "coupon32324";
    String couponDateField = "2021-01-03";
    String couponCountField = "3";

    protected static WebDriver driver;
    protected static LoginPage loginPage;
    protected static AdminPage adminPage;


    @BeforeEach
    public void setUp() {
        BasicConfigurator.configure();
        System.out.println("Starting a browser");
        System.setProperty("webdriver.chrome.driver", "C:/testing/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());
        driver = eventFiringWebDriver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);

    }

    @AfterEach
    public void tearDown() {
        System.out.println("Stopping the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
