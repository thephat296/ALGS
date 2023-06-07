package Lab3A;

import java.util.Arrays;

public class Problem4 {

    /**
     * O(nlogn) time
     */
    public int[] mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
        return arr;
    }

    private void divide(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        divide(arr, left, mid);
        divide(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftList = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightList = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, index = left;
        while (i < leftList.length && j < rightList.length) {
            if (leftList[i] < rightList[j]) {
                arr[index++] = leftList[i++];
            } else {
                arr[index++] = rightList[j++];
            }
        }
        while (i < leftList.length) {
            arr[index++] = leftList[i++];
        }
        while (j < rightList.length) {
            arr[index++] = rightList[j++];
        }
    }
}
