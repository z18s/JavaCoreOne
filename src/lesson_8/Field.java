package lesson_8;

public class Field {
    Mark[][] cells;

    public Field(int size) {
        cells = new Mark[size][size];
        init(cells);
    }

    public void init(Mark[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = Mark.NONE;
            }
        }
    }

    public void makeMove(GameWindow gameWindow, Player player) {
        int x = player.getMovePosition().getX();
        int y = player.getMovePosition().getY();
        Mark mark = player.getMark();
        cells[x][y] = mark;
        if (player instanceof Computer) {
            gameWindow.setButton(x, y, mark.getTitle());
        }
        player.setMoved(true);
        // Консольный вывод
        System.out.println("x: " + x + ", y: " + y);
    }
}