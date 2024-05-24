import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        int maxCnt = 0;
        int answer = 0;
        int length = word.length();
        int left = 0;
        int right = k - 1;
        String maxCntString = "";
        StringBuilder currentString = new StringBuilder();

        for (int i = left; i <= right; ++i) {
            currentString.append(word.charAt(i));
        }

        while (right < length) {
            count.put(currentString.toString(), count.getOrDefault(currentString.toString(), 0) + 1);
            if (count.get(currentString.toString()) > maxCnt) {
                maxCnt = count.get(currentString.toString());
                maxCntString = currentString.toString();
            }
            left += k;
            right += k;
            if (right < length) {
                currentString = new StringBuilder();
                for (int i = left; i <= right; ++i) {
                    currentString.append(word.charAt(i));
                }
            }
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (!entry.getKey().equals(maxCntString)) {
                answer += entry.getValue();
            }
        }

        return answer;
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
