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

        public void add(final List<String> paths) {
            TrieNode trieNode = this;

            for (final String s : paths) {
                trieNode.trieNodeMap.putIfAbsent(s, new TrieNode(s));
                trieNode = trieNode.trieNodeMap.get(s);
            }
        }

        public String serialze(final Map<String, List<TrieNode>> map) {
            if (trieNodeMap.isEmpty()) {
                return "";
            }

            final List<String> currentSerializedValues = new ArrayList<>();

            for (final Map.Entry<String, TrieNode> entry : trieNodeMap.entrySet()) {
                final String childValue = entry.getValue().serialze(map);
                final String combined = "(" + entry.getKey() + childValue + ")";
                currentSerializedValues.add(combined);
            }

            Collections.sort(currentSerializedValues);
            final String combined = String.join("", currentSerializedValues);

            map.computeIfAbsent(combined, k -> new ArrayList<>()).add(this);

            return combined;
        }

        public void markDelete() {
            isDeleted = true;

            for (final Map.Entry<String, TrieNode> entry : trieNodeMap.entrySet()) {
                entry.getValue().markDelete();
            }
        }

        public void generate(final List<String> currentPath) {
            if (!s.equals("/")) {
                currentPath.add(s);
            }

            if (!isDeleted && !s.equals("/")) {
                answer.add(new ArrayList<>(currentPath));
            }

            for (final Map.Entry<String, TrieNode> entry : trieNodeMap.entrySet()) {
                entry.getValue().generate(currentPath);
            }

            if (!currentPath.isEmpty()) {
                currentPath.removeLast();
            }
        }
    }

    private List<List<String>> answer;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        final TrieNode trieNode = new TrieNode("/");
        answer = new ArrayList<>();

        for (final List<String> path : paths) {
            trieNode.add(path);
        }

        final Map<String, List<TrieNode>> map = new HashMap<>();

        trieNode.serialze(map);

        for (final List<TrieNode> trieNodes : map.values()) {
            if (trieNodes.size() > 1) {
                for (final TrieNode node : trieNodes) {
                    node.markDelete();
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
