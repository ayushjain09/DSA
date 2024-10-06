package BinarySearch;

public class MinInRotatedSortedArray2 {
    public static void main(String[] args) {
        // int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        int[] arr = { 9, 9, 1, 9, 9, 9, 9, 9 };
        System.out.println(minEle(arr));
    }

    public static int minEle(int[] arr) {
        int lo = 0, hi = arr.length - 1, ans = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                ans = Math.min(ans, arr[mid]);
                lo++;
                hi--;
                continue;
            }

            if (arr[lo] <= arr[mid]) {
                ans = Math.min(ans, arr[lo]);
                lo = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                hi = mid - 1;
            }
        }

        return ans;
    }
}
