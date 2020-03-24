package pl.aogiri.tmm.test.ui;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.aogiri.tmm.test.ui.exception.PropertiesNotFetchedException;
import pl.aogiri.tmm.test.ui.link.Link;
import pl.aogiri.tmm.test.ui.path.LinkPaths;
import pl.aogiri.tmm.test.ui.util.ReplaceCamelCase;
import pl.aogiri.tmm.test.ui.util.WebElementUtil;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName(value = "This is example test to delete")
@DisplayNameGeneration(ReplaceCamelCase.class)
public class ExampleTestToDelete extends BaseTest {

    @ParameterizedTest
    @EnumSource(value = LinkPaths.class, names = {"HOME_LINK", "ABOUT_LINK", "LOGIN_LINK", "REGISTER_LINK"})
    public void shouldBe(LinkPaths linkPath) throws PropertiesNotFetchedException {
        driver.get(Link.HOME.getFullLink());

        assertTrue(WebElementUtil.getAndIsDisplayed(driver, linkPath.getLink()));
    }

    @ParameterizedTest
    @EnumSource(value = LinkPaths.class, names = {"USER_DASHBOARD_LINK"})
    public void shouldNotBe(LinkPaths linkPath) throws PropertiesNotFetchedException {
        driver.get(Link.HOME.getFullLink());

        assertFalse(WebElementUtil.getAndIsDisplayed(driver, linkPath.getLink()));
    }
}
