package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(12, 34, 67, 90));
        int m = 2;
        System.out.println(findPages(arr, arr.size(), m));
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int lo = 0, hi = 0;
        for (int i = 0; i < arr.size(); i++) {
            lo = Math.max(lo, arr.get(i));
            hi += arr.get(i);
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int partitions = 0;
            int currTotalPages = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) + currTotalPages <= mid) {
                    currTotalPages += arr.get(i);
                } else {
                    partitions++;
                    currTotalPages = arr.get(i);
                }
            }

            if (partitions < m) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
