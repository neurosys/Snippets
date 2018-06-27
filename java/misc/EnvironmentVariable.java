import java.util.Map;
import java.util.Set;

public class EnvironmentVariable {
    public static void main(String[] argv) {


        System.out.println("List all the environment variables");
        Map<String, String> env = System.getenv();
        Set<String> keys = env.keySet();
        for (String key : keys) {
            String val = env.get(key);
            System.out.println("'" + key + "' = '" + val + "'");
        }

        System.out.println("-----------------------------------------------");

        System.out.println("Get one environment variable, like $PATH");
        System.out.println(System.getenv("PATH"));
        System.out.println();
    }
}
