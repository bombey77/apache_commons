import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.Arrays;

public class BagDemo {

    public static void main(String[] args) {
        Bag<Integer> bag = new HashBag<>(Arrays.asList(1, 1, 2, 2, 2, 3, 3, 4, 5));
        System.out.println(bag.getCount(2)); // 3
        // удаление 2-х копий 2-к
        bag.remove(2, 2);
        System.out.println(bag.getCount(2)); // 1
        // добавление 3-х копий 3-к
        bag.add(3, 3);
        System.out.println(bag.getCount(3)); // 5
        // удаление всех 1-к
        bag.remove(1);
        System.out.println(bag.getCount(1)); // 0


        TreeBag<Integer> treeBag = new TreeBag<>(
                Arrays.asList(7, 5, 1, 7, 2, 3, 3, 3, 1, 4, 7));

        System.out.println(treeBag.first()); // 1
        System.out.println(treeBag.getCount(treeBag.first())); // 2
        System.out.println(treeBag.last()); // 7
        System.out.println(treeBag.getCount(treeBag.last())); // 3


        SynchronizedSortedBag<Integer> syncBag = SynchronizedSortedBag
                .synchronizedSortedBag(new TreeBag<>(
                        Arrays.asList(7, 5, 1, 7, 2, 3, 3, 3, 1, 4, 7)));

        System.out.println(syncBag.first()); // 1
        System.out.println(syncBag.getCount(syncBag.first())); // 2
        System.out.println(syncBag.last()); // 7
        System.out.println(syncBag.getCount(syncBag.last())); // 3
    }
}
