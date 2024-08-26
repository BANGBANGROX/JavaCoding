import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private String addLeadingZeroes(String num) {
        int numLength = num.length();
        StringBuilder numBuilder = new StringBuilder(num);

        for (int i = 0; i < 8 - numLength; ++i) {
            numBuilder.insert(0, "0");
        }

        return numBuilder.toString();
    }

    private Set<String> generateNums(int num) {
        Set<String> result = new HashSet<>();
        char[] modifiedNum = addLeadingZeroes(String.valueOf(num)).toCharArray();

        result.add(new String(modifiedNum));

        for (int i = 0; i < 8; ++i) {
            for (int j = i + 1; j < 8; ++j) {
                char temp = modifiedNum[i];
                modifiedNum[i] = modifiedNum[j];
                modifiedNum[j] = temp;
                result.add(new String(modifiedNum));
                for (int nextI = 0; nextI < 8; ++nextI) {
                    for (int nextJ = nextI + 1; nextJ < 8; ++nextJ) {
                        temp = modifiedNum[nextI];
                        modifiedNum[nextI] = modifiedNum[nextJ];
                        modifiedNum[nextJ] = temp;
                        result.add(new String(modifiedNum));
                        temp = modifiedNum[nextI];
                        modifiedNum[nextI] = modifiedNum[nextJ];
                        modifiedNum[nextJ] = temp;
                    }
                }
                temp = modifiedNum[i];
                modifiedNum[i] = modifiedNum[j];
                modifiedNum[j] = temp;
            }
        }

        return result;
    }

    public int countPairs(int[] nums) {
        int answer = 0;
        Map<String, Integer> count = new HashMap<>();

        for (int num : nums) {
            Set<String> numsSet = generateNums(num);
            for (String numString : numsSet) {
                if (count.containsKey(numString)) {
                    answer += count.get(numString);
                }
            }
            String stringNum = addLeadingZeroes(String.valueOf(num));
            count.put(stringNum, count.getOrDefault(stringNum, 0) + 1);
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
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().countPairs(nums));
       }
       
       scanner.close();
   }
}
