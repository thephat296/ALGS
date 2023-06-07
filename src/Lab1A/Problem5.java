package Lab1A;

import java.util.HashSet;
import java.util.Set;

public class Problem5 {

    public static void main(String[] args) {
        System.out.println(find(new int[] {2, 8, 3, 4}, 3));
        System.out.println(find(new int[] {2, 8, 3, 4}, 5));
        System.out.println(find2(new int[] {2, 3, 4, 8}, 3));
        System.out.println(find2(new int[] {2, 3, 4, 8}, 5));
    }

    /**
     * Problem 5. Searching. Given an array arr of ints and an int z.
     * (A) Determine whether z is in arr.
     * Use the following method signature:
     * Examples
     * (A) If input is [2, 8, 3, 4], 3, output should be true.
     * (B) If input is [2, 8, 3, 4], 5, output should be false.
     * (C) If input is [2, 3, 4, 8], 3, output should be true.
     * (D) If input is [2, 3, 4, 8], 5, output should be false.
     */
    public static boolean find(int[] arr, int z) {
        // implement
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(z)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * (B) Suppose the array arr is already known to be in sorted order. Can you write a more efficient
     *      * program for determining whether z is in arr? If yes, why do you think your solution to (B)
     *      * is faster?
     */
    public static boolean find2(int[] arr, int z) {
        // implement
        int left = 0;
        int right = arr.length - 1;
        int mid = (right - left) / 2 + left;
        while (right >= left) {
            if (arr[mid] == z) {
                return true;
            }
            if (arr[mid] > z) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }
        return false;
    }
}
