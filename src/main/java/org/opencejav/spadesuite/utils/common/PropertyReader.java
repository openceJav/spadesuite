package org.opencejav.spadesuite.utils.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;

import org.opencejav.spadesuite.annotations.UtilityClass;
import org.opencejav.spadesuite.exceptions.PropertyNotFoundException;
import org.tinylog.Logger;

// TODO Refactor & JavaDocify PropertyReader Utility Class

@UtilityClass(className = "PropertyReader")
public class PropertyReader implements Serializable {
    private static final String DEFAULT_PROPERTY_PATH = Objects.requireNonNull(
            Thread.currentThread().getContextClassLoader().getResource("app.properties")).getPath();
    private static final Properties PROPERTIES = new Properties();


    private PropertyReader() {
        // Private Constructor, Prevent Object Instantiation.
    }

    public static void loadPropertiesFromFile(String propPath) throws PropertyNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(propPath)) {
            PROPERTIES.load(fileInputStream);

        } catch (IOException e) {
            Logger.error("Error Loading Properties File Path Provided: %s".formatted(propPath));

            try(FileInputStream fileInputStream = new FileInputStream(DEFAULT_PROPERTY_PATH)) {
                PROPERTIES.load(fileInputStream);

            } catch (IOException ex) {
                Logger.error("Error Loading Default Properties File.");
                throw new PropertyNotFoundException("Error Loading Default Properties File.");

            }
        }
    }

    //region Utility Methods: unloadProperties(), readPropertyFromKey(String, String), readPropertyFromKey(String)
    public static void unloadProperties() {
        PROPERTIES.clear();
    }

    public static String readPropertyFromKey(String propPath, String key) {
        if (PROPERTIES.isEmpty()) loadPropertiesFromFile(propPath);

        try {
            String property = PROPERTIES.getProperty(key);
            if (property == null) {
                throw new PropertyNotFoundException("Property Not Found for Key: %s".formatted(key));
            }
            return property;

        } catch (NullPointerException e) {
            Logger.error("Error Reading Property from Key, Resorting to Default: %s".formatted(key));

            return readPropertyFromKey(DEFAULT_PROPERTY_PATH, key);
        }
    }

    public static String readPropertyFromKey(String key) {
        return readPropertyFromKey(DEFAULT_PROPERTY_PATH, key);
    }
    //endregion
}
