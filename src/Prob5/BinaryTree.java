package Prob5;

import java.util.*;

/**
 * Binary tree implementation. Supports static generation of a completely filled binary tree
 * along with a levels map and levels list.
 */
public class BinaryTree {
    Node root;
    HashMap<Node, Integer> levelsMap = new HashMap<>();
    HashMap<Integer, List<Node>> levelsList = new HashMap<>();
    int numLevels = 0;
    List<Node> visited = new ArrayList<>();
    List<Node> levels_visited = new ArrayList<>();

    BinaryTree(Integer val) {
        root = new Node(val);
    }

    BinaryTree(Node n) {
        root = n;
    }

    //empty tree
    BinaryTree() {
        //do nothing
    }

    public void addRight(Node n, Integer num) {
        if (n == null) return;
        if (n.rightChild != null)
            throw new IllegalArgumentException("Cannot add right child to node that " +
                    "already has a right child");
        n.rightChild = new Node(num);

    }

    public void addLeft(Node n, Integer num) {
        if (n == null) return;
        if (n.leftChild != null)
            throw new IllegalArgumentException("Cannot add left child to node that " +
                    "already has a left child");
        n.leftChild = new Node(num);
    }

    ///////////////////// traversal algorithms ///////////////////////


    /**
     * dfs pre-order algorithm
     */
    List<Node> visited_preorder = new ArrayList<>();

    public void dfs_preorder() {
        dfs_preorder(root);
    }

    private void dfs_preorder(Node n) {
        if (n == null) return;
        visited_preorder.add(n);
        dfs_preorder(n.leftChild);
        dfs_preorder(n.rightChild);
    }

    public void recur_levels() {
        recur_levels(root, 0);
    }

    /**
     * application of dfs pre-order traversal
     */
    public void recur_levels(Node n, int level) {
        if (n == null) return;
        levels_visited.add(n);
        levelsMap.put(n, level);
        List<Node> list = levelsList.get(level);
        if (list == null) {
            list = new LinkedList<>();
            ++numLevels;
        }
        list.add(n);
        levelsList.put(level, list);
        recur_levels(n.leftChild, level + 1);
        recur_levels(n.rightChild, level + 1);
    }

    /**
     * dfs find leaves algorithm
     */
    List<Node> visited_leaves = new ArrayList<>();

    public void dfs_findLeaves() {
        dfs_findLeaves(root);
    }

    private void dfs_findLeaves(Node n) {
        if (n == null) return;
        if (n.leftChild == null && n.rightChild == null) {
            visited_leaves.add(n);
        }
        dfs_findLeaves(n.leftChild);
        dfs_findLeaves(n.rightChild);
    }


    private HashMap<Node, Integer> depthsMap = new HashMap<>();

    public void recur_depths() {
        recur_depths(root, 0);
    }

    /**
     * application of dfs pre-order traversal
     */
    public void recur_depths(Node n, int depth) {
        if (n == null) return;
        depthsMap.put(n, depth);
        recur_depths(n.leftChild, depth + 1);
        recur_depths(n.rightChild, depth + 1);
    }

    /**
     * Finds leaf node with least depth
     */
    public Integer leastDepth() {
        recur_depths();
        Node leastLeaf = null;
        Set<Node> s = depthsMap.keySet();
        int minDepth = depthsMap.size();
        for (Node n : s) {
            if (n.leftChild == null && n.rightChild == null) {
                int depth = depthsMap.get(n);
                if (depth < minDepth) {
                    minDepth = depth;
                    leastLeaf = n;
                }

            }
        }
        return leastLeaf.key;
    }


    /**
     * DFS in-order traversal algorithm
     */

    List<Node> visited_inorder = new ArrayList<>();

    public void dfs_inorder() {
        dfs_inorder(root);
    }

    public void dfs_inorder(Node n) {
        if (n == null) return;
        dfs_inorder(n.leftChild);
        visited_inorder.add(n);
        dfs_inorder(n.rightChild);
    }

    public static BinaryTree generateFullTree(int numLevels) {
        if (numLevels < 1) return null;
        int numNodes = (int) Math.pow(2, numLevels) - 1;
        int[] tempValues = new int[numNodes];
        populateArray(tempValues);
        return buh(tempValues);
    }

    private static void populateArray(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i + 1;
        }
    }

    private static BinaryTree buh(int[] arr) {
        //base case
        if (arr.length == 0) return new BinaryTree();

        int k = arr[0];
        int m = (arr.length - 1) / 2;
        int[] arr1 = new int[m];
        int[] arr2 = new int[m];
        for (int i = 0; i < m; ++i) {
            arr1[i] = arr[i + 1];
            arr2[i] = arr[i + m + 1];
        }
        BinaryTree t1 = buh(arr1);
        //t1.printAsDiagram();
        BinaryTree t2 = buh(arr2);
        Node newRoot = new Node(k);
        return join(t1, newRoot, t2);
    }

    private static BinaryTree join(BinaryTree t1, Node joiner, BinaryTree t2) {

        BinaryTree retval = new BinaryTree(joiner);
        if (t1 == null || t1.root == null) return retval;
        Node root1 = t1.root;
        Node root2 = t2.root;
        retval.root.leftChild = root1;
        retval.root.rightChild = root2;
        root1.parent = retval.root;
        root2.parent = retval.root;
        return retval;

    }

    static class Node {
        Node(Integer key) {
            this.key = key;
        }

        Node leftChild;
        Node rightChild;
        Node parent;
        Integer key;

        public String toString() {
            return key.toString();
        }
    }


    public static void main(String[] args) {
//		BinaryTree t = generateFullTree(3);
//		t.printAsDiagram();
        BinaryTree t = new BinaryTree(6);
        t.addRight(t.root, 2);
        t.addLeft(t.root, 3);
        t.addRight(t.root.rightChild, 5);
        t.addLeft(t.root.rightChild, 7);
        //t.addLeft(t.root.leftChild,4);
        t.printAsDiagram();
        t.recur_levels();
        t.dfs_preorder();
        System.out.println("Preorder traversal : " + t.visited_preorder);
        t.dfs_inorder();
        System.out.println("Inorder traversal : " + t.visited_inorder);
        System.out.println("Levels map: " + t.levelsMap);
        System.out.println("Levels list: " + t.levelsList);
//		BinaryTree full = BinaryTree.generateFullTree(3);
//		full.printAsDiagram();
//		full.dfs_preorder();
//		System.out.println("Preorder traversal : " + full.visited_preorder);
//		System.out.println("Application of preorder traversal: levels");
//		full.recur_levels();
//		System.out.println("Levels map : " + full.levelsMap);
//		System.out.println("Levels list: " + full.levelsList);
//		System.out.println("Num levels = " + full.numLevels);
//		System.out.println("Levels visited = " + full.levels_visited);

//		BinaryTree full = BinaryTree.generateFullTree(3);
//		full.printAsDiagram();
//		full.dfs_inorder();
//		System.out.println("Inorder traversal : " + full.visited_inorder);
//		full.dfs_preorder();
//		System.out.println("Preorder traversal : " + full.visited_preorder);

//		BinaryTree full = BinaryTree.generateFullTree(4);
//		full.printAsDiagram();
//		System.out.println(full.allPaths());
//		full.recur_depths();
//		System.out.println(full.depthsMap);
//
    }

    /**
     * Prints to the console a visual representation of this
     * heap, relying on the nested class BTreePrinter
     */
    public void printAsDiagram() {
        BTreePrinter.printNode(root);
    }


    /**
     * Specialized nested class to produce
     * a visual image of this tree. This is
     * third-party code. To access the functionality
     * of this class, make a call to the static method
     * printNode like this:  printNode(root)
     */
    static class BTreePrinter {
        public static void printNode(Node root) {
            int maxLevel = BTreePrinter.maxLevel(root);
            printNodeInternal(
                    Collections.singletonList(root), 1, maxLevel);
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        private static void printNodeInternal(List nodes,
                                              int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;
            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
            BTreePrinter.printWhitespaces(firstSpaces);
            List newNodes = new ArrayList();
            for (Object node : nodes) {
                if (node != null) {
                    System.out.print(((Node) node).key);
                    newNodes.add(((Node) node).leftChild);
                    newNodes.add(((Node) node).rightChild);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (((Node) nodes.get(j)).leftChild != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (((Node) nodes.get(j)).rightChild != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        static int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.leftChild),
                    BTreePrinter.maxLevel(node.rightChild)) + 1;
        }

        @SuppressWarnings("rawtypes")
        static boolean isAllElementsNull(List list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }
    }
}
