package lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkThree {

    private static Scanner sc;
    private static Random rnd;

    public static void main(String[] args) {

        int gameChosen;

        System.out.println("-----Hello!-----");

        do {
            sc = new Scanner(System.in);

            System.out.println("What do you want to play?");
            System.out.println("1 - Guess a Number");
            System.out.println("2 - Guess a Word");
            System.out.println("0 - Exit");
            gameChosen = sc.hasNextInt() ? sc.nextInt() : -1;
            System.out.println();

            switch (gameChosen) {
                case 0:
                    break;
                case 1:
                    guessNumber();
                    break;
                case 2:
                    guessWord();
                    break;
                default:
                    System.out.println("Choose only 1, 2 or 0.");
            }
        } while (gameChosen != 0);
        sc.close();
        System.out.println("-----Bye!-----");
    }

    public static void guessNumber() {

        rnd = new Random();

        final int SHOTS = 3;
        char gameRepeat;

        do {
            int computerNumber = rnd.nextInt(10);
            int userNumber;
            boolean isWinner = false;

            for (int i = 1; i <= SHOTS; i++) {
                System.out.printf("Shot %d. ", i);
                System.out.print("Guess the number 0...9: ");
                while (!sc.hasNextInt()) {
                    System.out.print("It's not a number. Enter a number: ");
                    sc.next();
                }
                userNumber = sc.nextInt();
                if (userNumber == computerNumber) {
                    System.out.println("YOU WIN! The number is «" + computerNumber + "».");
                    System.out.println();
                    isWinner = true;
                    break;
                }
                if (userNumber > computerNumber) {
                    System.out.println("Your number is bigger.");
                }
                if (userNumber < computerNumber) {
                    System.out.println("Your number is less.");
                }
            }

            if (!isWinner) {
                System.out.println("YOU LOSE! The number was «" + computerNumber + "».");
            }

            System.out.println();
            System.out.print("Repeat the game? (y/n): ");
            gameRepeat = sc.next().charAt(0);
            System.out.println();
        } while (gameRepeat == 'y' || gameRepeat == 'Y');
    }

    public static void guessWord() {

        rnd = new Random();

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String computerWord = words[rnd.nextInt(25)];
        String userWord;

        char[] shownWord = new char[15];
        Arrays.fill(shownWord, '*');

        boolean isWinner = false;

        do {
            System.out.println(shownWord);
            System.out.println("What word was guessed?");
            userWord = sc.next();
            System.out.println();

            if (userWord.equals(computerWord)) {
                System.out.println("YOU WIN! It's «" + computerWord + "».");
                isWinner = true;
            } else {
                int minLength = Math.min(userWord.length(), computerWord.length());
                for (int i = 0; i < minLength; i++) {
                    if (userWord.charAt(i) == computerWord.charAt(i)) {
                        shownWord[i] = userWord.charAt(i);
                    }
                }
            }
        } while (!isWinner);
    }
}
