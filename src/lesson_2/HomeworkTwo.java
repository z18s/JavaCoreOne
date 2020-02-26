package lesson_2;

import java.util.Arrays;

public class HomeworkTwo {

    public static void main(String[] args) {

        // 1
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        // 2
        int[] arr2 = new int[8];
        for (int i = 0, j = 0; i < arr2.length; i++, j += 3) {
            arr2[i] = j;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        // 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] *= (arr3[i] < 6) ? 2 : 1;
        }
        System.out.println(Arrays.toString(arr3));
        System.out.println();

        // 4
        final int ARR4_SIZE = 5;
        int[][] arr4 = new int[ARR4_SIZE][ARR4_SIZE];
        for (int[] ints : arr4) {
            System.out.println(Arrays.toString(ints));
        }
        for (int i = 0; i < ARR4_SIZE; i++) {
            arr4[i][i] = 1;
            arr4[i][ARR4_SIZE - 1 - i] = 1;
        }
        System.out.println();
        for (int[] ints : arr4) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();

        // 5
        int[] arr5 = {65, 41, 25, 68, 23, 54, 564, 5, 65, 97, 60, 482, 35, 211};
        System.out.println(Arrays.toString(arr5));
        int arr5Min = arr5[0];
        int arr5Max = arr5[0];
        for (int value : arr5) {
            arr5Min = (value < arr5Min) ? value : arr5Min;
            arr5Max = (value > arr5Max) ? value : arr5Max;
        }
        System.out.println("Min value is " + arr5Min + " and max value is " + arr5Max);
        System.out.println();

        // 6
        int[] arr6 = {2, 3, 4, 1, 2, 1, 2, 3};
        System.out.println(Arrays.toString(arr6));
        // v.1
        boolean isBalance = task6v1(arr6);
        System.out.println(isBalance);
        if (isBalance) {
            for (int i = 0; i < balancePoint; i++) {
                System.out.print(arr6[i] + " ");
            }
            System.out.print("||");
            for (int i = balancePoint; i < arr6.length; i++) {
                System.out.print(" " + arr6[i]);
            }
        }
        System.out.println();
        // v.2
        isBalance = task6v2(arr6);
        System.out.println(isBalance);
        System.out.println();

        // 7
        int[] arr7 = {2, 6, 3, 7, 9, 8, 1};
        int n = 3;
        System.out.println(Arrays.toString(arr7));
        // v.1
        System.out.println(Arrays.toString(task7v1(arr7, n)));
        // v.2
        task7v2(arr7, n);
        System.out.println(Arrays.toString(arr7));
        System.out.println();
    }

    static int balancePoint;

    public static boolean task6v1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += arr[j];
            }
            for (int k = i; k < arr.length; k++) {
                sum2 += arr[k];
            }
            if (sum1 == sum2) {
                balancePoint = i;
                return true;
            }
        }
        return false;
    }

    public static boolean task6v2(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int sumTemp = 0;
        for (int j = 0; j < arr.length; j++) {
            sumTemp += arr[j];
            if (sumTemp == sum / 2) {
                return true;
            }
        }
        return false;
    }

    public static int[] task7v1(int[] arr, int hop) {
        int[] arrModified = new int[arr.length];
        for (int i = 0, j = hop; i < arr.length; i++, j++) {
            j = j % arr.length;
            if (j < 0) {
                j += arr.length;
            }
            arrModified[j] = arr[i];
        }
        return arrModified;
    }

    public static void task7v2(int[] arr, int hop) {
        hop = hop % arr.length;
        if (hop < 0) {
            hop += arr.length;
        }
        for (int i = 0; i < hop; i++) {
            int tmp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = tmp;
        }
    }
}
