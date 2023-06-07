package Prob5;
import java.util.*;

/**
 * This code demonstrates computation of power set
 * using recursion with backtracking.
 * 
 * The computePowerSet method in BinaryTreeSet (in this package)
 * does the same steps, explicitly using a BinaryTree and
 * outputting the values in the leaf nodes.
 * @author corazza
 *
 */
public class PowerSet2 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		PowerSet2 pow = new PowerSet2();
		pow.powerset(a);
		System.out.println("The power set of " + a + " is \n" + "  "+pow.retVal);
	}
	List<List<Integer>> retVal = new ArrayList<>();
	List<Integer> input = null;
	public void powerset(List<Integer> list) {
		input = list;
		List<Integer> temp = new ArrayList<>();
		powerset(0, temp);
	}
	public void powerset(int pos, List<Integer> temp) {
		if(pos == input.size()) {
			//add a copy of temp to retVal
			ArrayList<Integer> copyOfTemp = new ArrayList<Integer>(temp);
			retVal.add(copyOfTemp);
			return;
		}
		powerset(pos+1, temp);
		temp.add(input.get(pos));
		powerset(pos+1,temp);
		temp.remove(input.get(pos));
		return;	
	}
		
	
}
