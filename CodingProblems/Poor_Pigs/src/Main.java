import java.util.Scanner;

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int buckets = sc.nextInt();
            int minutesToDie = sc.nextInt();
            int minutesToTest = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.poorPigs(buckets, minutesToDie, minutesToTest));
        }

        sc.close();
    }
}
