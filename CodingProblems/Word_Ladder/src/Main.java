import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordListSet = new HashSet<>(wordList);

        int length = 1;
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while (!q.isEmpty()) {
            ++length;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; ++i) {
                String currWord = q.poll();
                for (int j = 0; j < Objects.requireNonNull(currWord).length(); ++j) {
                    char ch = currWord.charAt(j);
                    String nextWord;
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) continue;
                        nextWord = (j > 0) ? currWord.substring(0, j) + c + currWord.substring(j + 1) :
                                c + currWord.substring(j + 1);
                        if (wordListSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) return length;
                            q.add(nextWord);
                            wordListSet.remove(nextWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String beginWord = sc.next();
            String endWord = sc.next();
            int n = sc.nextInt();
            List<String> wordList = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String s = sc.next();
                wordList.add(s);
            }

            Solution solution = new Solution();
            System.out.println(solution.ladderLength(beginWord, endWord, wordList));
        }

        sc.close();
    }
}
