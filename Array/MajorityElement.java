package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        // int[] arr = { 11, 33, 33, 11, 33, 11, 12, 12 };
        int[] arr = { 11, 33, 23, 11, 33, 11, 11, 11 };
        // int[] arr = { 1, 2 };
        List<Integer> majorityNby3 = getMajorityElementsOptimal(arr);
        System.out.println(majorityNby3);
        System.out.println(majorityNby2(arr));
    }

    // Better Approach
    public static List<Integer> getMajorityElements(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();

        int nBy3 = (int) Math.floor(arr.length / 3);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 0);

            if (map.get(arr[i]) == nBy3) {
                res.add(arr[i]);
            }

            if (res.size() == 2)
                break;
        }

        return res;
    }

    // Optimal Approach
    public static List<Integer> getMajorityElementsOptimal(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el1)
                cnt1++;
            else if (arr[i] == el2)
                cnt2++;
            else if (cnt1 == 0) {
                el1 = arr[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                el2 = arr[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        int el1Cnt = 0, el2Cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el1)
                el1Cnt++;

            if (arr[i] == el2)
                el2Cnt++;

        }
        if (el1Cnt > (arr.length / 3))
            res.add(el1);
        if (el2Cnt > (arr.length / 3))
            res.add(el2);

        return res;
    }

    public static int majorityNby2(int[] arr) {
        int el = arr[0], count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                el = arr[i];
                count = 1;
            } else if (arr[i] == el)
                count++;
            else
                count--;
        }

        int elCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el)
                elCnt++;

            if (elCnt > (arr.length / 2))
                return el;
        }

        return -1;
    }
}
