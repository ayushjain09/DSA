package Array;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4, -1, 1, 8, -2 };
        int res = maxProduct(arr);
        System.out.println(res);
    }

    public static int maxProduct(int[] arr) {
        int max = Integer.MIN_VALUE;
        int pre = 1;
        int suff = 1;

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;

            pre = pre * arr[i];
            suff = suff * arr[j];

            max = Math.max(max, Math.max(pre, suff));
        }

        return max;
    }

}
