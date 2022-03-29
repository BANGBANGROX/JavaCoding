import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int ans = 0;
        int l = 0;
        int r = n - 1;

        Arrays.sort(people);

        while (l <= r) {
            ++ans;
            if (people[l] + people[r] <= limit) {
                ++l;
            }
            --r;
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
            int[] people = new int[n];
            for (int i = 0; i < n; ++i) {
                people[i] = sc.nextInt();
            }
            int limit = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.numRescueBoats(people, limit));
        }

        sc.close();
    }
}
