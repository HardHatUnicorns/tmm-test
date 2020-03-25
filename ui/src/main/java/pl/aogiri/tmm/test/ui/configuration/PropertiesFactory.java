package pl.aogiri.tmm.test.ui.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.aogiri.tmm.test.ui.exception.PropertiesNotFetchedException;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesFactory {
    private Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);

    private final static String PROPERTIES_FILE_NAME = "application.properties";
    private Properties properties;

    private static String BASE_URL;

    public PropertiesFactory(){
        properties = new Properties();
    }

    public boolean fetch() {
        try {
            properties.load(Objects.requireNonNull(PropertiesFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)));
        } catch (IOException | NullPointerException e) {
            logger.error("Cannot open properties file : " + e.getMessage());
            return false;
        }

        String prop;
        StringBuilder buffer = new StringBuilder();

        if((prop=properties.getProperty("server.host")) != null){
            buffer.append(prop);
        }else{
            logger.error("Cannot find property named server.host");
            return false;
        }

        if((prop=properties.getProperty("server.port")) != null){
            buffer.append(":");
            buffer.append(prop);
        }

        if((prop=properties.getProperty("server.base")) != null){
            buffer.append(prop);
        }else{
            logger.error("Cannot find property named server.base");
            return false;

        }

        BASE_URL = buffer.toString();
        return true;
    }

    public static String getBaseUrl() throws PropertiesNotFetchedException {
        if(BASE_URL != null)
            return BASE_URL;
        else
            throw new PropertiesNotFetchedException();

    }

}
