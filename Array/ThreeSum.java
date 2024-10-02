package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        // int[] arr = { -1, 0, 1, 2, -1, -4 };
        // int[] arr = { 0, 0, 0 };
        int[] arr = { -2, -1, 0, 0, 1, 2 };
        int k = 0;
        List<List<Integer>> res = new ArrayList<>();

        res = findTriplets2Pointer(arr, k);

        System.out.println(res);
    }

    // 2 pointer approach (n^2)
    static List<List<Integer>> findTriplets2Pointer(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                int currSum = arr[i] + arr[j] + arr[k];

                if (currSum < target) {
                    j++;
                } else if (currSum > target) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    res.add(temp);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }

        return res;
    }

    // Checking req number in set (n^2)
    static List<List<Integer>> findTriplets1(int[] arr, int target) {
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            Set<Integer> nums = new HashSet<>();

            for (int j = i + 1; j < arr.length; j++) {
                int reqNum = target - arr[i] - arr[j];
                if (nums.contains(reqNum)) {
                    List<Integer> ans = Arrays.asList(arr[i], arr[j], reqNum);
                    ans.sort(null);
                    res.add(ans);
                }

                nums.add(arr[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }
}
