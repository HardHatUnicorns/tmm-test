package pl.aogiri.tmm.test.ui.method;

import org.openqa.selenium.WebDriver;
import pl.aogiri.tmm.test.ui.path.FormPaths;
import pl.aogiri.tmm.test.ui.path.LinkPaths;
import pl.aogiri.tmm.test.ui.util.WebElementUtil;

public class RegisterMethods {

    public static void registerUser(WebDriver driver, String email, String login, String password, String confirmPassword) {
        fillUserInformation( driver,  email,  login,  password,  confirmPassword);
        WebElementUtil.getAndClick(driver, FormPaths.REGISTER_SUBMIT.getPath());
    }

    public static void fillUserInformation(WebDriver driver, String email, String login, String password, String confirmPassword) {
        WebElementUtil.getAndClick(driver, LinkPaths.REGISTER_LINK.getPath());
        WebElementUtil.getAndWrite(driver, FormPaths.EMAIL_INPUT.getPath(), "tmmtest@tmm.com");
        WebElementUtil.getAndWrite(driver, FormPaths.LOGIN_INPUT.getPath(), "tmmlogin");
        WebElementUtil.getAndWrite(driver, FormPaths.PASSWORD_INPUT.getPath(), "Tmmpassword123");
        WebElementUtil.getAndWrite(driver, FormPaths.PASSWORD_CONFIRM_INPUT.getPath(), "Tmmpassword123");
    }

}
