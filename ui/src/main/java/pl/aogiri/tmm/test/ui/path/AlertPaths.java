package pl.aogiri.tmm.test.ui.path;

import org.openqa.selenium.By;

public enum AlertPaths implements BasePath{
    SUCCESS_ALERT(By.cssSelector("div[class*='alert-success']")),
    DANGER_ALERT(By.cssSelector("div[class*='alert-danger']"));

    private By path;

    AlertPaths(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
