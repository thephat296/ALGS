package Lab2A;

public class Problem3 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 5, 8, 17};
        int[] arr2 = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
        int[] result = merge(arr1, arr2);
        for (int num : result) {
            System.out.printf(num + " ");
        }
    }

    /*
      Consider the following problem: As input you are given two sorted arrays of integers.
      Your objective is to design an algorithm that would merge the two arrays together to
      form a new sorted array that contains all the integers contained in the two arrays. For
      example, on input
      [1, 4, 5, 8, 17], [2, 4, 8, 11, 13, 21, 23, 25]
      the algorithm would output the following array:
       [1,2,4,4,5,8,8, 11, 13, 17, 21, 23, 25]
     */

    /*
      A. Design an algorithm Merge to solve this problem and write your algorithm
      description using the pseudo-code syntax discussed in class.
      <p>
      Algorithm merge(arr1, arr2)
       Input: two sorted array
       Output: a new sorted array combined of arr1 and arr2
       n <- arr1.length
       m <- arr2.length
       i <- 0
       j <- 0
       index <- 0
       ans <- new Int[n + m]
       while i < n && j < m do
       	if arr1[i] < arr2[j] then
      		    ans[index] = arr1[i]
      		    index <- index + 1
      		    i <- i + 1
      	    else
      		    ans[index] = arr2[j]
      		    index <- index + 1
      		    j <- j + 1
       while i < n do
      	    ans[index] = arr1[i]
      	    index <- index + 1
      	    i <- i + 1
       while j < m do
      	    ans[index] = arr2[j]
      	    index <- index + 1
      	    j <- j + 1
      return ans
     */

    /*
      B. Examining your pseudo-code, determine the asymptotic running time of this
      merge algorithm. Here, let n denote the sum of the lengths of the two arrays:
       n = arr1.length + arr2.length
       Asymptotic running time is O(n) cause we loop all elements of arr1 and arr2 once
     */

    /**
     * C. Implement your pseudo-code as a Java method merge having the following
     * signature:
     * int[] merge(int[] arr1, int[] arr2)
     * Be sure to test your method in a main method to be sure it really works!
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                ans[index] = arr1[i];
                index++;
                i++;
            } else {
                ans[index] = arr2[j];
                index++;
                j++;
            }
        }
        while (i < n) {
            ans[index] = arr1[i];
            index++;
            i++;
        }
        while (j < m) {
            ans[index] = arr2[j];
            index++;
            j++;
        }
        return ans;
    }
}
