package Prob3B;


public class Problem5 {

    /*
    Does the same technique solve the corresponding ThirdSmallest problem in O(n) time?
    ==> Yes

    What if "second" and "third" are replaced by "kth", where k represents any number from 2 to n1?
    For instance, is there a fast algorithm for finding the n/2-smallest element in a list of n elements?
    Is the sorting approach the fastest way in this case?
    ==> use quick-select algorithm.
     */
    public static int findKthSmallestElement(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    public static int quickSelect(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }

        int pivotIndex = partition(arr, start, end);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, start, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, end);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
