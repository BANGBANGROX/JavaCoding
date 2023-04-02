class WordDictionary {
    private static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    private void add(String s) {
        TrieNode pCrawl = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
        }

        pCrawl.isEnd = true;
    }

    private boolean query(String s, int index, TrieNode pCrawl) {
        if (pCrawl == null) return false;

        if (index == s.length()) return pCrawl.isEnd;

        if (s.charAt(index) != '.') {
            int idx = s.charAt(index) - 'a';
            return query(s, index + 1, pCrawl.children[idx]);
        }

        for (int i = 0; i < 26; ++i) {
            if (query(s, index + 1, pCrawl.children[i])) return true;
        }

        return false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        add(word);
    }

    public boolean search(String word) {
        return query(word, 0, root);
    }
}

public class Main {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("Nobita");
        wordDictionary.addWord("Shizuka");
        wordDictionary.addWord("Doraemon");
        System.out.println(wordDictionary.search("Nob.t.a"));
        System.out.println(wordDictionary.search("Dorami.."));
    }
}
