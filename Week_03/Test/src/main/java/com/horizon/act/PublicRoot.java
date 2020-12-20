package com.horizon.act;

import com.horizon.dto.BinaryTree;
import com.horizon.dto.TreeNode;

/**
 * @title: PublicRoot
 * @Author horizon
 * @Date: 2020/12/20 23:25
 * @Version 1.0
 */
public class PublicRoot {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        BinaryTree dataTree = new BinaryTree(data);
        TreeNode root = dataTree.root;
        TreeNode result = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(result.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode == null) {
            return rightNode;
        }
        if(rightNode == null) {
            return leftNode;
        }
        return root;
    }
}
