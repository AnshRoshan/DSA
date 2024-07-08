import java.util.*;

public class HashMapIntro {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ansh", 22);
        map.put("Omega", 14);
        map.put("Beta", 32);
        System.out.println(map.get("Ansh"));
        System.out.println(map.getOrDefault("An", 41));
        System.out.println(map.values());
        // put will replace the old value
        System.out.println(map.put("Ansh", 11));
        // putIfAbsent will leave the value unchanged and do nothing
        System.out.println(map.putIfAbsent("Ansh", 90));
        System.out.println("Map:--> " + map);
    }
}
