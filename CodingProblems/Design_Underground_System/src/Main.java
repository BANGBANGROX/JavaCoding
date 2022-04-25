import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class UndergroundSystem {
    private static class StationTimePair {
        int time;
        String station;

        StationTimePair(String station, int time) {
            this.time = time;
            this.station = station;
        }
    }

    private static class SumCountPair {
        int sum;
        int count;

        SumCountPair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    private final HashMap<Integer, StationTimePair> idToStation;
    private final HashMap<ArrayList<String>, SumCountPair> stationToAverage;

    public UndergroundSystem() {
       idToStation = new HashMap<>();
       stationToAverage = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
         idToStation.put(id, new StationTimePair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        int timeOfStation1 = idToStation.get(id).time;
        String startStation = idToStation.get(id).station;
        int timeDifference = t - timeOfStation1;
        ArrayList<String> sp = new ArrayList<>(Arrays.asList(startStation, stationName));

        if (!stationToAverage.containsKey(sp)) {
            stationToAverage.put(sp, new SumCountPair(timeDifference, 1));
            return;
        }

        int sum = stationToAverage.get(sp).sum;
        int count = stationToAverage.get(sp).count;

        sum += timeDifference;
        ++count;

        stationToAverage.put(sp, new SumCountPair(sum, count));
    }

    public double getAverageTime(String startStation, String endStation) {
        ArrayList<String> sp = new ArrayList<>(Arrays.asList(startStation, endStation));

        if (!stationToAverage.containsKey(sp)) return -1;

        int sum = stationToAverage.get(sp).sum;
        int count = stationToAverage.get(sp).count;

        return (double) sum / count;
    }
}

public class Main {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
