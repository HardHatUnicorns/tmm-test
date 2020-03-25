package pl.aogiri.tmm.test.ui.path;

import org.openqa.selenium.By;

public enum AlertPaths {
    SUCCESS_TOAST(By.cssSelector("div[class*=\"alert-success\"]")),
    UNAVAILABLE_LOGIN_TOAST(By.cssSelector("div[class*='alert-danger']"));

    private By path;

    AlertPaths(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
