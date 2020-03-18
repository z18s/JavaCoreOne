package lesson_7;

public class Cat implements Observer {

    private final String name;
    private final int appetiteMax;
    private int appetiteNow;
    private boolean satiety;

    public Cat(String name, int appetiteMax) {
        this.name = name;
        this.appetiteMax = appetiteMax;
        this.appetiteNow = 0;
        this.satiety = false;
    }

    public void decreaseAppetite(int n) {
        this.appetiteNow -= n;
        satiety = false;
    }

    public void eat(Plate plate) {
        int foodNeed = appetiteMax - appetiteNow;
        int foodEat;
        if (plate.getFood() >= foodNeed) {
            satiety = true;
            foodEat = foodNeed;
        } else {
            satiety = false;
            foodEat = plate.getFood();
        }
        System.out.printf("Cat %s is eating %d food.%s%n", name, foodEat, (satiety ? "" : " Cat is not happy!"));
        appetiteNow += foodEat;
        info();
        doEat(plate, foodEat);
    }

    private void doEat(Plate plate, int foodEat) {
        plate.decreaseFood(foodEat);
        plate.info();
    }

    public void info() {
        System.out.printf("Cat %s is %s (%d/%d).%n", name, (satiety ? "satiated" : "hungry"), appetiteNow, appetiteMax);
    }

    @Override
    public void update(Observed o, Object arr) {
        if (appetiteNow < appetiteMax) {
            eat((Plate) o);
        }
    }
}