package pl.aogiri.tmm.test.ui.path;

import org.openqa.selenium.By;

import static pl.aogiri.tmm.test.ui.link.Link.*;

public enum LinkPaths implements BasePath{

    HOME_LINK(By.cssSelector("a[routerlink='" + HOME + "']")),
    ABOUT_LINK(By.cssSelector("a[routerlink='" + ABOUT + "']")),

    LOGIN_LINK(By.cssSelector("a[routerlink='" + AUTH_LOGIN + "']")),
    LOGOUT_LINK(By.cssSelector("a[routerlink='" + AUTH_LOGOUT + "']")),
    REGISTER_LINK(By.cssSelector("a[routerlink='" + AUTH_REGISTER + "']")),
    FORGOTTEN_PASSWORD_LINK(By.cssSelector("a[routerlink='" + AUTH_FORGOTTEN_PASSWORD + "']")),

    USER_DASHBOARD_LINK(By.cssSelector("a[routerlink='" + USER_DASHBOARD + "']"));

    private By link;

    LinkPaths(org.openqa.selenium.By link) {
        this.link = link;
    }

    public By getPath() {
        return link;
    }
}
