package pl.aogiri.tmm.test.ui;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import pl.aogiri.tmm.test.ui.exception.PropertiesNotFetchedException;
import pl.aogiri.tmm.test.ui.link.Link;
import pl.aogiri.tmm.test.ui.messages.AlertMessages;
import pl.aogiri.tmm.test.ui.method.AlertMethod;
import pl.aogiri.tmm.test.ui.method.RegisterMethods;
import pl.aogiri.tmm.test.ui.path.ButtonPaths;
import pl.aogiri.tmm.test.ui.util.ReplaceCamelCase;
import pl.aogiri.tmm.test.ui.util.WebElementUtil;

@DisplayNameGeneration(value = ReplaceCamelCase.class)
public class RegisterTests extends BaseTest{

    @Test
    public void shouldRegisterAccount() {
        RegisterMethods.registerUser( "tmmtest@tmm.com", "tmmlogin", "Tmmpassword123", "Tmmpassword123");
        AlertMethod.expectedSuccessAlert( AlertMessages.SUCCESSFUL_REGISTER);
    }

    @Test
    public void shouldNotRegisterAccountWhenLoginUsed() {
        RegisterMethods.registerUser( "tmmTestLogin@tmm.com", "tmmTakenLogin", "Tmmpassword123", "Tmmpassword123");
        WebElementUtil.getAndClick(ButtonPaths.ARROW_TO_HOMEPAGE_BUTTON);
        RegisterMethods.registerUser( "tmmTestLogin@tmm.com", "tmmTakenLogin", "Tmmpassword123", "Tmmpassword123");
        AlertMethod.expectedErrorAlert(AlertMessages.LOGIN_IS_TAKEN);
    }

    @Test
    public void xyz() throws PropertiesNotFetchedException {
        driver.get(Link.USER_DASHBOARD.getFullLink());
    }

}
