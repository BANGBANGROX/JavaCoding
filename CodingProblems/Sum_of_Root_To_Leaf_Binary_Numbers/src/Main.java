import java.util.Scanner;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    private int ans;

    private int binaryToDecimal(String num) {
        int result = 0;
        int n = num.length();

        for (int i = 0; i < n; ++i) {
            result = result * 2 + (num.charAt(i) - '0');
        }

        System.out.println(result);

        return result;
    }

    private void sumRootToLeafUtil(TreeNode root, String curr) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans += binaryToDecimal(curr + root.val);
            return;
        }

        sumRootToLeafUtil(root.left, curr + root.val);
        sumRootToLeafUtil(root.right, curr + root.val);
    }

    public int sumRootToLeaf(TreeNode root) {
       ans = 0;
       String curr = "";

       sumRootToLeafUtil(root, curr);

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
