package Lab3B;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(
                reverseList(List.of(1, 2, 3, 4, 5))
        );
    }

    /**
     * Running time, computed by counting self-calls is O(n)
     */
    public static List<Integer> reverseList(List<Integer> list) {
        int lastIndex = list.size() - 1;
        return reverseListHelper(list.subList(0, lastIndex), list.get(lastIndex));
    }

    private static List<Integer> reverseListHelper(List<Integer> list, int right) {
        if (list.isEmpty()) return List.of(right);
        int lastIndex = list.size() - 1;
        List<Integer> leftList = reverseListHelper(list.subList(0, lastIndex), list.get(lastIndex));
        List<Integer> result = new ArrayList<>();
        result.add(right);
        result.addAll(leftList);
        return result;
    }
}
