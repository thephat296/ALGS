package Lab2B;

public class Problem6 {

    /**
     * 6. Interview Question. An array A holds n integers, and all integers in A belong to the
     * set {0, 1, 2}. Describe an O(n) sorting algorithm for putting A in sorted order. Your
     * algorithm may not make use of auxiliary storage such as arrays or hashtables (more
     * precisely, the only additional space used, beyond the given array, is O(1)). Give an
     * argument to explain why your algorithm runs in O(n) time.
     */
    public int[] sort(int[] arr) {
        int LENGTH = 3;
        int[] count = new int[LENGTH];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 0, j = 0; i < LENGTH; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }
        return arr;
    }
}
