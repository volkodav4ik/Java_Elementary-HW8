package com.volkodav4ik;

/*
2*) Написать метод для обьединения 2 бинарных дерева:
https://www.dropbox.com/s/lrblb3vjfi1qkwm/tree.png?dl=0
В качестве параметра передается 2 ссылки на корневые узлы девева TreeNode, результат - корневой узел нового дерева TreeNode.
*/

public class HW8T2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        TreeNode mergedTree = mergeTrees(t1, t2);
        System.out.println(printTree(t1));
        System.out.println(printTree(t2));
        System.out.println(printTree(mergedTree));
    }

    private static String printTree(TreeNode tree) {
        if (tree == null) {
            return "-";
        }
        String leftTree = printTree(tree.left);
        String rightTree = printTree(tree.right);
        return "(" + leftTree + tree.val + rightTree + ")";
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode mergedNode = new TreeNode(t1.val + t2.val);
        if (t1.left != null && t2.left != null) {
            mergedNode.left = mergeTrees(t1.left, t2.left);
        } else {
            if (t1.left == null && t2.left != null) {
                mergedNode.left = mergeTrees(new TreeNode(0), t2.left);
            } else {
                if (t1.left != null && t2.left == null) {
                    mergedNode.left = mergeTrees(t1.left, new TreeNode(0));
                }
            }
        }
        if (t1.right != null && t2.right != null) {
            mergedNode.right = mergeTrees(t1.right, t2.right);
        } else {
            if (t1.right == null && t2.right != null) {
                mergedNode.right = mergeTrees(new TreeNode(0), t2.right);
            } else {
                if (t1.right != null && t2.right == null) {
                    mergedNode.right = mergeTrees(t1.right, new TreeNode(0));
                }
            }
        }
        return mergedNode;
    }

}
