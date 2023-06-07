package Lab2A;

public class Problem2 {

    /**
     * Determine the asymptotic running time of the following procedure (an exact
     * computation of number of basic operations is not necessary):
     */
    int[] arrays(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                arr[i] += arr[j] + i + j;
            }
        }
        return arr;
    }
    /*
      First loop: O(n)
      Second loop nested: O(n^2)
      Asymptotic running time: O(n) + O(n^2) = O(n^2)
     */
}
