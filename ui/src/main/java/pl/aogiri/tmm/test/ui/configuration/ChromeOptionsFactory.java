package pl.aogiri.tmm.test.ui.configuration;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {
    private ChromeOptions options;

    public ChromeOptionsFactory(ChromeOptions options) {
        this.options = options;
    }

    public ChromeOptionsFactory setHeadless(){
        options.setHeadless(true);
        return this;
    }

    public ChromeDriverFactory create(){
        return new ChromeDriverFactory();
    }
}
