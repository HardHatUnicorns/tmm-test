package pl.aogiri.tmm.test.ui.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.aogiri.tmm.test.ui.configuration.ChromeDriverFactory;
import pl.aogiri.tmm.test.ui.path.BasePath;

public class WebElementUtil{
    private static final WebDriver driver = ChromeDriverFactory.getDriverInstance();

    public static <E extends BasePath> WebElement get(E path){
        return driver.findElement(path.getPath());
    }

    public static <E extends BasePath> void getAndClick(E by){
        get(by).click();
    }

    public static <E extends BasePath> void getAndWrite(E by, String value){
        get(by).sendKeys(value);
    }

    public static <E extends BasePath> void getAndClear(E by){
        get(by).clear();
    }

    public static <E extends BasePath> boolean getAndIsDisplayed(E by){
        return get(by).isDisplayed();
    }

    public static <E extends BasePath> boolean getAndIsSelected(E by){
        return get(by).isSelected();
    }

    public static <E extends BasePath> boolean getAndIsEnabled(E by){
        return get(by).isEnabled();
    }

    public static <E extends BasePath> String getAndGetText(E by) {
        return get(by).getText();
    }
}
