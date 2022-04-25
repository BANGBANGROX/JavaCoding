import java.util.*;

class SnapshotArray {
    private final HashMap<Integer, HashMap<Integer, Integer>> snapToIndex;
    private final HashMap<Integer, Integer> currentMap;
    private int snaps;

    public SnapshotArray() {
       snapToIndex = new HashMap<>();
       currentMap = new HashMap<>();
       snaps = 0;
    }

    public void set(int index, int val) {
        currentMap.put(index, val);
    }

    public int snap() {
        snapToIndex.put(snaps, new HashMap<>(currentMap));

        ++snaps;

        return snaps - 1;
    }

    public int get(int index, int snap_id) {
        if (!currentMap.containsKey(index)) return 0;

        if (!snapToIndex.get(snap_id).containsKey(index)) return 0;

        return snapToIndex.get(snap_id).get(index);
    }
}

public class Main {
    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        System.out.println(snapshotArr.get(0,0));  // Get the value of array[0] with snap_id = 0, return 5
    }
}
