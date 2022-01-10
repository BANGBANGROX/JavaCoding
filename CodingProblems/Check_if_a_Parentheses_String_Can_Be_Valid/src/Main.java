import java.util.Scanner;

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if ((n & 1) != 0) return false;

        int lockedClosing = 0;
        int lockedOpening = 0;
        int free = 0;

        for (int i = 0; i < n; ++i) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') ++lockedClosing;
                else ++lockedOpening;
            }
            else ++free;
            if (lockedClosing > lockedOpening + free) return false;
        }

        lockedClosing = lockedOpening = free = 0;

        for (int i = n - 1; i >= 0; --i) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') ++lockedClosing;
                else ++lockedOpening;
            }
            else ++free;
            if (lockedOpening> lockedClosing + free) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            String locked = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.canBeValid(s, locked));
        }

        sc.close();
    }
}
