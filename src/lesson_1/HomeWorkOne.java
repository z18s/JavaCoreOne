package lesson_1;

public class HomeWorkOne {
    public static void main(String[] args) {
        byte bt = 100;
        short srt = 30000;
        int i = 35000;
        long lng = -999L;
        float flt = 9.99f;
        double dbl = 100.001;
        char chr = 'q';
        boolean bln = true;
        String str = "Hey, Java!";

        System.out.println(task3(bt, srt, lng, flt));
        // 100 * (30 000 + (-999 / 9.99))
        System.out.println();

        System.out.println(task4(2, 3));
        System.out.println(task4(5, 9));
        System.out.println(task4(8, 15));
        System.out.println();

        task5(-55);
        task5(i);
        System.out.println();

        int a = -88;
        int b = 19;
        System.out.println(a + " < 0 is " + task6(a));
        System.out.println(b + " < 0 is " + task6(b));
        System.out.println();

        String name = "UserName";
        task7(name);
        System.out.println();

        int year = 1500;
        System.out.println(year + " " + task8(year) + " leap year");
        year = 1600;
        System.out.println(year + " " + task8(year) + " leap year");
        year = 1604;
        System.out.println(year + " " + task8(year) + " leap year");
        year = 1699;
        System.out.println(year + " " + task8(year) + " leap year");
    }

    public static float task3(byte a, short b, long c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task4(int a, int b) {
        if ((a + b >= 10) && (a + b <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void task5(int a) {
        if (a >= 0) {
            System.out.println("Number " + a + " is positive");
        } else {
            System.out.println("Number " + a + " is negative");
        }
    }

    public static boolean task6(int a) {
        return (a < 0);
    }

    public static void task7(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static String task8(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return "is";
        } else {
            return "isn't";
        }
    }
}