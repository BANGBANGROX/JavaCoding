import java.util.Scanner;

class Solution {
    private boolean check(String s, int partitions, int k) {
        StringBuilder currentNum = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if ((ch - '0') > k) return false;
            if (Long.parseLong(currentNum.toString() + ch) > k) {
                --partitions;
                if (partitions == 0) return false;
                currentNum = new StringBuilder();
            }
            currentNum.append(ch);
        }

        return true;
    }

    public int minimumPartition(String s, int k) {
        int n = s.length();
        int l = 1;
        int r = n;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(s, mid, k)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumPartition(s, k));
        }

        sc.close();
    }
}
