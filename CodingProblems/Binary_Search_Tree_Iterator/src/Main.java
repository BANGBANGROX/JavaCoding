import com.sun.source.tree.Tree;

import java.util.ArrayList;
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

class BSTIterator {
    private final ArrayList<Integer> inorder;
    private int ptr;

    private void setInorder(TreeNode root) {
        if (root == null) return;

        setInorder(root.left);

        inorder.add(root.val);

        setInorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        ptr = -1;

        setInorder(root);
    }

    public int next() {
       ++ptr;

       return inorder.get(ptr);
    }

    public boolean hasNext() {
         return inorder.size() == 0 || ptr != inorder.size() - 1;
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
