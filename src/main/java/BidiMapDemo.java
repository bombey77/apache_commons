import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class BidiMapDemo {

    public static void main(String[] args) {
        BidiMap<String, String> bidiMap = new DualHashBidiMap<>();
        bidiMap.put("key1", "value1");
        bidiMap.put("key2", "value2");
        bidiMap.forEach((k, v) -> System.out.println(v)); // value1, value2
        bidiMap.put("key3", "value2");
        bidiMap.forEach((k, v) -> System.out.println(v)); // value1, value2

        BidiMap<String, String> inverseBidiMap = bidiMap.inverseBidiMap();
        System.out.println(inverseBidiMap.containsKey("value1"));
        System.out.println(inverseBidiMap.containsKey("value2"));

        BidiMap<String, String> bMap = new DualHashBidiMap<>();
        bMap.put("key1", "value1");
        System.out.println(bMap.getKey("value1")); // key1

        bMap.removeValue("value1");
        System.out.println(bMap.containsKey("key1")); // false
    }
}
