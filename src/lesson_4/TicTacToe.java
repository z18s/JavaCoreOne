package lesson_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final char MARK_EMPTY = '-';
    public static final char MARK_USER = 'X';
    public static final char MARK_MACHINE = 'O';

    public static boolean isWinner = false;
    public static boolean isWinAlert = false;

    public static int[] lineAlertArr = new int[]{-1, -1};
    public static int[] diagAlertArr = new int[]{-1, -1};

    public static Scanner scan = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {

        final int FIELD_MIN = 3;
        final int FIELD_MAX = 10;
        int fieldSize;
        do {
            System.out.printf("Enter a field size %d...%d: ", FIELD_MIN, FIELD_MAX);
            fieldSize = scan.hasNextInt() ? scan.nextInt() : FIELD_MIN;
        } while (fieldSize < FIELD_MIN || fieldSize > FIELD_MAX);

        int winSequence = 2 + fieldSize / 3;
        int alertSequence = winSequence - 1;

        char[][] field = new char[fieldSize][fieldSize];
        for (char[] row : field) {
            Arrays.fill(row, MARK_EMPTY);
        }

        paintField(field);

        while (true) {

            userTurn(field);

            if (checkTheEnd(field, winSequence, alertSequence)) {
                break;
            }

            machineTurn(field, alertSequence);

            if (checkTheEnd(field, winSequence, alertSequence)) {
                break;
            }
        }
    }

    // Отрисовка поля
    private static void paintField(char[][] field) {
        System.out.printf("%3c", ' ');
        for (int i = 1; i <= field.length; i++) {
            System.out.printf("%3d", i);

        }
        for (int j = 0; j < field.length; j++) {
            System.out.printf("\n%3d", (j + 1));
            for (int k = 0; k < field.length; k++) {
                System.out.printf("%3c", field[j][k]);
            }
        }
        System.out.println();
        System.out.println();
    }

    // Конец игры
    private static boolean checkTheEnd(char[][] field, int winSequence, int alertSequence) {
        if (checkWinner(field, winSequence, alertSequence)) {
            if (isWinner) {
                System.out.println("YOU WIN!");
            } else {
                System.out.println("The machine wins!");
            }
            return true;
        }
        if (!checkTurnPossibility(field)) {
            System.out.println("No more empty cells. Drawn game!");
            return true;
        }
        return false;
    }

    // Проверка, остались ли свободные ячейки
    private static boolean checkTurnPossibility(char[][] field) {
        for (char[] columns : field) {
            for (char cell : columns) {
                if (cell == MARK_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    // Проверка на победу
    private static boolean checkWinner(char[][] field, int winSequence, int alertSequence) {

        char[] arrUserWin = new char[winSequence];
        Arrays.fill(arrUserWin, MARK_USER);

        char[] arrMachineWin = new char[winSequence];
        Arrays.fill(arrMachineWin, MARK_MACHINE);

        char[] arrTempA = new char[winSequence];
        char[] arrTempB = new char[winSequence];


        // Проверка на победу столбцов и строк
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j <= field.length - winSequence; j++) {
                for (int k = 0; k < winSequence; k++) {
                    arrTempA[k] = field[i][j + k];
                    arrTempB[k] = field[j + k][i];
                }
                if (Arrays.equals(arrTempA, arrUserWin) || Arrays.equals(arrTempB, arrUserWin)) {
                    isWinner = true;
                    return true;
                }
                if (Arrays.equals(arrTempA, arrMachineWin) || Arrays.equals(arrTempB, arrMachineWin)) {
                    isWinner = false;
                    return true;
                }
                if (checkWinAlert(arrTempA, alertSequence) || checkWinAlert(arrTempB, alertSequence)) {
                    isWinAlert = true;
                    lineAlertArr[0] = i;
                    lineAlertArr[1] = j;
                }
            }
        }

        // Проверка на победу диагоналей
        for (int i = 0; i <= field.length - winSequence; i++) {
            for (int j = 0; j <= field.length - winSequence; j++) {
                for (int k = 0; k < winSequence; k++) {
                    arrTempA[k] = field[i + k][j + k];
                    arrTempB[k] = field[i + k][j + winSequence - 1 - k];
                }
                if (Arrays.equals(arrTempA, arrUserWin) || Arrays.equals(arrTempB, arrUserWin)) {
                    isWinner = true;
                    return true;
                }
                if (Arrays.equals(arrTempA, arrMachineWin) || Arrays.equals(arrTempB, arrMachineWin)) {
                    isWinner = false;
                    return true;
                }
                if (checkWinAlert(arrTempA, alertSequence) || checkWinAlert(arrTempB, alertSequence)) {
                    isWinAlert = true;
                    diagAlertArr[0] = i;
                    diagAlertArr[1] = j;
                }
            }
        }
        return false;
    }

    // Проверка на последний ход до победы игрока
    public static boolean checkWinAlert(char[] arr, int alertSequence) {
        int i = 0;
        for (char c : arr) {
            if (c == MARK_USER) {
                i++;
            }
        }
        return i == alertSequence;
    }

    // Ход пользователя
    private static void userTurn(char[][] field) {
        System.out.print("Your turn. ");
        int userTurnRow;
        int userTurnColumn;
        do {
            System.out.println("Enter row and column number: ");
            userTurnRow = scan.nextInt() - 1;
            userTurnColumn = scan.nextInt() - 1;
        } while (isOutOfBounds(field, userTurnRow, userTurnColumn, true) ||
                isOccupiedCell(field, userTurnRow, userTurnColumn, true));
        field[userTurnRow][userTurnColumn] = MARK_USER;

        paintField(field);
    }

    // Ход программы
    private static void machineTurn(char[][] field, int alertSequence) {
        System.out.println("Machine's turn.");
        boolean isNotAlertTurn = true;
        if (isWinAlert) {
            isNotAlertTurn = machineAlertTurn(field, alertSequence);
        }
        if (isNotAlertTurn) {
            int machineTurnRow;
            int machineTurnColumn;
            do {
                machineTurnRow = rnd.nextInt(field.length);
                machineTurnColumn = rnd.nextInt(field.length);
            } while (isOccupiedCell(field, machineTurnRow, machineTurnColumn, false));
            field[machineTurnRow][machineTurnColumn] = MARK_MACHINE;
        }

        paintField(field);
    }

    // Ход программы, когда игроку остался один ход до победы
    private static boolean machineAlertTurn(char[][] field, int alertSequence) {
        int machineTurnRow = -1;
        int machineTurnColumn = -1;
        char[] arrTempC = new char[alertSequence + 1];
        // Проверка, что alert пришёл из строки
        if (lineAlertArr[0] != -1 && lineAlertArr[1] != -1) {
            for (int i = 0; i < alertSequence + 1; i++) {
                arrTempC[i] = field[lineAlertArr[0]][lineAlertArr[1] + i];
                if (arrTempC[i] != MARK_USER) {
                    machineTurnRow = lineAlertArr[0];
                    machineTurnColumn = lineAlertArr[1] + i;
                }
            }
            // Проверка, что alert пришёл из столбца
            if (!checkWinAlert(arrTempC, alertSequence)) {
                for (int i = 0; i < alertSequence + 1; i++) {
                    arrTempC[i] = field[lineAlertArr[1] + i][lineAlertArr[0]];
                    if (arrTempC[i] != MARK_USER) {
                        machineTurnRow = lineAlertArr[1] + i;
                        machineTurnColumn = lineAlertArr[0];
                    }
                }
            }
            // Сброс массива с координатами alert'а для строки и столбца
            lineAlertArr[0] = -1;
            lineAlertArr[1] = -1;
        }

        // Проверка, что alert пришёл из диагонали
        if (diagAlertArr[0] != -1 && diagAlertArr[1] != -1) {
            for (int i = 0; i < alertSequence + 1; i++) {
                arrTempC[i] = field[diagAlertArr[0] + i][diagAlertArr[1] + i];
                if (arrTempC[i] != MARK_USER) {
                    machineTurnRow = diagAlertArr[0] + i;
                    machineTurnColumn = diagAlertArr[1] + i;
                }
            }
            // Проверка, что alert пришёл из обратной диагонали
            if (!checkWinAlert(arrTempC, alertSequence)) {
                for (int i = 0; i < alertSequence + 1; i++) {
                    arrTempC[i] = field[diagAlertArr[0] + i][diagAlertArr[1] + alertSequence - i];
                    if (arrTempC[i] != MARK_USER) {
                        machineTurnRow = diagAlertArr[0] + i;
                        machineTurnColumn = diagAlertArr[1] + alertSequence - i;
                    }
                }
            }
            // Сброс массива с координатами alert'а для диагоналей
            diagAlertArr[0] = -1;
            diagAlertArr[1] = -1;
        }

        // Если координаты не свободны, то делаем обычный ход
        if (isOccupiedCell(field, machineTurnRow, machineTurnColumn, false)) {
            isWinAlert = false;
            return true;
        } else {
            field[machineTurnRow][machineTurnColumn] = MARK_MACHINE;
            isWinAlert = false;
            return false;
        }
    }

    // Свободна ли ячейка, куда совершается ход
    private static boolean isOccupiedCell(char[][] field, int row, int column, boolean message) {
        boolean result = field[row][column] != MARK_EMPTY;
        if (result && message) {
            System.out.println("Chosen value is occupied.");
        }
        return result;
    }

    // В пределах игрового поля ли совершается ход
    private static boolean isOutOfBounds(char[][] field, int row, int column, boolean message) {
        boolean result = row < 0 || row >= field.length || column < 0 || column >= field.length;
        if (result && message) {
            System.out.println("Chosen value is out of bounds.");
        }
        return result;
    }
}