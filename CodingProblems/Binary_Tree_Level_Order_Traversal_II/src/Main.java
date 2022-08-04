import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode currentNode = q.poll();
                assert currentNode != null;
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) q.add(currentNode.left);
                if (currentNode.right != null) q.add(currentNode.right);
            }
            ans.add(new ArrayList<>(currentLevel));
        }

        Collections.reverse(ans);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
