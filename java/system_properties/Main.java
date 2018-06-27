import java.util.Properties;
import java.util.Enumeration;

public class Main {

    public static void showProperty(String name) {
        String bibiProperty = System.getProperty(name);
        System.out.println(bibiProperty);
    }

    public static void setProperty(String name, String value) {
        System.setProperty(name, value);
    }

    public static void printSystemProperties() {
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String val = (String)p.get(key);
            System.out.println("'" + key + "': '" + val + "'");
        }
    }

    public static void main(String[] argv) {
        System.out.println("Salutare");


        // "bibi" was set from run.sh to "bubu" using the -D parameter
        showProperty("bibi");
        // Let's see if reading it consumes it
        showProperty("bibi"); // nope, it doesn't ;-)

        System.out.println("Remove property 'bibi'");
        System.clearProperty("bibi");
        showProperty("bibi"); // should display null

        // Let's see if we can set properties from inside the jvm
        setProperty("bibileanu", "bibilescu");
        showProperty("bibileanu");

        System.out.println("====================");
        // Let's print all the properties in the jvm (they can also be set, but it can be risky)
        //printSystemProperties(); // this has an very long output
    }
}
