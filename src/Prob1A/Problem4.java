package Prob1A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem4 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(2, 1, 3, 5, 6, 2, 3, 4, 10));
        sort(list);
        for (int num : list) {
            System.out.printf(num + " ");
        }
        System.out.println();

        ArrayList<Integer> list2 = new ArrayList<>(List.of(2, 8, 9, 7, 6, 1, 4, 1, 3, 2, 6, 5, 7, 9, 8, 4));
        LinkedList<Integer> linkedList = new LinkedList<>(list2);
        sort(linkedList);
        for (int num : linkedList) {
            System.out.printf(num + " ");
        }
    }

    /**
     * Problem 4. Sorting. Do not use Java library sorting routines (since we need to be able to
     * analyze our own solutions).
     */

    /**
     * (A) You are given an ArrayList of Integer objects. Write a program that efficiently sorts the
     * list; use the following method signature:
     * Note that sorting is to be done in-place; this means that the original input list is modified
     * so that it becomes sorted.
     */
    public static void sort(ArrayList<Integer> list) {
        // implement
        if (list == null || list.size() <= 1) {
            return;
        }
        quicksort(list, 0, list.size() - 1);
    }

    private static void quicksort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(list, left, right);
            quicksort(list, left, partitionIndex - 1);
            quicksort(list, partitionIndex + 1, right);
        }
    }

    private static int partition(ArrayList<Integer> list, int left, int right) {
        int pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, right);
        return i + 1;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * (B) You are given a linked list containing Integer objects. Write a program that efficiently sorts
     * the list; use the following method signature.
     */
    public static void sort(LinkedList<Integer> list) {
        // implement
        if (list == null || list.size() <= 1) {
            return;
        }
        LinkedList<Integer> sortedList = mergeSort(list);
        list.clear();
        list.addAll(sortedList);
    }

    private static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        LinkedList<Integer> leftHalf = new LinkedList<>();
        LinkedList<Integer> rightHalf = new LinkedList<>();
        int mid = list.size() / 2;

        int i = 0;
        for (int item : list) {
            if (i < mid) {
                leftHalf.add(item);
            } else {
                rightHalf.add(item);
            }
            i++;
        }

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf, rightHalf);
    }

    private static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> mergedList = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peekFirst() <= right.peekFirst()) {
                mergedList.add(left.removeFirst());
            } else {
                mergedList.add(right.removeFirst());
            }
        }

        mergedList.addAll(left);
        mergedList.addAll(right);

        return mergedList;
    }
}
