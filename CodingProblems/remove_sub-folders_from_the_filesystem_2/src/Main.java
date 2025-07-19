import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private static class TrieNode {
        final Map<String, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }

        public void add(final String[] strings) {
            TrieNode pCrawl = this;

            for (final String s : strings) {
                if (!pCrawl.children.containsKey(s)) {
                    pCrawl.children.put(s, new TrieNode());
                }
                pCrawl = pCrawl.children.get(s);
            }

            pCrawl.isEnd = true;
        }

        public boolean isValid(final String[] strings) {
            TrieNode pCrawl = this;

            for (final String s : strings) {
                if (pCrawl.children.get(s).isEnd) {
                    return false;
                }
                pCrawl = pCrawl.children.get(s);
            }

            return true;
        }
    }

    public List<String> removeSubfolders(final String[] folder) {
        final TrieNode trieNode = new TrieNode();
        final List<String> answer = new ArrayList<>();

        for (final String currentFolder : folder) {
            final String[] strings = currentFolder.split("/");
            trieNode.add(strings);
        }

        for (final String currentFolder : folder) {
            final String[] strings = currentFolder.split("/");
            if (trieNode.isValid(strings)) {
                answer.add(currentFolder);
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final String[] folder = new String[n];
           for (int i = 0; i < n; ++i) {
               folder[i] = scanner.next();
           }

           System.out.println(new Solution().removeSubfolders(folder));
       }
       
       scanner.close();
   }
}
