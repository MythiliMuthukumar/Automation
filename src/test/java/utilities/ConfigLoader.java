package utilities;

import java.io.*;
import java.util.Properties;

/**
 * Load the config properties from class path
 *
 * @author mythili.mahalingam
 */


public class ConfigLoader {
    Properties properties = new Properties();

    public ConfigLoader() {

        String filePath = "./properties/configfile.properties";

        BufferedReader reader = null;
        try {


            reader = new BufferedReader(new FileReader(filePath));

            properties.load(reader);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public String getPropertyValue(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
