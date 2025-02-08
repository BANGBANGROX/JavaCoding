import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeSet;

class NumberContainers {
    private final Map<Integer, TreeSet<Integer>> numIndices;
    private final Map<Integer, Integer> indexNum;

    public NumberContainers() {
        numIndices = new HashMap<>();
        indexNum = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexNum.containsKey(index)) {
            int oldNum = indexNum.get(index);
            numIndices.get(oldNum).remove(index);
        }
        indexNum.put(index, number);
        numIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        try {
            return numIndices.getOrDefault(number, new TreeSet<>()).first();
        } catch (NoSuchElementException e) {
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

public class Main {
   public static void main(String[] args) {
       NumberContainers numberContainers = new NumberContainers();

       numberContainers.change(0, 1);
       numberContainers.change(1, 1);
       numberContainers.change(0, 2);

       System.out.println(numberContainers.find(1));
       System.out.println(numberContainers.find(2));
   }
}
