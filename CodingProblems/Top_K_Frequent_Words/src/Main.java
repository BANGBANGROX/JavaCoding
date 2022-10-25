import java.util.*;

class Solution {
    private static class WordAndCount {
        String word;
        int cnt;

        WordAndCount(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        PriorityQueue<WordAndCount> pq = new PriorityQueue<>((a, b) ->
                a.cnt != b.cnt ? a.cnt - b.cnt : -1 * a.word.compareTo(b.word));

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (String word : words) {
            if (count.get(word) == 0) continue;
            if (pq.size() < k) pq.add(new WordAndCount(word, count.get(word)));
            else {
                WordAndCount temp = pq.peek();
                assert temp != null;
                if (temp.cnt <= count.get(word)) {
                    if (temp.cnt < count.get(word) || temp.word.compareTo(word) > 0) {
                        pq.poll();
                        pq.add(new WordAndCount(word, count.get(word)));
                    }
                }
            }
            count.put(word, 0);
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().word);
        }

        Collections.reverse(ans);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.topKFrequent(words, k));
        }

        sc.close();
    }
}
