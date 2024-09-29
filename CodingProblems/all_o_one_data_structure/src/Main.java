import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class AllOne {
    private static class Node {
        final int cnt;
        Node next;
        Node prev;
        final Set<String> keys;

        Node(int cnt) {
            this.cnt = cnt;
            keys = new HashSet<>();
        }
    }

    private final Node head;
    private final Node tail;
    private final Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int cnt = node.cnt;
            Node nextNode = node.next;

            node.keys.remove(key);

            if (nextNode == tail || nextNode.cnt != cnt + 1) {
                Node newNode = new Node(cnt + 1);
                newNode.keys.add(key);
                newNode.prev = node;
                newNode.next = nextNode;
                node.next = newNode;
                nextNode.prev = newNode;
                map.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        } else {
            Node firstNode = head.next;

            if (firstNode == tail || firstNode.cnt > 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;
                map.put(key, newNode);
            } else {
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }

        Node node = map.get(key);
        int cnt = node.cnt;
        node.keys.remove(key);

        if (cnt == 1) {
            map.remove(key);
        } else {
            Node prevNode = node.prev;

            if (prevNode == head || prevNode.cnt != cnt - 1) {
                Node newNode = new Node(cnt - 1);
                newNode.keys.add(key);
                newNode.prev = prevNode;
                prevNode.next = newNode;
                newNode.next = node;
                node.prev = newNode;
                map.put(key, newNode);
            } else {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }

        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}


public class Main {
   public static void main(String[] args) {
       AllOne allOne = new AllOne();

       allOne.inc("a");
       allOne.inc("a");
       allOne.dec("a");
       System.out.println(allOne.getMaxKey());
       System.out.println(allOne.getMinKey());
   }
}
