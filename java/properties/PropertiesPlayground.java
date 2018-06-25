
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Enumeration;
import java.io.OutputStream;
import java.io.FileOutputStream;

class PropertiesPlayground {

    public static void savePropertiesToFile(String filename) {
        Properties prop = new Properties();
        OutputStream output = null;

        prop.setProperty("someName", "Foo bar");
        prop.setProperty("otherName", "12345");
        prop.setProperty("bibi", "Uhuuooooo");
        prop.setProperty("bubu", "mimi");

        try {
            output = new FileOutputStream(filename);
            prop.store(output, null);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Properties getPropertiesFromFile(String filename) {
        InputStream input = null; 

        try {
            input = new FileInputStream(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } 

        return getPropertiesFromInputStream(input);
    }

    public static Properties getPropertiesFromClasspath(String filename) {
        InputStream input = null;

        input = PropertiesPlayground.class.getClassLoader().getResourceAsStream(filename);
        if (input == null) {
            return null;
        }

        return getPropertiesFromInputStream(input);
    }

    public static Properties getPropertiesFromInputStream(InputStream input) {
        Properties prop = new Properties();
        boolean failed = false;
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            failed = true;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        if (! failed) {
            return prop;
        } else {
            return null;
        }
    }

    public static void printSpecificProperties(Properties prop) {
        String propertyName = "someName"; // This one should exist
        System.out.println("property '" + propertyName + "' has value = '" + prop.getProperty(propertyName) + "'");

        propertyName = "inexistentBlaBlaBla"; // This one shouldn't exist
        System.out.println("property '" + propertyName + "' has value = '" + prop.getProperty(propertyName) + "'");
    }

    public static void printAllProperties(Properties prop) {
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = (String) prop.getProperty(key);
            System.out.println("Key '" + key + "' has value '" + value + "'");
        }

    }

    public static void main(String[] argv) {
        savePropertiesToFile("file.properties");
        System.out.println("------------------------------");
        Properties prop = getPropertiesFromFile("file.properties");
        System.out.println("------------------------------");
        printSpecificProperties(prop);
        System.out.println("------------------------------");
        printAllProperties(prop);
    }
}
