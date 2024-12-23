import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

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
    private int getMinSwaps(List<Integer> nums) {
        int result = 0;
        int n = nums.size();
        List<Integer> sortedNums = new ArrayList<>(nums);
        Map<Integer, Integer> numsIndexMap = new HashMap<>();

        Collections.sort(sortedNums);

        for (int i = 0; i < n; ++i) {
            numsIndexMap.put(nums.get(i), i);
        }

        for (int i = 0; i < n; ++i) {
            if (!Objects.equals(nums.get(i), sortedNums.get(i))) {
                ++result;
                int idx = numsIndexMap.get(sortedNums.get(i));
                numsIndexMap.put(nums.get(i), idx);
                nums.set(idx, nums.get(i));
            }
        }

        return result;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int answer = 0;

        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();
                assert node != null;
                nums.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            answer += getMinSwaps(nums);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);

       System.out.println(new Solution().minimumOperations(root));
   }
}
