package lesson_6;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public abstract void jump(float height);

    public void info() {
        System.out.printf("%s is an animal.%n", name);
    }
}