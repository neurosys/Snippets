
enum Colors {
    RED, GREEN, BLUE, WHITE, BLACK, PINK;
}

public class Main {
    public static void main(String[] argv) {
        System.out.println("Hi there!");

        Colors x = Colors.BLUE;

        switch (x) {
            case RED:
            case GREEN:
            case BLUE:
                System.out.println("One of the primary colors (RGB) " + x + " ordinal = " + x.ordinal());
                break;
            default:
                System.out.println("Non primary color " + x + " ordinal = " + x.ordinal());

        }
        System.out.println("--------------------------");

        Colors[] values = x.values();
        for (Colors c : values) {
            System.out.println("Color = " + c + " ordinal = " + c.ordinal());
        }
    }
}
