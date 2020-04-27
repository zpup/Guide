package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 广度搜索 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();

        if (root == null)
            return list;
        //跟节点放入队列中
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            //从左至右放入节点。
            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);

            list.add(node.val);
        }
        return list;

    }
}
