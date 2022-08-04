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

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {
    ArrayList<Integer> nums;

    private TreeNode generateTree(int start, int end) {
        if (start > end) return null;

        int mid = (start + ((end - start) >> 1));

        TreeNode root = new TreeNode(nums.get(mid));

        root.left = generateTree(start, mid - 1);
        root.right = generateTree(mid + 1, end);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        return generateTree(0, nums.size() - 1);
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
