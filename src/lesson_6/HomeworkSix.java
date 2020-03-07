package lesson_6;

public class HomeworkSix {
    public static void main(String[] args) {

        Animal animalBob = new Animal("Bob");
        Animal animalMia = new Animal("Mia");
        Animal animal = new Animal();

        Cat catOliver = new Cat("Oliver", "red");
        Cat catLucy = new Cat("Lucy", "black");

        Dog dogOscar = new Dog("Oscar", 3);
        Dog dogCharlie = new Dog("Charlie", 5);

        // Вывод

        System.out.println("  Animals:");
        animalBob.animalInfo();
        animalMia.animalInfo();
        animal.animalInfo();

        System.out.println("  Cats:");
        catOliver.catInfo();
        catLucy.animalInfo();

        System.out.println("  Dogs:");
        dogOscar.animalInfo();
        dogCharlie.dogInfo();

        System.out.println("----------");

        System.out.println("  Animals:");
        animalBob.run(900);

        System.out.println("  Cats:");
        catOliver.run(300);
        catLucy.run(180);

        System.out.println("  Dogs:");
        dogOscar.run(400);
        dogCharlie.run(600);

        System.out.println("----------");

        System.out.println("  Animals:");
        animalMia.swim(260);

        System.out.println("  Cats:");
        catOliver.swim(2);
        catLucy.swim(30);

        System.out.println("  Dogs:");
        dogOscar.swim(15);
        dogCharlie.swim(8);

        System.out.println("----------");

        System.out.printf("We have %d cats, %d dogs and %d other animals - %d animals total.\n",
                          Cat.catCounter, Dog.dogCounter,
                          Animal.animalCounter - (Cat.catCounter + Dog.dogCounter), Animal.animalCounter);
    }
}