import java.util.ArrayList;
import java.util.List;

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
    private int answer;
    private int distance;

    private void update(List<Integer> nums) {
        for (int i = 0; i < nums.size(); ++i) {
            nums.set(i, nums.get(i) + 1);
        }
    }

    private List<Integer> countPairsHandler(TreeNode root) {
        if (root == null) return new ArrayList<>();

        if (root.left == null && root.right == null) return new ArrayList<>(List.of(1));

        List<Integer> left = countPairsHandler(root.left);
        List<Integer> right = countPairsHandler(root.right);

        if (!left.isEmpty() && !right.isEmpty()) {
            for (int distance1 : left) {
                for (int distance2 : right) {
                    if (distance1 + distance2 <= distance) {
                        ++answer;
                    }
                }
            }
        }

        update(left);
        update(right);
        left.addAll(right);

        return left;
    }

    public int countPairs(TreeNode root, int distance) {
        answer = 0;
        this.distance = distance;

        countPairsHandler(root);

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
