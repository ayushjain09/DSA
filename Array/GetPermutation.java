package Array;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> res = new ArrayList<>();
        getPermutation(arr, 0, res);
        System.out.println(res);
    }

    static void getPermutation(int[] arr, int currIndex, List<List<Integer>> res) {
        if (currIndex == arr.length - 1) {
            List<Integer> base = new ArrayList<>();
            for (int num : arr) {
                base.add(num);
            }
            res.add(base);
            return;
        }

        for (int i = currIndex; i < arr.length; i++) {
            swap(currIndex, i, arr);
            getPermutation(arr, currIndex + 1, res);
            swap(currIndex, i, arr);
        }
    }

    static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
