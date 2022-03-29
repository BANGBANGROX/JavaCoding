import java.util.Scanner;

class NumArray {
    private static class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            sum = 0;
            left = right = null;
        }
    }

    SegmentTreeNode root;

    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        SegmentTreeNode currentNode = new SegmentTreeNode(start, end);

        if (start == end) {
            currentNode.sum = nums[start];
            return currentNode;
        }

        int mid = (start + ((end - start) >> 1));

        currentNode.left = buildTree(start, mid, nums);
        currentNode.right = buildTree(mid + 1, end, nums);

        currentNode.sum = currentNode.left.sum + currentNode.right.sum;

        return currentNode;
    }

    private void updateTree(SegmentTreeNode root, int index, int val) {
        if (root.start == index && root.end == index) {
            root.sum = val;
            return;
        }

        int mid = (root.start + ((root.end - root.start) >> 1));

        if (index <= mid) {
            updateTree(root.left, index, val);
        }
        else {
            updateTree(root.right, index, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    private int queryTree(SegmentTreeNode root, int left, int right) {
        if (root.start == left && root.end == right) return root.sum;

        int mid = (root.start + ((root.end - root.start) >> 1));

        if (right <= mid) return queryTree(root.left, left, right);

        if (left > mid) return queryTree(root.right, left, right);

        return queryTree(root.left, left, mid) + queryTree(root.right, mid + 1, right);
    }

    public NumArray(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }

    public void update(int index, int val) {
        updateTree(root, index, val);
    }

    public int sumRange(int left, int right) {
        return queryTree(root, left, right);
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
