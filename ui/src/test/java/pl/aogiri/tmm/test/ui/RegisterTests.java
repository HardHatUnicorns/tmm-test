package pl.aogiri.tmm.test.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.aogiri.tmm.test.ui.method.RegisterMethods;
import pl.aogiri.tmm.test.ui.path.AlertPaths;
import pl.aogiri.tmm.test.ui.path.ButtonPaths;
import pl.aogiri.tmm.test.ui.util.WebElementUtil;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterTests extends BaseTest{

    @Test
    public void validRegistration() {
        RegisterMethods.registerUser(driver, "tmmtest@tmm.com", "tmmlogin", "Tmmpassword123", "Tmmpassword123");

        String toastMessage = WebElementUtil.getAndGetText(driver, AlertPaths.SUCCESS_TOAST.getPath());
        String expectedMessage = "Successfully registered!\n" +
                "Check e-mail inbox to activate your account\n" +
                "(You will be redirected to login page in 5 secounds)";

        assertEquals(expectedMessage, toastMessage);
    }

    @Test
    public void invalidLoginRegistration() {
        RegisterMethods.registerUser(driver, "tmmTestLogin@tmm.com", "tmmTakenLogin", "Tmmpassword123", "Tmmpassword123");
        WebElementUtil.getAndClick(driver, ButtonPaths.ARROW_TO_HOMEPAGE_BUTTON.getPath());
        RegisterMethods.registerUser(driver, "tmmTestLogin@tmm.com", "tmmTakenLogin", "Tmmpassword123", "Tmmpassword123");
        String toastMessage = WebElementUtil.getAndGetText(driver, AlertPaths.UNAVAILABLE_LOGIN_TOAST.getPath());
        String expectedMessage = "Given login is already taken";

        assertEquals(expectedMessage, toastMessage);
    }
}
