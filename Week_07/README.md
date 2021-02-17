#学习笔记

##TRIE模版：

###Java
public class Trie {

	private boolean isEnd;
	private Trie[] next;
	
	/** Initialize your data structure here. */
	public Trie() {
		isEnd = false;
		next = new Trie[26];
	}
	
	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		Trie curr = this;
		char[] words = word.toCharArray();
		for (int i = 0; i < words.length; i++) {
			int n = words[i] - 'a';
			if (curr.next[n] == null) {
				curr.next[n] = new Trie();
			}
			curr = curr.next[n];
		}
		curr.isEnd = true;
	}
	
	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie node = searchPrefix(word);
		return node != null && node.isEnd;
	}
	
	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		Trie node = searchPrefix(prefix);
		return node != null;
	}
	
	private Trie searchPrefix(String word) {
		Trie node = this;
		char[] words = word.toCharArray();
		for (int i = 0;i < words.length;i++) {
			node = node.next[words[i] - 'a'];
			if (node == null) {
				return null;
			}
		}
		return node;
	}
}

##并查集模版

### Java
public class UnionFind {

    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

}

##DFS模版代码

###Java
public class Dfs {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root == null){
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> results) {
        if(results.size() == level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left != null) {
            travel(root.left,level+1,results);
        }
        if(root.right != null) {
            travel(root.right,level+1,results);
        }
    }

}

##BFS模版代码

###Java
public class Bfs {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
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

#树总结

##1.https://juejin.cn/post/6844903856778788878

##2.https://juejin.cn/post/6844903859974848520
