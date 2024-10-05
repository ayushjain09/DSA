package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 6;
        int res = getMinimumOptimalSpeed(piles, h);
        System.out.println(res);
    }

    public static int getMinimumOptimalSpeed(int[] piles, int h) {
        int lo = 0;
        int hi = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > hi)
                hi = piles[i];
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int hrs = 0;

            for (int i = 0; i < piles.length; i++) {
                hrs += Math.ceil((double) piles[i] / mid);
            }

            if (hrs > h) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

}
