import java.util.*;

class SnapshotArray {
    private final TreeMap<Integer, Integer>[] recordsHistory;
    private int snaps;

    public SnapshotArray(int length) {
        snaps = 0;
        recordsHistory = new TreeMap[length];

        for (int i = 0; i < length; ++i) {
            recordsHistory[i] = new TreeMap<>();
            recordsHistory[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        recordsHistory[index].put(snaps, val);
    }

    public int snap() {
        return snaps++;
    }

    public int get(int index, int snap_id) {
        return recordsHistory[index].floorEntry(snap_id).getValue();
    }
}

public class Main {
    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0, 5);  // Set array[0] = 5
        System.out.println(snapshotArr.snap());  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0, 6);
        System.out.println(snapshotArr.get(0, 0));  // Get the value of array[0] with snap_id = 0, return 5
    }
}
