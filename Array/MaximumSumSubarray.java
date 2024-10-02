package Array;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        // int[] arr = { 5, 1, -3, 6, 2, -4, 1, 2, -5, 6 };
        int[] arr = { -5, -3, -5 };
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
        int maxSum = arr[0];
        int currMaxSum = arr[0];
        int minSum = arr[0];
        int currMinSum = arr[0];
        int total = arr[0];

        for (int i = 1; i < arr.length; i++) {
            total += arr[i];

            currMaxSum = arr[i] + Math.max(currMaxSum, 0);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = arr[i] + Math.min(currMinSum, 0);
            minSum = Math.min(minSum, currMinSum);
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
