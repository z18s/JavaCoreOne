package lesson_6;

public class HomeworkSix {
    public static void main(String[] args) {

        Cat catOliver = new Cat("Oliver", "red");
        Cat catLucy = new Cat("Lucy", "black");

        Dog dogOscar = new Dog("Oscar", 3);
        Dog dogCharlie = new Dog("Charlie", 5);

        // Вывод

        catOliver.info();
        catLucy.info();

        dogOscar.info();
        dogCharlie.info();

        System.out.println("----------");

        catOliver.run(250);
        catLucy.run(180);

        dogOscar.run(600);
        dogCharlie.run(300);

        System.out.println("----------");

        catOliver.swim(2);
        catLucy.swim(5);

        dogOscar.swim(15);
        dogCharlie.swim(8);

        System.out.println("----------");

        catOliver.jump(1.5f);
        catLucy.jump(2.6f);

        dogOscar.jump(0.5f);
        dogCharlie.jump(0.9f);

        System.out.println("----------");

        System.out.printf("We have %d cats and %d dogs.%n", Cat.catCounter, Dog.dogCounter);
    }
}