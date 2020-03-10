package pl.aogiri.tmm.test.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {

    @BeforeAll
    public static void setup() throws IOException {
        Properties props = new Properties();
        props.load(Objects.requireNonNull(BaseTest.class.getClassLoader().getResourceAsStream("config.properties")));

        String port = props.getProperty("server.port");
        if (port == null)
            RestAssured.port = 80;
        else
            RestAssured.port = Integer.parseInt(port);



        String basePath = props.getProperty("server.base");
        if(basePath==null)
            basePath = "/api/";

        RestAssured.basePath = basePath;

        String baseHost = props.getProperty("server.host");
        if(baseHost==null)
            baseHost = "http://localhost";
        RestAssured.baseURI = baseHost;

    }
}
