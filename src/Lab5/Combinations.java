package Lab5;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        Combinations com = new Combinations();
        com.combinations(a, 3);
        System.out.println("The subsets of " + a + " of size 3 are: \n" + "  " + com.retVal);
    }

    List<List<Integer>> retVal = new ArrayList<>();
    List<Integer> input = null;

    public void combinations(List<Integer> list, int size) {
        input = new ArrayList<>();
        combinations(list, size, 0);
    }

    private void combinations(List<Integer> nums, int size, int start) {
        if (input.size() == size) {
            retVal.add(new ArrayList<>(input));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            input.add(nums.get(i));
            combinations(nums, size, i + 1);
            input.remove(input.size() - 1);
        }
    }
}
