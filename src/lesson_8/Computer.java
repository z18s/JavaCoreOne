package lesson_8;

public class Computer implements Player {
    private Mark mark = Mark.O;

    private boolean isMoved;
    private Cell movePosition;

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public void setMovePosition(Cell cell) {
        movePosition = cell;
    }

//    public boolean isMoved() {
//        return isMoved;
//    }

    public Cell getMovePosition() {
        return movePosition;
    }

    public Mark getMark() {
        return mark;
    }
}