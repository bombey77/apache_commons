import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.collections4.map.ListOrderedMap;

public class OrderedMapDemo {

    public static void main(String[] args) {
        forwardIteration();
        backwardIteration();
        mapIterator();
        remove();
    }

    public static OrderedMap<Long, String> getUsers() {
        Long[] ids = {1L, 2L, 3L, 4L, 5L};
        String[] logins = {"Bolger", "Adalgrim Took", "Adelard Took", "Chubb", "Andy"};
        OrderedMap<Long, String> orderedMap = new LinkedMap<>();
        for (int i = 0; i < ids.length; i++) {
            orderedMap.put(ids[i], logins[i]);
        }
        return orderedMap;
    }

    public static void forwardIteration() {
        Long id = getUsers().firstKey();
        while (id != null) {
            System.out.println(id); // 1, 2, 3, 4, 5
            id = getUsers().nextKey(id);
        }
    }

    public static void backwardIteration() {
        Long id = getUsers().lastKey();
        while (id != null) {
            System.out.println(id); // 5, 4, 3, 2, 1
            id = getUsers().previousKey(id);
        }
    }

    public static void mapIterator() {
        OrderedMapIterator<Long, String> mapIterator = getUsers().mapIterator();
        while (mapIterator.hasNext()) {
            mapIterator.next();
            System.out.println(mapIterator.getKey()); // 1, 2, 3, 4, 5
            System.out.println(mapIterator.getValue()); //"Bolger", "Adalgrim Took"...
        }
    }

    public static void remove() {
        LinkedMap<Long, String> linkedMap = (LinkedMap<Long, String>) getUsers();
        // remove by index
        linkedMap.remove(0); // ids = 2, 3, 4, 5
        // remove by key
        linkedMap.remove(2L); // ids = 3, 4, 5
    }

    public static void implementations() {
        // чтобы гарантировать, что порядок добавления сохраняется
        ListOrderedMap listOrderedMap;
        // порядок поддерживается исходной вставкой
        // пользование двунаправленной итерации
        LinkedMap linkedMap;
    }
}
