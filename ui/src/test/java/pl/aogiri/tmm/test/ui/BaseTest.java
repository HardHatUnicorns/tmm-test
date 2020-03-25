package pl.aogiri.tmm.test.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.aogiri.tmm.test.ui.configuration.PropertiesFactory;
import pl.aogiri.tmm.test.ui.exception.InvalidPropertiesException;
import pl.aogiri.tmm.test.ui.exception.PropertiesNotFetchedException;
import pl.aogiri.tmm.test.ui.link.Link;

import static pl.aogiri.tmm.test.ui.configuration.ChromeDriverFactory.ChromeDriverFactory;

public abstract class BaseTest{

    protected static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected static ChromeDriver driver;
    protected static WebDriverWait wait;

    protected static String BASE_URL;


    @BeforeAll
    static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = ChromeDriverFactory()
                .setHeadless()
                .create()
                .prepare()
                .setUpDefaultValues()
                .create();
        wait = new WebDriverWait(driver, 5);

    }

    @BeforeAll
    static void setUpProperties() throws InvalidPropertiesException, PropertiesNotFetchedException {
        if(new PropertiesFactory().fetch()) {
            try {
                BASE_URL = PropertiesFactory.getBaseUrl();
            } catch (PropertiesNotFetchedException e) {
                throw new InvalidPropertiesException();
            }
        }
        else
            throw new PropertiesNotFetchedException();
    }

    @BeforeEach
    void setUp() throws PropertiesNotFetchedException {
        driver.get(Link.HOME.getFullLink());

    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
