public class CityBus {
    private static final String[] busStops = { "TH", "GA", "IC", "HA", "TE", "LU", "NI", "CA" };
    private static final int[] path = { 800, 600, 750, 900, 1400, 1200, 1100, 1500 };

    public static void main(String[] args) {
        // Example inputs
        String source = "NI";
        String destination = "HA";

        double fare = getFare(source, destination);
        if (fare != -1) {
            System.out.println(fare + " INR");
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    public static double getFare(String source, String destination) {
        if (!isValidBusStop(source) || !isValidBusStop(destination)) {
            return -1;
        }

        int sourceIndex = getIndex(source);
        int destinationIndex = getIndex(destination);

        if (sourceIndex == destinationIndex) {
            return 0; // Same stop, fare is zero
        }

        int distance = calculateDistance(sourceIndex, destinationIndex);
        double fare = calculateFare(distance);
        return fare;
    }

    private static boolean isValidBusStop(String stop) {
        for (String s : busStops) {
            if (s.equals(stop)) {
                return true;
            }
        }
        return false;
    }

    private static int getIndex(String stop) {
        for (int i = 0; i < busStops.length; i++) {
            if (busStops[i].equals(stop)) {
                return i;
            }
        }
        return -1; // Not found
    }

    private static int calculateDistance(int sourceIndex, int destinationIndex) {
        int distance = 0;
        if (sourceIndex < destinationIndex) {
            for (int i = sourceIndex; i < destinationIndex; i++) {
                distance += path[i];
            }
        } else {
            for (int i = sourceIndex; i < path.length; i++) {
                distance += path[i];
            }
            for (int i = 0; i < destinationIndex; i++) {
                distance += path[i];
            }
        }
        return distance;
    }

    private static double calculateFare(int distance) {
        double fare = 0;
        if (distance <= 1000) {
            fare = 5;
        } else {
            fare = Math.ceil(distance / 1000.0) * 5;
        }
        return fare;
    }
}
