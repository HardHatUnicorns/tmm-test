package pl.aogiri.tmm.test.rest.configuration;


import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesFactory {
    private Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);

    private final static String PROPERTIES_FILE_NAME = "application.properties";
    private Properties properties;

    public PropertiesFactory(){
        properties = new Properties();
    }

    public boolean fetch() {
        try {
            properties.load(Objects.requireNonNull(PropertiesFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)));
        } catch (IOException e) {
            logger.error("Cannot open properties file : " + e.getMessage());
            return false;
        }

        String prop;

        if((prop=properties.get("server.host").toString()) != null){
            RestAssured.baseURI = prop;
        }else{
            logger.error("Cannot find property named server.host");
            return false;
        }

        if((prop=properties.getProperty(("server.port"))) != null){
            RestAssured.port = Integer.parseInt(prop);
        }else{
            logger.error("Cannot find property named server.port");
            return false;
        }

        if((prop=properties.get("server.base").toString()) != null){
            RestAssured.basePath = prop;
        }else{
            logger.error("Cannot find property named server.base");
            return false;

        }

        return true;
    }

}