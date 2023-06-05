package Prob2B;

public class Problem5 {

    public int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
      A. Specify a best case and a worst case for BubbleSort.
       - Best case scenario: ascending sorted array
       - Worst case scenario: descending sorted array
     */

    /*
      B. What are the best-case and worst-case running times for BubbleSort?
       - Best case running time: O(n^2)
       - Worst case running time: O(n^2)
     */

    /**
     * C. Modify BubbleSort so that it has a best-case running time of O(n). Call your
     * modified version BubbleSort1. Use the sort environment to verify that your
     * modified version runs faster
     */
    public int[] bubbleSort1(int[] arr) {
        int len = arr.length;
        boolean swappedOnPrevRun = true;
        while (swappedOnPrevRun) {
            swappedOnPrevRun = false;
            for (int i = 0; i < len - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swappedOnPrevRun = true;
                    swap(arr, i, i + 1);
                }
            }
        }
        return arr;
    }

    /*
      D. Prove BubbleSort is correct (you may use your updated version for this if you
      want). Hint: Show that after the loop with i = 0, the element in position n – 1
      is in final sorted order; after i = 1, the last two elements arr[n-2], arr[n-1] are
      in final sorted order. In general, after pass i, the elements arr[n-i-1]..arr[n-1]
      are in final sorted order.
      <answer>
       Let I(i) be the statement the elements arr[n-i-1]..arr[n-1] are in final sorted order.
       Claim: After pass #i, I(i) is true
       Base case i = 0:
           After pass #0, arr[n - 1] is in final sorted order, it is the largest element in the array
       Induction step:
           Assume I(i) is true after pass #i, for 1 <= i < n - 1, arr[n - i - 1]..arr[n - 1] are in final sorted order
           After pass #i+1, arr[n - i - 2] is put in correct sorted order.
           Thus, I(i + 1) is correct. arr[n - (i + 1) - 1]..arr[n - 1] are in final sorted order
           This proves the claim.
     */

    /*
    E. Show that BubbleSort is inversion-bound (you can use either version of the algorithm here).
    <answer>
        Suppose A is an input array of distinct integers, i<j, and A[i] > A[j] (in other words, (A[i], A[j]) is an inversion in A).
        Suppose X is an integer between A[i] and A[j], A[i]->X->A[j], there are 2 cases:
            X < A[i]
                Step 1: A[i] and X will swap places with each other, resulting in X->A[i]->A[j]
                Step 2: A[i] and A[j] will swap places with each other
            X > A[i]
                Step 1: X and A[j] will swap places with each other, resulting in A[i]->A[j]->X
                Step 2: A[i] and A[j] will swap places with each other
        In conclusion, at some point, bubble sort will perform a comparison of A[i] and A[j] and then will swap A[i], A[j]
        Hence, bubble sort is an inversion-bound sorting algorithm.
     */

}
