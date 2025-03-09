import java.util.Scanner;

class Solution {
    public int numberOfAlternatingGroups(final int[] colors, final int k) {
        final int n = colors.length;
        final int circularLength = n + k - 1;
        final int[] circularColors = new int[circularLength];
        final int[] alternatingPrefix = new int[circularLength];
        int answer = 0;
        int left = 0;
        int right = k - 1;

        System.arraycopy(colors, 0, circularColors, 0, n);
        System.arraycopy(colors, 0, circularColors, n, k - 1);

        alternatingPrefix[0] = 1;

        for (int i = 1; i < circularLength; ++i) {
            if (circularColors[i] != circularColors[i - 1]) {
                alternatingPrefix[i] = alternatingPrefix[i - 1] + 1;
            } else {
                alternatingPrefix[i] = 1;
            }
        }

        while (right < circularLength) {
            if (alternatingPrefix[right] - alternatingPrefix[left] == k - 1) {
                ++answer;
            }
            ++left;
            ++right;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] colors = new int[n];
           final int k = scanner.nextInt();
           for (int i = 0; i < n; ++i) {
               colors[i] = scanner.nextInt();
           }

           System.out.println(new Solution().numberOfAlternatingGroups(colors, k));
       }
       
       scanner.close();
   }
}
