package utilities;

import managers.DriverManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    public static Logger LOGGER = LogManager.getLogger(ConfigFileReader.class);

    public Properties getPropValues(String propFileName) {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                DriverManager.killDriverProcess();
                e.printStackTrace();
            }
        } else {
            try {
                DriverManager.killDriverProcess();
                LOGGER.error("property file '" + propFileName + "' not found in the classpath");
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            } catch (FileNotFoundException e) {
                DriverManager.killDriverProcess();
                e.printStackTrace();
            }
        }

        return prop;
    }
}

