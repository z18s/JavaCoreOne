package lesson_8;

public class TicTacToe {
    public static final String NAME = "Tic Tac Toe";

    private Field field;
    private Computer computer;
    private User user;

    public TicTacToe(int fieldSize) {
        this.field = new Field(fieldSize);
        this.computer = new Computer();
        this.user = new User();
    }

//    public Field getField() {
//        return field;
//    }

//    public Computer getComputer() {
//        return computer;
//    }

    public User getUser() {
        return user;
    }

    public void userMove(GameWindow gameWindow, int userX, int userY) {
        user.move(new Cell(userX, userY));
        field.makeMove(gameWindow, user);
    }

    public void computerMove(GameWindow gameWindow, int fieldSize) throws InterruptedException {
        Thread.sleep(500);
        computer.move(fieldSize);
        field.makeMove(gameWindow, computer);
    }
}