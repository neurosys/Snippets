
enum Seasons {
    SPRING("Spring"),
    SUMMER("Summer"),
    FALL("Fall"),
    WINTER("Winter"); 

    private final String seasonName;

    Seasons(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }
}

public class Values {

    public static void dump(Seasons x, String name) {
        System.out.println("name() = " + x.name());
        System.out.println("ordinal() = " + x.ordinal());
        System.out.println("valueOf() = " + Seasons.valueOf(name));
        System.out.println("toString() = " + x);
        System.out.println("getSeasonName() = " + x.getSeasonName());
        System.out.println();
    }

    public static void main(String[] args) {

        dump(Seasons.SPRING, "SPRING");
        dump(Seasons.SUMMER, "SUMMER");
        dump(Seasons.FALL, "FALL");
        dump(Seasons.WINTER, "WINTER");

        System.out.println("====== values() =======");

        Seasons[] ss = Seasons.values();
        for (Seasons s : ss) {
            dump(s, s.name());
        }
    }

    
}
