package com.horizon.act;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ItTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            List<Integer> t = new ArrayList<Integer>();
            result.add(t);
            int size = nodes.size();
            for(int i = 0; i < size; i++) {
                TreeNode tn = nodes.poll();
                t.add(tn.val);
                if(tn.left != null) {
                    nodes.add(tn.left);
                }
                if(tn.right != null) {
                    nodes.add(tn.right);
                }
            }
        }
        return result;
    }
}