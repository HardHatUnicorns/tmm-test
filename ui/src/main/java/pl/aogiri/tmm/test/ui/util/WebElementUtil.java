package pl.aogiri.tmm.test.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtil {
    public static WebElement get(WebDriver driver, By by){
        return driver.findElement(by);
    }

    public static void getAndClick(WebDriver driver, By by){
        get(driver, by).click();
    }

    public static void getAndWrite(WebDriver driver, By by, String value){
        get(driver, by).sendKeys(value);
    }

    public static void getAndClear(WebDriver driver, By by){
        get(driver, by).clear();
    }

    public static boolean getAndIsDisplayed(WebDriver driver, By by){
        return get(driver, by).isDisplayed();
    }

    public static boolean getAndIsSelected(WebDriver driver, By by){
        return get(driver, by).isSelected();
    }

    public static boolean getAndIsEnabled(WebDriver driver, By by){
        return get(driver, by).isEnabled();
    }

    public static String getAndGetText(WebDriver driver, By by) {

        return get(driver, by).getText();
    }
}
