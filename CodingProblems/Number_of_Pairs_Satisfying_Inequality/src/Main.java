import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    private long[] tree;

    private void update(int i, int l, int r, int j) {
        if (l == r) {
            ++tree[i];
            return;
        }

        int mid = (l + r) / 2;

        if (j <= mid) update(2 * i + 1, l, mid, j);
        else update(2 * i + 2, mid + 1, r, j);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    private long query(int i, int l, int r, int x, int y) {
        if (l >= x && r <= y) return tree[i];

        if (l > y || r < x) return 0;

        int mid = (l + r) / 2;

        return query(2 * i + 1, l, mid, x, y) + query(2 * i + 2, mid + 1, r, x, y);
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        TreeSet<Integer> st = new TreeSet<>();

        for (int i = 0; i < n; ++i) {
            st.add(nums1[i] - nums2[i]);
            st.add(nums1[i] - nums2[i] + diff);
        }

        int treeSize = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int x: st) {
            mp.put(x, treeSize);
            ++treeSize;
        }

        tree = new long[4 * treeSize + 5];
        long ans = 0;

        for (int i = n - 1; i >= 0; --i) {
            ans += query(0, 0, treeSize - 1,
                    mp.get(nums1[i] - nums2[i]), treeSize - 1);
            update(0, 0, treeSize - 1, mp.get(nums1[i] - nums2[i] + diff));
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; ++i) {
                nums2[i] = sc.nextInt();
            }
            int diff = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numberOfPairs(nums1, nums2, diff));
        }

        sc.close();
    }
}
