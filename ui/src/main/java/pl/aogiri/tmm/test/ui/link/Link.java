package pl.aogiri.tmm.test.ui.link;

import pl.aogiri.tmm.test.ui.configuration.PropertiesFactory;
import pl.aogiri.tmm.test.ui.exception.PropertiesNotFetchedException;
import pl.aogiri.tmm.test.ui.path.BasePath;

import java.io.StringWriter;

public enum Link {
    HOME("/"),
    ABOUT("/about"),
    AUTH_LOGIN("/auth/login"),
    AUTH_REGISTER("/auth/register"),
    AUTH_FORGOTTEN_PASSWORD("/auth/forgottenpassword"),
    AUTH_LOGOUT("/auth/logout"),
    USER_DASHBOARD("/user/dashboard");

    private String link;

    Link(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return link;
    }

    public String getLink(){
        return link;
    }

    public String getFullLink() throws PropertiesNotFetchedException {
        return new StringWriter()
                .append(PropertiesFactory.getBaseUrl())
                .append(link)
                .toString();
    }
}
