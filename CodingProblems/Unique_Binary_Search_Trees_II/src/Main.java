import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
           return generateTrees(1, n);
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
