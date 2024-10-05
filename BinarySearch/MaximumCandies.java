package BinarySearch;

public class MaximumCandies {
    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        int k = 3;
        System.out.println(maxCandies(candies, k));
    }

    public static int maxCandies(int[] candies, int k) {
        int lo = 1, hi = Integer.MIN_VALUE, res = 0;
        for (int i = 0; i < candies.length; i++) {
            hi = Math.max(hi, candies[i]);
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            long partitions = 0; // long data type is important
            for (int i = 0; i < candies.length; i++) {
                partitions += (candies[i] / mid);
            }

            if (partitions >= k) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }

        return res;
    }
}
