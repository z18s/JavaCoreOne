package lesson_6;

public class Animal {
    String name;

    static int animalCounter = 0;

    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public Animal() {
        this("Noname");
    }

    public void animalInfo() {
        System.out.printf("%s is an animal.\n", name);
    }

    public void run(int length) {
        System.out.printf("%s has run %d meters.\n", this.name ,length);
    }

    public void swim(int length) {
        System.out.printf("%s has swum %d meters.\n", this.name, length);
    }
}