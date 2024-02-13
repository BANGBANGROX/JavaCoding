import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        int[] countOfChars = new int[10];
        int firstAvailableNumber = 2;
        int answer = 0;

        for (char ch : word.toCharArray()) {
            if (!characterMap.containsKey(ch)) {
                ++countOfChars[firstAvailableNumber];
                characterMap.put(ch, firstAvailableNumber);
                if (firstAvailableNumber == 9) {
                    firstAvailableNumber = 2;
                } else {
                    ++firstAvailableNumber;
                }
            }
            answer += countOfChars[characterMap.get(ch)];
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minimumPushes(word));
        }

        sc.close();
    }
}
