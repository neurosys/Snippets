
public class ReturnStatusCodeToShell {
    public static void main(String[] argv) {
        // Java doesn't have an "int main" but you can return an error code
        // from jvm (as C/CPP would return from main) by:
        System.exit(1);
    }
}
