package org.opencejav.spadesuite.utils.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

import org.opencejav.spadesuite.annotations.UtilityClass;
import org.opencejav.spadesuite.exceptions.PropertyNotFoundException;
import org.tinylog.Logger;

@UtilityClass(className = "PropertyReader")
@SuppressWarnings("all")
// TODO Refactor & JavaDocify PropertyReader Utility Class
public final class PropertyReader implements Serializable {
    private static final String DEFAULT_PROPERTY_PATH = Objects.requireNonNull(
            Thread.currentThread().getContextClassLoader().getResource("org/opencejav/spadesuite/app.properties")).getPath();
    private static Properties prop;

    private PropertyReader() {
        // Private Constructor, Prevent Object Instantiation.
    }

    public static <T, K> boolean writePropertiesToFile(HashMap<T, K> properties, String propPath) {
        // TODO Validate Properties & Path

        if (properties.isEmpty() || propPath == null) {
            Logger.error("Error Writing Properties, Empty Map Provided or Path is Null.");
            return false;
        }

        Properties prop = new Properties(0);
        properties.forEach((key, value) -> prop.setProperty(key.toString(), value.toString()));

        return true;
    }


    public static void loadPropertiesFromFile(String propPath) throws PropertyNotFoundException {
        Properties prop = new Properties(0);


        try (FileInputStream fileInputStream = new FileInputStream(propPath)) {
            prop.load(fileInputStream);

        } catch (IOException e) {
            Logger.error("Error Loading Properties File Path Provided: %s".formatted(propPath));

            try (FileInputStream fileInputStream = new FileInputStream(DEFAULT_PROPERTY_PATH)) {
                prop.load(fileInputStream);

            } catch (IOException ex) {
                Logger.error("Error Loading Default Properties File.");
                throw new PropertyNotFoundException("Error Loading Default Properties File.");

            }
        }
    }

    //region Utility Methods: unloadProperties(), readPropertyFromKey(String, String), readPropertyFromKey(String)
    public static void unloadProperties(Properties prop) {
        prop.clear();
    }

    public static String readPropertyFromKey(String propPath, String key) {
        if (prop.isEmpty()) loadPropertiesFromFile(propPath);

        try {
            String property = prop.getProperty(key);

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
