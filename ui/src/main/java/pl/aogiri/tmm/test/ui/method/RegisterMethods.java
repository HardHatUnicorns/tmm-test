package pl.aogiri.tmm.test.ui.method;

import org.openqa.selenium.support.Color;
import pl.aogiri.tmm.test.ui.path.FormPaths;
import pl.aogiri.tmm.test.ui.path.LinkPaths;
import pl.aogiri.tmm.test.ui.util.WebElementUtil;


public class RegisterMethods {

    public static void fillUserInformation(String email, String login, String password, String confirmPassword) {
        WebElementUtil.getAndClick(LinkPaths.REGISTER_LINK);
        WebElementUtil.getAndWrite(FormPaths.EMAIL_INPUT, email);
        WebElementUtil.getAndWrite(FormPaths.LOGIN_INPUT, login);
        WebElementUtil.getAndWrite(FormPaths.PASSWORD_INPUT, password);
        WebElementUtil.getAndWrite(FormPaths.PASSWORD_CONFIRM_INPUT, confirmPassword);
    }

    public static void registerUser(String email, String login, String password, String confirmPassword) {
        fillUserInformation(email, login, password, confirmPassword);
        WebElementUtil.getAndClick(FormPaths.REGISTER_SUBMIT);
    }

    public static Color getLabelColor(FormPaths label) {
        return WebElementUtil.getColor(label);
    }
}
