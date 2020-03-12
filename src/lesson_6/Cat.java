package lesson_6;

public class Cat extends Animal {
    private String color;
    private int runMax;
    private int swimMax;
    private float jumpMax;

    static int catCounter = 0;

    {   // Instance Initializer
        // от 150 м до 250 м
        runMax = (int) (Math.random() * 100 + 1) + 150;
        // 0
        swimMax = 0;
        // от 1.5 м до 2.5 м
        jumpMax = (float) (Math.random()) + 1.5f;
    }

    public Cat(String name, String color) {
        super(name);
        this.color = color;
        catCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance <= this.runMax && distance > 0) {
            System.out.printf("TRUE: Cat %s's run %d meters.%n", super.getName(), distance);
        }
        if (distance > this.runMax) {
            System.out.printf("FALSE: Cat %s can't run more than %d meters.%n", super.getName(), this.runMax);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > this.swimMax) {
            System.out.printf("FALSE: Cat %s can't swim.%n", super.getName());
        }
    }

    @Override
    public void jump(float height) {
        if (height <= this.jumpMax && height > 0) {
            System.out.printf("TRUE: Cat %s's jumped %.2f meters.%n", super.getName(), height);
        }
        if (height > this.jumpMax) {
            System.out.printf("FALSE: Cat %s can't jump more than %.2f meters.%n", super.getName(), this.jumpMax);
        }
    }

    @Override
    public void info() {
        System.out.printf("INFO: %s is a cat and its color is %s.%n", super.getName(), color);
    }
}