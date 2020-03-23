package lesson_7;

 public class HomeworkSeven {
    public static void main(String[] args) throws InterruptedException {

        Cat catBob = new Cat("Bob", 6);
        Cat catOliver = new Cat("Oliver", 8);
        Cat catMia = new Cat("Mia", 5);

        Plate plate = new Plate();
        plate.addObservers(catBob, catOliver, catMia);

        catBob.info();
        catOliver.info();
        catMia.info();
        plate.info();

        System.out.println("-----");
        Thread.sleep(2000);

        plate.addFood(10);

        System.out.println("-----");
        Thread.sleep(2000);

        plate.addFood(10);

        System.out.println("-----");
        Thread.sleep(2000);

        catBob.info();
        catOliver.info();
        catMia.info();
        plate.info();
    }
}