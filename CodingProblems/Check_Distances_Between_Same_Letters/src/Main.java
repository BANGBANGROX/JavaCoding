import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] index = new int[26];

        Arrays.fill(index, -1);

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (index[ch - 'a'] != -1) {
                if (distance[ch - 'a'] != (i - index[ch - 'a'] - 1))
                    return false;
            }
            index[ch - 'a'] = i;
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
            int[] distance = new int[26];
            for (int i = 0; i < 26; ++i) {
                distance[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.checkDistances(s, distance));
        }

        sc.close();
    }
}
