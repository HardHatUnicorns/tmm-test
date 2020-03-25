package pl.aogiri.tmm.test.ui.configuration;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverFactory {
    private static ChromeDriver driver;
    private static ChromeOptions options = new ChromeOptions();

    protected ChromeDriverFactory(){
    }

    public static ChromeOptionsFactory ChromeDriverFactory(){
        return new ChromeOptionsFactory(options);
    }

    public ChromeDriverFactory prepare(){
        driver = new ChromeDriver(options);
        return this;
    }

    public ChromeDriverFactory setUpDefaultValues(){
        manageWindow();
        manageTimeouts();
        return this;
    }

    public ChromeDriver create(){
        return driver;
    }

    private void manageWindow(){
        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0,0));
    }

    private void manageTimeouts(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static ChromeDriver getDriverInstance() {
        return driver;
    }
}
