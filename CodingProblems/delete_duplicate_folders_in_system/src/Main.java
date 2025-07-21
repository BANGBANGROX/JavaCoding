import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private class TrieNode {
        final String s;
        final Map<String, TrieNode> trieNodeMap;
        boolean isDeleted;

        public TrieNode(final String s) {
            this.s = s;
            trieNodeMap = new HashMap<>();
            isDeleted = false;
        }

        public void add(final List<String> path) {
            TrieNode trieNode = this;

            for (final String s : path) {
                trieNode.trieNodeMap.putIfAbsent(s, new TrieNode(s));
                trieNode = trieNode.trieNodeMap.get(s);
            }
        }

        public String serialize(final Map<String, List<TrieNode>> map) {
            if (trieNodeMap.isEmpty()) {
                return "";
            }

            final List<String> currentPaths = new ArrayList<>();

            for (final Map.Entry<String, TrieNode> entry : trieNodeMap.entrySet()) {
                final String next = entry.getValue().serialize(map);
                final String currentPath = "(" + entry.getKey() + next + ")";
                currentPaths.add(currentPath);
            }

            Collections.sort(currentPaths);
            final String overallPath = String.join("", currentPaths);

            map.computeIfAbsent(overallPath, k -> new ArrayList<>()).add(this);

            return overallPath;
        }

        public void markDeleted() {
            isDeleted = true;

            for (final TrieNode trieNode : trieNodeMap.values()) {
                trieNode.markDeleted();
            }
        }

        public void generate(final List<String> currentPath) {
            if (!s.equals("/")) {
                currentPath.add(s);
            }

            if (!s.equals("/") && !isDeleted) {
                answer.add(new ArrayList<>(currentPath));
            }

            for (final TrieNode trieNode : trieNodeMap.values()) {
                trieNode.generate(currentPath);
            }

            if (!currentPath.isEmpty()) {
                currentPath.removeLast();
            }
        }
    }

    private List<List<String>> answer;

    public List<List<String>> deleteDuplicateFolder(final List<List<String>> paths) {
        answer = new ArrayList<>();
        final TrieNode trieNode = new TrieNode("/");
        final Map<String, List<TrieNode>> map = new HashMap<>();

        for (final List<String> path : paths) {
            trieNode.add(path);
        }

        trieNode.serialize(map);

        for (final List<TrieNode> nodes : map.values()) {
            if (nodes.size() > 1) {
                for (final TrieNode node : nodes) {
                    node.markDeleted();
                }
            }
        }

        trieNode.generate(new ArrayList<>());

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final List<List<String>> paths = new ArrayList<>();
           for (int i = 0; i < n; ++i) {
               final int m = scanner.nextInt();
               final List<String> current = new ArrayList<>();
               for (int j = 0; j < m; ++j) {
                   current.add(scanner.next());
               }
               paths.add(current);
           }

           System.out.println(new Solution().deleteDuplicateFolder(paths));
       }
       
       scanner.close();
   }
}
