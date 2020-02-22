package lesson_2;

import java.util.Arrays;

public class ClassworkArrays {
    public static void main(String[] args) {

        final int SIZE = 5;
        int[][] data = new int[SIZE][SIZE];
        System.out.println(Arrays.toString(data));
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                data[i][j] = i + j;
        }
        for (int[] datum : data) {
            for (int v : datum) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
        System.out.println();

        // char[] => String
        char[] charArr = {'H', 'e', 'l', 'l', 'o'};
        String str = new String(charArr);
        System.out.println(str);
        System.out.println();

        // String => chars
        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
    }
}
