import java.util.Scanner;
import java.util.List;

class Solution {
    private List<Integer> nums;
    private int n;

    private int findDominantElement() {
        int cnt = 1;
        int result = nums.getFirst();

        for (int i = 1; i < n; ++i) {
            if (nums.get(i) == result) {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    result = nums.get(i);
                    ++cnt;
                }
            }
        }

        return result;
    }

    private int getElementCount(int val) {
        int result = 0;

        for (int num : nums) {
            if (num == val) {
                ++result;
            }
        }

        return result;
    }

    public int minimumIndex(List<Integer> nums) {
        this.nums = nums;
        n = nums.size();
        int dominantElement = findDominantElement();
        int totalCnt = getElementCount(dominantElement);
        int currentCnt = 0;

        for (int i = 0; i < n; ++i) {
            if (nums.get(i) == dominantElement) {
                ++currentCnt;
            }
            int remainingCnt = totalCnt - currentCnt;
            int remainingElements = n - i - 1;
            if (currentCnt > (i + 1) / 2 && remainingCnt > remainingElements / 2) {
                return i;
            }
        }

        return -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
       }
       
       scanner.close();
   }
}
