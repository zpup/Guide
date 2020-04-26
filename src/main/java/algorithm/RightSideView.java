package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode() {
            left = null;
            right = null;
        }
    }

    static final int[] TREE_VALUE = new int[]{1, 2, 3, 0, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 8, 0, 9, 10, 0, 0, 0};
    static int index = 0;


    public static TreeNode createTree(TreeNode node, int i) {
        if (0 == TREE_VALUE[i]) {
            return null;
        } else {
            node.val = TREE_VALUE[i];
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++index);

        return node;
    }

    public static void main(String[] args) {
        System.out.println(rightSideView(createTree(new TreeNode(), index)));
    }

    static List<Integer> list = new ArrayList<Integer>();

    public static List<Integer> rightSideView(TreeNode root) {

        search(root, 0);

        return list;
    }

    public static List<Integer> search(TreeNode root, int depth) {
        if (null == root) {
            return null;
        }

        if (depth == list.size()) {
            list.add(root.val);
            System.out.println("计入"+list);
        }
        System.out.println("未计入"+root.val);
        depth++;
        search(root.right, depth);
        search(root.left, depth);
        return list;
    }
}
