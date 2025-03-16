import java.util.Scanner;

class Solution {
    private int[] ranks;
    private int cars;

    private boolean check(long val) {
        long totalCars = 0;

        for (int rank : ranks) {
            totalCars += (int) Math.sqrt((double) val / rank);
            if (totalCars >= cars) return true;
        }

        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        this.ranks = ranks;
        this.cars = cars;
        long left = 1;
        long right = (long) 1e14;
        long answer = -1;

        while (left <= right) {
            long mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] ranks = new int[n];
           for (int i = 0; i < n; ++i) {
               ranks[i] = scanner.nextInt();
           }
           int cars = scanner.nextInt();

           System.out.println(new Solution().repairCars(ranks, cars));
       }
       
       scanner.close();
   }
}
