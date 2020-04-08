package lesson_8;

public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    public Cell(int num) {
        this();
        this.x = (int) (Math.random() * num);
        this.y = (int) (Math.random() * num);
    }

    public Cell() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}