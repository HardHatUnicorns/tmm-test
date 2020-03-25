package pl.aogiri.tmm.test.ui.configuration;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverFactory {
    private ChromeDriver driver;

    public ChromeDriverFactory(){
        ChromeOptions chromeOptions = getOptions();
        driver = new ChromeDriver(chromeOptions);
    }

    public ChromeDriverFactory setUpDefaultValues(){
        manageWindow();
        manageTimeouts();
        return this;
    }

    private void manageWindow(){
        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0,0));
    }

    private void manageTimeouts(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private ChromeOptions getOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        return chromeOptions;
    }

    public ChromeDriver create(){
        return driver;
    }




}
