import java.util.*;

class Solution {
    private HashSet<Integer> nums;

    private void generateNumbers(int len, int previousDigit, String currentNumber) {
           if (currentNumber.length() == len) {
               nums.add(Integer.parseInt(currentNumber));
               return;
           }

           if (previousDigit == 9) return;

           currentNumber += (previousDigit + 1);
           generateNumbers(len, previousDigit + 1, currentNumber);
    }

    public List<Integer> sequentialDigits(int low, int high) {
           int minLength = String.valueOf(low).length();
           int maxLength = String.valueOf(high).length();
           List<Integer> ans = new ArrayList<>();

           nums = new HashSet<>();

           for (int len = minLength; len <= maxLength; ++len) {
                String currentNumber = "";
                for (int digit = 1; digit <= 10 - len; ++digit) {
                    generateNumbers(len, digit, currentNumber + digit);
                }
           }

           for (int num : nums) {
               if (num >= low && num <= high) {
                   ans.add(num);
               }
           }

           Collections.sort(ans);

           return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
