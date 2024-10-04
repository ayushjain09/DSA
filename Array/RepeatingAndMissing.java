package Array;

import java.util.HashSet;

public class RepeatingAndMissing {
    public static void main(String[] args) {
        int[][] arr = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
        // int[][] arr = { { 1, 3 }, { 2, 2 } };
        int[] res = findRepeatingAndMissingOptimal(arr);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] findRepeatingAndMissing(int[][] arr) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (set.contains(arr[i][j])) {
                    res[0] = arr[i][j];
                }

                set.add(arr[i][j]);
            }
        }

        for (int i = 1; i <= arr.length * arr.length; i++) {
            if (!set.contains(i)) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public static int[] findRepeatingAndMissingOptimal(int[][] arr) {
        int x = -1, y = -1, n = arr.length * arr.length;

        long sum1 = 0, sq1 = 0;
        long sum2 = 0, sq2 = 0;

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {
                sum1 += arr[i][j];
                sq1 += (long) (arr[i][j] * arr[i][j]);
            }

        sum2 = n * (n + 1) / 2;
        sq2 = n * (n + 1) * ((2 * n) + 1) / 6;

        long xMy = sum1 - sum2;
        long xPy = (sq1 - sq2) / xMy;

        x = (int) ((xPy + xMy) / 2);
        y = (int) (xPy - x);

        int[] res = { x, y };
        return res;
    }
}
