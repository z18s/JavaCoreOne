package lesson_6;

public class Cat extends Animal {
    String color;

    private final int RUN_MAX = 200;
    private final int SWIM_MAX = 0;

    static int catCounter = 0;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
        catCounter++;
    }

    public void catInfo() {
        System.out.printf("%s is a cat and its color is %s.\n", name, color);
    }

    public void run(int length) {
        if (length > RUN_MAX) {
            System.out.printf("%s can't run more then %d meters, because it's a cat.\n", this.name, RUN_MAX);
        } else {
            super.run(length);
        }
    }

    public void swim(int length) {
        if (length > SWIM_MAX) {
            System.out.printf("%s can't swim, because It's a cat.\n", this.name);
        }
    }
}