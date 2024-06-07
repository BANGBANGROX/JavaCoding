import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private static class TrieNode {
        int index;
        TrieNode[] children;

        TrieNode() {
            index = -1;
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    private void insert(String word, int index) {
        TrieNode pCrawl = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
        }

        pCrawl.index = index;
    }

    private int search(String word) {
        TrieNode pCrawl = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.index != -1) return pCrawl.index;
            if (pCrawl.children[idx] == null) {
                return -1;
            }
            pCrawl = pCrawl.children[idx];
        }

        return -1;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        int n = dictionary.size();
        StringBuilder answer = new StringBuilder();
        String[] sentenceWords = sentence.split(" ");
        root = new TrieNode();

        for (int i = 0; i < n; ++i) {
            insert(dictionary.get(i), i);
        }

        for (String word : sentenceWords) {
            int idx = search(word);
            if (idx != -1) {
                answer.append(dictionary.get(idx));
            } else {
                answer.append(word);
            }
            answer.append(" ");
        }

        return answer.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<String> dictionary = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                dictionary.add(sc.next());
            }
            String sentence = sc.nextLine();

            System.out.println(new Solution().replaceWords(dictionary, sentence));
        }

        sc.close();
    }
}
