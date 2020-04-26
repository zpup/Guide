package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();

        if (root == null)
            return list;
        //压入根节点
        stack.push(root);
        //然后就循环取出和压入节点，直到栈为空，结束循环
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t.right != null)
                stack.push(t.right);
            if (t.left != null)
                stack.push(t.left);
            list.add(t.val);
        }
        return list;
    }

    public List<Integer>  recursion(TreeNode root){
        List<Integer> list = new LinkedList<Integer>();
        dfs(list,root);
        return list;
    }
    private void dfs(List<Integer> list, TreeNode node) {
        if (node != null) {
            list.add(node.val);

            //每次先添加左节点，直到没有子节点点，返回上一级
            dfs(node.left);
            dfs(node.right);
        }
    }

}


