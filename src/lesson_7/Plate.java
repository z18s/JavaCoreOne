package lesson_7;

public class Plate extends Observed {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public Plate() {
        this(0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) throws InterruptedException {
        this.food += food;
        System.out.printf("%d food added.%n", food);
        info();
        foodNotifier();
    }

    public void decreaseFood(int n) {
        this.food -= n;
    }

    public void info() {
        System.out.printf("Plate: %d.%n", food);
    }

    @Override
    public String toString() {
        return "Plate{" + "food=" + food + '}';
    }

    // Добавление котов пачкой через класс Observed
    public void addObservers(Cat... cats) throws InterruptedException {
        for (Cat cat : cats) {
            super.addObserver(cat);
        }
        foodNotifier();
    }

    // Уведомление о наличие еды через класс Observed
    public void foodNotifier() throws InterruptedException {
        if (food > 0) {
            setChanged();
            notifyObservers();
        }
    }
}