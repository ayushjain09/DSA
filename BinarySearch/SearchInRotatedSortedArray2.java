package BinarySearch;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 1 };
        int k = 0;
        System.out.println(searchElement(arr, k));
    }

    public static boolean searchElement(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == k)
                return true;

            if (arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                lo++;
                hi--;
                continue;
            }

            if (arr[lo] < arr[mid]) {
                if (k >= arr[lo] && k < arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (k > arr[mid] && k <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }
}
