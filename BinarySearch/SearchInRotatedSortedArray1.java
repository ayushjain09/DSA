package BinarySearch;

public class SearchInRotatedSortedArray1 {
    public static void main(String[] args) {
        int[] arr = { 20, 22, 23, 35, 30, 2, 4, 6, 8, 10, 12, 14, 16, 18 };
        int k = 12;
        System.out.println(searchElement(arr, k));
    }

    public static int searchElement(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == k)
                return mid;

            if (arr[lo] <= arr[mid]) {
                if (k >= arr[lo] && k < arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (arr[mid] <= arr[hi]) {
                if (k > arr[mid] && k <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
