package pl.aogiri.tmm.test.ui.method;

import pl.aogiri.tmm.test.ui.messages.AlertMessages;
import pl.aogiri.tmm.test.ui.path.AlertPaths;
import pl.aogiri.tmm.test.ui.util.WebElementUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertMethod {

    public static void expectedAlert( AlertPaths alertPaths, AlertMessages alertMessages){
        String toastMessage = WebElementUtil.getAndGetText(alertPaths);
        String expectedMessage = alertMessages.getMessage();

        assertEquals(expectedMessage, toastMessage);
    }

    public static void expectedSuccessAlert( AlertMessages alertMessages){
        expectedAlert(AlertPaths.SUCCESS_ALERT, alertMessages);
    }

    public static void expectedErrorAlert( AlertMessages alertMessages){
        expectedAlert(AlertPaths.DANGER_ALERT, alertMessages);
    }

}
