import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int matchPlayersAndTrainers(final int[] players, final int[] trainers) {
        final int m = players.length;
        final int n = trainers.length;
        int i = 0;
        int j = 0;
        final Thread thread1 = new Thread(() -> Arrays.sort(players));
        final Thread thread2 = new Thread(() -> Arrays.sort(trainers));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (final InterruptedException interruptedException) {
            throw new RuntimeException("Threading issue " +
                    interruptedException.getMessage(), interruptedException);
        }

        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                ++i;
            }
            ++j;
        }

        return i;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int m = scanner.nextInt();
           final int[] players = new int[m];
           for (int i = 0; i < m; ++i) {
               players[i] = scanner.nextInt();
           }
           final int n = scanner.nextInt();
           final int[] trainers = new int[n];
           for (int i = 0; i < n; ++i) {
               trainers[i] = scanner.nextInt();
           }

           System.out.println(new Solution().matchPlayersAndTrainers(players, trainers));
       }
       
       scanner.close();
   }
}
