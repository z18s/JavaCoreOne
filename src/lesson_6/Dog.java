package lesson_6;

public class Dog extends Animal {
    private int age;
    private int runMax;
    private int swimMax;
    private float jumpMax;

    static int dogCounter = 0;

    {   // Instance Initializer
        // от 400 м до 600 м
        runMax = (int) (Math.random() * 200 + 1) + 400;
        // от 7 м до 15 м
        swimMax = (int) (Math.random() * 8 + 1) + 7;
        // от 0.4 м до 0.7 м
        jumpMax = (float) (Math.random() * 0.3) + 0.4f;
    }

    public Dog(String name, int age) {
        super(name);
        this.age = age;
        dogCounter++;
    }

    @Override
    public void run(int distance) {
        if (distance <= this.runMax && distance > 0) {
            System.out.printf("TRUE: Dog %s's run %d meters.%n", super.getName(), distance);
        }
        if (distance > this.runMax) {
            System.out.printf("FALSE: Dog %s can't run more than %d meters.%n", super.getName(), this.runMax);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= this.swimMax && distance > 0) {
            System.out.printf("TRUE: Dog %s's run %d meters.%n", super.getName(), distance);
        }
        if (distance > this.swimMax) {
            System.out.printf("FALSE: Dog %s can't run more than %d meters.%n", super.getName(), this.swimMax);
        }
    }

    @Override
    public void jump(float height) {
        if (height <= this.jumpMax && height > 0) {
            System.out.printf("TRUE: Dog %s's jumped %.2f meters.%n", super.getName(), height);
        }
        if (height > this.jumpMax) {
            System.out.printf("FALSE: Dog %s can't jump more than %.2f meters.%n", super.getName(), this.jumpMax);
        }
    }

    @Override
    public void info() {
        System.out.printf("INFO: %s is a dog and its age is %d.%n", super.getName(), age);
    }
}