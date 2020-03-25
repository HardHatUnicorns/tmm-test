package pl.aogiri.tmm.test.ui.path;

import org.openqa.selenium.By;

public enum FormPaths implements BasePath{

    //Inputs
    LOGIN_INPUT(By.cssSelector("input[formcontrolname='login']")),
    PASSWORD_INPUT(By.cssSelector("input[formcontrolname='plainPassword']")),
    PASSWORD_CONFIRM_INPUT(By.cssSelector("input[formcontrolname='plainPasswordConfirm']")),
    EMAIL_INPUT(By.cssSelector("input[formcontrolname='email']")),

    //Submits
    LOGIN_SUBMIT(By.xpath("//form/div/button/span[contains(text(),'Login')]")),
    REGISTER_SUBMIT(By.cssSelector("button[class*=btn-primary]>span"));

    private By path;

    FormPaths(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
