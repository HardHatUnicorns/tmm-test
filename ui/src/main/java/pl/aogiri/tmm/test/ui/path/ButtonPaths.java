package pl.aogiri.tmm.test.ui.path;

import org.openqa.selenium.By;

public enum ButtonPaths {
    ARROW_TO_HOMEPAGE_BUTTON(By.cssSelector("a[class*='back-button']"));

    private By path;

    ButtonPaths(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
