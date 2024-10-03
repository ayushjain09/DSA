package Array;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        // int[] arr = { 5, 1, -3, 6, 2, -4, 1, 2, -5, 6 };
        int[] arr = { 1, -2, 3, -2 };
        // int[] arr = { -5, -3, -5 };
        int maxSum = maxCircularSubArray(arr);
        System.out.println(maxSum);
    }

    public static int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {
            if (currSum == 0) {
                start = i;
            }

            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;

                ansStart = start;
                ansEnd = i;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println(ansStart + " " + ansEnd);

        return maxSum;
    }

    public static int maxCircularSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currMaxSum = 0;
        int minSum = Integer.MAX_VALUE;
        int currMinSum = 0;
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];

            currMaxSum += arr[i];
            maxSum = Math.max(maxSum, currMaxSum);
            if (currMaxSum < 0)
                currMaxSum = 0;

            currMinSum += arr[i];
            minSum = Math.min(minSum, currMinSum);
            if (currMinSum > 0) {
                currMinSum = 0;
            }
        }

        return minSum == total ? maxSum : Math.max(maxSum, total - minSum);
    }
}
