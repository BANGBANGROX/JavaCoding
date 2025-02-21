import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class FindElements {
    private final Set<Integer> visited;

    public FindElements(TreeNode root) {
        visited = new HashSet<>();

        buildTree(root, 0);
    }

    public boolean find(int target) {
        return visited.contains(target);
    }

    private void buildTree(TreeNode root, int val) {
        if (root == null) return;

        visited.add(val);

        buildTree(root.left, 2 * val + 1);
        buildTree(root.right, 2 * val + 2);
    }
}

public class Main {
   public static void main(String[] args) {
       TreeNode root = new TreeNode(-1);
       root.left = new TreeNode(-1);
       root.right = new TreeNode(-1);

       FindElements findElements = new FindElements(root);

       System.out.println(findElements.find(0));
       System.out.println(findElements.find(1));
   }
}
