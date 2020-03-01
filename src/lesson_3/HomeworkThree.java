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
        final int minVal = 0;
        final int maxVal = 9;
        char gameRepeat;

        do {
            int computerNumber = rnd.nextInt(maxVal + 1 - minVal) + minVal;
            int userNumber;
            boolean isWinner = false;

            for (int i = 1; i <= SHOTS; i++) {
                System.out.printf("Shot %d. Guess the number %d...%d: ", i, minVal, maxVal);
                while (!sc.hasNextInt()) {
                    System.out.print("It's not a number. Enter a number: ");
                    sc.next();
                }
                userNumber = sc.nextInt();
                if (userNumber == computerNumber) {
                    System.out.printf("YOU WIN! The number is «%d».\n\n", computerNumber);
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
                System.out.printf("YOU LOSE! The number was «%d».\n\n", computerNumber);
            }

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

        String computerWord = words[rnd.nextInt(words.length)];
        String userWord;

        char[] shownWord = new char[15];
        Arrays.fill(shownWord, '*');

        boolean isWinner = false;

        System.out.println("We have words: " + String.join(", ", words));

        do {
            System.out.println(shownWord);
            System.out.println("What word was guessed?");
            userWord = sc.next();
            System.out.println();

            if (userWord.equals(computerWord)) {
                System.out.printf("YOU WIN! It's «%s».\n\n", computerWord);
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
