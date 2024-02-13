import java.util.*;

class Solution {
    private String getModifiedWord(String word) {
        // Sort chars according to their frequency. Higher comes first
        int[] count = new int[26];
        ArrayList<Character> wordsList = new ArrayList<>();

        for (char ch : word.toCharArray()) {
            wordsList.add(ch);
            ++count[ch - 'a'];
        }

        wordsList.sort((a, b) ->
                count[a - 'a'] != count[b - 'a'] ? count[b - 'a'] - count[a - 'a'] : a - b);

        StringBuilder modifiedWord = new StringBuilder();

        for (char ch : wordsList) {
            modifiedWord.append(ch);
        }

        return modifiedWord.toString();
    }

    public int minimumPushes(String word) {
        String modifiedWord = getModifiedWord(word);
        System.out.println(modifiedWord);
        HashMap<Character, Integer> characterMap = new HashMap<>();
        int[] countOfChars = new int[10];
        int firstAvailableNumber = 2;
        int answer = 0;

        for (char ch : modifiedWord.toCharArray()) {
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
