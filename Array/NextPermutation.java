package Array;

public class NextPermutation {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 4, 2, 5, 4, 3 };
        int[] arr = { 2, 3, 1, 3, 3 };

        int bp = -1;

        /*
         * Step 1 : Find the index where number is smaller than all of its right
         */
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                bp = i;
                break;
            }
        }

        /*
         * Step 2a : If not found, the list is already in descending order, just reverse
         * of it is the answer.
         * Eg - [5,4,3,2,1] => [1,2,3,4,5]
         */
        if (bp == -1) {
            reverse(arr, 0, arr.length - 1);
        }

        /*
         * Step 2b :
         * 1. Find the index where number is just greater than arr[bp].
         * 2. Swap arr[i] and arr[bp]
         * 3. Reverse the right of bp to get the smallest ordered array.
         */
        if (bp >= 0) {
            for (int i = arr.length - 1; i > bp; i--) {
                if (arr[i] > arr[bp]) {
                    swap(arr, i, bp);
                    break;
                }
            }
            reverse(arr, bp + 1, arr.length - 1);
        }

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    static void reverse(int[] arr, int start, int end) {
        int i = start, j = end;
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
