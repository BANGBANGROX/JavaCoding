import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private Set<Integer> getNumsAfterSwappingDigits(int num) {
        Set<Integer> result = new HashSet<>();
        char[] numCharArray = String.valueOf(num).toCharArray();
        int n = numCharArray.length;

        result.add(num);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                char temp = numCharArray[i];
                numCharArray[i] = numCharArray[j];
                numCharArray[j] = temp;
                result.add(Integer.parseInt(new String(numCharArray)));
                temp = numCharArray[i];
                numCharArray[i] = numCharArray[j];
                numCharArray[j] = temp;
            }
        }

        return result;
    }

    public int countPairs(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Map<Integer, Set<Integer>> indexToNumsMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            indexToNumsMap.put(i, getNumsAfterSwappingDigits(nums[i]));
        }

        for (int i = 0; i < n; ++i) {
            Set<Integer> numsISet = indexToNumsMap.get(i);
            for (int j = i + 1; j < n; ++j) {
                Set<Integer> numsJSet = indexToNumsMap.get(j);
                boolean found = false;
                for (int num : numsJSet) {
                    if (num == nums[i]) {
                        found = true;
                        ++answer;
                        break;
                    }
                }
                if (!found) {
                    for (int num : numsISet) {
                        if (num == nums[j]) {
                            ++answer;
                            break;
                        }
                    }
                }
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
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().countPairs(nums));
       }
       
       scanner.close();
   }
}
