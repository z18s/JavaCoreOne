package lesson_8;

public interface Player {

    Mark getMark();
    Cell getMovePosition();

    void setMovePosition(Cell cell);
    void setMoved(boolean moved);

    default void move(Cell cell) {
        setMovePosition(cell);
    }

    default void move(int num) {
        Cell cell = new Cell(num);
        setMovePosition(cell);
    }
}