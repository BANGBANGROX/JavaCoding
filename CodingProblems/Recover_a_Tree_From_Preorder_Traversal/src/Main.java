import java.util.Scanner;
import java.util.Stack;

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
    public TreeNode recoverFromPreorder(String traversal) {
        int n = traversal.length();
        Stack<TreeNode> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            int level = 0;
            while (traversal.charAt(i) == '-') {
                ++level;
                ++i;
            }
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + traversal.charAt(i) - '0';
                ++i;
            }
            --i;
            TreeNode root = new TreeNode(val);
            if (st.empty()) {
                st.push(root);
                continue;
            }
            while (level < st.size()) st.pop();
            if (st.peek().left == null) st.peek().left = root;
            else st.peek().right = root;
            st.push(root);
        }

        while (st.size() > 1) {
            st.pop();
        }

        return st.peek();
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
