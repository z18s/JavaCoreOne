package lesson_2;

public class ClassworkSwitch {
    public static void main(String[] args) {

        //
        System.out.println(printSeason(1));
        System.out.println();
        //
        System.out.println(printSwitchSeason(2));
        System.out.println();
        //
        printlnSwitchSeason(3);
        System.out.println();
        //
        System.out.println(printSwitchSeasonM(11));
    }

    // if
    static String printSeason(int seasonNumber) {
        if (seasonNumber == 1) return "Winter";
        if (seasonNumber == 2) return "Spring";
        if (seasonNumber == 3) return "Summer";
        if (seasonNumber == 4) return "Fall";
        return "Unknown season";
    }

    // switch / return
    static String printSwitchSeason(int seasonNumber) {
        switch (seasonNumber) {
            case 1:
                return "Winter";
            case 2:
                return "Spring";
            case 3:
                return "Summer";
            case 4:
                return "Fall";
            default:
                return "Unknown season";
        }
    }

    // switch / break
    static void printlnSwitchSeason(int seasonNumber) {
        switch (seasonNumber) {
            case 1:
                System.out.println("Winter");
                break;
            case 2:
                System.out.println("Spring");
                break;
            case 3:
                System.out.println("Summer");
                break;
            case 4:
                System.out.println("Fall");
                break;
            default:
                System.out.println("Unknown season");
        }
    }

    // switch / return + cases
    static String printSwitchSeasonM(int monthNumber) {
        switch (monthNumber) {
            case 1:
            case 2:
            case 12:
                return "Winter";
            case 3:
            case 4:
            case 5:
                return "Spring";
            case 6:
            case 7:
            case 8:
                return "Summer";
            case 9:
            case 10:
            case 11:
                return "Fall";
            default:
                return "Unknown season";
        }
    }
}
