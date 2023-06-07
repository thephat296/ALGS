package Lab5;

import java.util.List;

public class BSTSort {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 1;
        arr[4] = 5;
        int[] sortedArr = sort(arr);
        for (int num : sortedArr) {
            System.out.printf(num + " ");
        }
    }
    public static int[] sort(int[] arr) {
        MyBST bst = new MyBST();
        for (int num : arr) {
            bst.insert(num);
        }
        List<Integer> sortedList = bst.printTree();
        int[] result = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++) {
            result[i] = sortedList.get(i);
        }
        return result;
    }
}

