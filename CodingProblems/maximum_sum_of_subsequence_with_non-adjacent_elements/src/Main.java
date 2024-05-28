import java.util.Scanner;

class Solution {
    private static class SegmentTree {
        SegmentTree leftNode;
        SegmentTree rightNode;
        int left;
        int right;
        int[][] result;

        SegmentTree(int left, int right, int[] nums) {
            this.left = left;
            this.right = right;
            result = new int[2][2];

            if (left < right) {
                int mid = (left + ((right - left) >> 1));
                leftNode = new SegmentTree(left, mid, nums);
                rightNode = new SegmentTree(mid + 1, right, nums);
                combineLeftAndRightNodes();
            } else {
                result[0][0] = 0;
                result[0][1] = result[1][0] = -1 * (int) 1e9;
                result[1][1] = nums[left];
            }
        }

        private void combineLeftAndRightNodes() {
            result[0][0] = Math.max(leftNode.result[0][0] + rightNode.result[0][0], Math.max(leftNode.result[0][1] + rightNode.result[0][0], leftNode.result[0][0] + rightNode.result[1][0]));
            result[0][1] = Math.max(leftNode.result[0][0] + rightNode.result[0][1], Math.max(leftNode.result[0][1] + rightNode.result[0][1], leftNode.result[0][0] + rightNode.result[1][1]));
            result[1][0] = Math.max(leftNode.result[1][0] + rightNode.result[0][0], Math.max(leftNode.result[1][1] + rightNode.result[0][0], leftNode.result[1][0] + rightNode.result[1][0]));
            result[1][1] = Math.max(leftNode.result[1][0] + rightNode.result[0][1], Math.max(leftNode.result[1][1] + rightNode.result[0][1], leftNode.result[1][0] + rightNode.result[1][1]));
        }

        public void update(int idx, int value) {
            if (idx > right || idx < left) {
                return;
            }

            if (left == right) {
                result[1][1] = value;
                result[0][0] = 0;
                return;
            }

            leftNode.update(idx, value);
            rightNode.update(idx, value);
            combineLeftAndRightNodes();
        }
    }

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        SegmentTree segmentTree = new SegmentTree(0, nums.length - 1, nums);
        long answer = 0;
        final int MOD = (int) 1e9 + 7;

        for (int[] query : queries) {
            segmentTree.update(query[0], query[1]);
            answer = (answer + Math.max(segmentTree.result[0][0], Math.max(segmentTree.result[0][1], Math.max(segmentTree.result[1][0], segmentTree.result[1][1])))) % MOD;
        }

        return (int) answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int q = sc.nextInt();
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; ++i) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }

            System.out.println(new Solution().maximumSumSubsequence(nums, queries));
        }

        sc.close();
    }
}
