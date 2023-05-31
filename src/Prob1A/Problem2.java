package Prob1A;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{1, 4, 2, 3}));
        System.out.println(secondSmallest(new int[]{3, 3, 4, 7}));
        System.out.println(secondSmallest(new int[]{9}));
    }

    /**
     * Problem 2. Implement the following Java method.
     * This method returns the second-smallest element of the input array.
     * Examples
     * (A) If input is [1, 4, 2, 3], output should be 2.
     * (B) If input is [3, 3, 4, 7], output should be 3. (Smallest is 3, and second smallest is 3.)
     * (C) If input is [9], your program will throw an exception.
     */
    public static int secondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Input array too small");
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }
        return secondMin;
    }
}
