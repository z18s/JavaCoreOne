package lesson_6;

public class Dog extends Animal {
    int age;

    private final int RUN_MAX = 500;
    private final int SWIM_MAX = 10;

    static int dogCounter = 0;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        dogCounter++;
    }

    public void dogInfo() {
        System.out.printf("%s is a dog and its age is %d.\n", name, age);
    }

    public void run(int length) {
        if (length > RUN_MAX) {
            System.out.printf("%s can't run more then %d meters, because it's a dog.\n", this.name, RUN_MAX);
        } else {
            super.run(length);
        }
    }

    public void swim(int length) {
        if (length > SWIM_MAX) {
            System.out.printf("%s can't swim more then %d meters, because it's a dog.\n", this.name, SWIM_MAX);
        } else {
            super.swim(length);
        }
    }
}