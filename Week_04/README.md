public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

# DFS 深度优先搜索 - java
public class Dfs {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root == null) {
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> results) {
        if(results.size() == level) {
            results.add(new ArrayList<>());
        }
        // process
        results.get(level).add(root.val);
        // deep
        if(root.left != null) {
            travel(root.left, level + 1, results);
        }
        if(root.right != null) {
            travel(root.right, level + 1, results);
        }
    }

}

# BFS 广度优先搜索 - java
public class Bfs {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> allResults = new ArrayList<>();
        
        if (root == null) {
            return allResults;
        }
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        
        return allResults;
    }

}
# 二分查找的前提条件：
1.目标函数单调性（单调递增或者递减）
2.存在上下界（bounded）
3.能够通过索引访问（index accessible）

# 二分查找代码模版
public class BinaryTemplate {

    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
    
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    
        return -1;
    }

}
# 牛顿迭代暂时没有看懂