import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean reorderedPowerOf2(final int n) {
        final char[] numString = String.valueOf(n).toCharArray();

        Arrays.sort(numString);

        do {
            if (numString[0] != '0' && isPowerOf2(Integer.parseInt(new String(numString)))) {
                return true;
            }
        } while (nextPermutation(numString));

        return false;
    }

    private boolean nextPermutation(final char[] chars) {
        final int n = chars.length;
        int last = n - 2;

        while (last >= 0 && chars[last] >= chars[last + 1]) {
            --last;
        }

        if (last < 0) {
            return false;
        }

        int nextIndex = n - 1;

        for (int i = n - 1; i > last; --i) {
            if (chars[last] < chars[i]) {
                nextIndex = i;
                break;
            }
        }

        char temp = chars[last];
        chars[last] = chars[nextIndex];
        chars[nextIndex] = temp;

        reverse(chars, last + 1, n - 1);

        return true;
    }

    private boolean isPowerOf2(final int num) {
        return (num & (num - 1)) == 0;
    }

    private void reverse(final char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            ++left;
            --right;
        }
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().reorderedPowerOf2(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
