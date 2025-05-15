import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private String[] words;
    private int[] groups;

    public List<String> getLongestSubsequence(final String[] words, final int[] groups) {
        this.words = words;
        this.groups = groups;
        final List<String> seqWithZero = getSubsequenceGivenStartingBit(0);
        final List<String> seqWithOne = getSubsequenceGivenStartingBit(1);

        return seqWithOne.size() > seqWithZero.size() ? seqWithOne : seqWithZero;
    }

    private List<String> getSubsequenceGivenStartingBit(final int startingBit) {
        int currentBit = startingBit;
        final List<String> result = new ArrayList<>();
        final int n = words.length;

        for (int i = 0; i < n; ++i) {
            if (groups[i] == currentBit) {
                result.add(words[i]);
                currentBit = 1 - currentBit;
            }
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final String[] words = new String[n];
           for (int i = 0; i < n; ++i) {
               words[i] = scanner.next();
           }
           final int[] groups = new int[n];
           for (int i = 0; i < n; ++i) {
               groups[i] = scanner.nextInt();
           }

           System.out.println(new Solution().getLongestSubsequence(words, groups));
       }
       
       scanner.close();
   }
}
