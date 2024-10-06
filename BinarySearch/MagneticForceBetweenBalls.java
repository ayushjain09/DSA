package BinarySearch;

import java.util.Arrays;

public class MagneticForceBetweenBalls {
    public static void main(String[] args) {
        // int[] position = { 1, 2, 3, 4, 7 };
        int[] position = { 5, 4, 3, 2, 1, 1000000000 };
        int m = 2;
        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = position[position.length - 1] - position[0];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int placed = 1;
            int lastPosition = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - lastPosition >= mid) {
                    lastPosition = position[i];
                    placed++;

                    if (placed == m) {
                        break;
                    }
                }
            }

            if (placed == m) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
