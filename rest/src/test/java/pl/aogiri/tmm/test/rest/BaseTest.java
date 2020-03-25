package pl.aogiri.tmm.test.rest;

import org.junit.jupiter.api.BeforeAll;
import pl.aogiri.tmm.test.rest.configuration.PropertiesFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        assertTrue(new PropertiesFactory().fetch());

    }
}
