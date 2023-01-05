import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static class SegmentTree {
        private final int[] tree;
        private final int[] nums;
        private final int n;

        SegmentTree(int[] nums) {
            this.nums = nums.clone();
            n = nums.length;
            tree = new int[4 * n + 1];

            build(1, 0, n - 1);
        }

        private void build(int idx, int start, int end) {
            if (start == end) {
                tree[idx] = nums[start];
                return;
            }

            int mid = (start + ((end - start) >> 1));

            build(2 * idx, start, mid);
            build(2 * idx + 1, mid + 1, end);

            tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
        }

        private int query(int idx, int start, int end, int l, int r) {
            if (start > r || end < l) return Integer.MIN_VALUE;

            if (start == end || start >= l && end <= r) return tree[idx];

            int mid = (start + ((end - start) >> 1));
            int left = query(2 * idx, start, mid, l, r);
            int right = query(2 * idx + 1, mid + 1, end, l, r);

            return Math.max(left, right);
        }

        int query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }

        SegmentTree obj = new SegmentTree(arr);

        int q = Integer.parseInt(read.readLine());

        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            String[]inp = read.readLine().split(" ");

            int l = Integer.parseInt(inp[0]);
            int r = Integer.parseInt(inp[1]);

            int ans = obj.query(l, r);
            out.append(ans);
            out.append("\n");
        }

        System.out.println(out);
    }
}