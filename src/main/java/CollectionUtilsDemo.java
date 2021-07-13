import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionUtilsDemo {

    public static void main(String[] args) {
//        addingOnlyNonNullElements();
//        givenTwoSortedListsWhenCollatedThenSorted();
//        discreteFunction();
//        transform();
//        filtering();
//        checkingForNonEmpty();
//        containsMethods();
//        searchWithPredicate();
        equalCollection();
    }

    public static void addingOnlyNonNullElements() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        CollectionUtils.addIgnoreNull(list, null); // returns false
        System.out.println(list.contains(null)); // false
    }

    public static void givenTwoSortedListsWhenCollatedThenSorted() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> sortedList = CollectionUtils.collate(list2, list1);
        System.out.println(sortedList); // 1, 2, 3, 4, 5, 6
    }

    public static void discreteFunction() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        Collection<Integer> intersection = CollectionUtils.intersection(list1, list2); // 2, 3
        Collection<Integer> union = CollectionUtils.union(list1, list2); // 1, 2, 3, 4
        Collection<Integer> subtract = CollectionUtils.subtract(list1, list2); // 1
        Collection<Integer> disjunction = CollectionUtils.disjunction(list1, list2); // 1, 4
    }

    public static void transform() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        CollectionUtils.transform(list, element -> element * 5); // 5, 10, 15
        Collection<Integer> collected = CollectionUtils.collect(list, element -> element * 5); // 25, 50, 75
    }

    public static void filtering() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        boolean isFiltered = CollectionUtils.filter(list1, element -> element % 2 == 0); // true
        System.out.println(list1); // 2, 4, 6

        CollectionUtils.filterInverse(list2, element -> element % 2 == 0);
        System.out.println(list2); // 1, 3, 5
    }

    public static void checkingForNonEmpty() {
        List<Integer> isNotEmpty = Arrays.asList(1, 2, 3);
        System.out.println(CollectionUtils.isNotEmpty(isNotEmpty)); // true

        List<Integer> emptyList = new ArrayList<>();
        List<Integer> nullList = null;
        System.out.println(CollectionUtils.isEmpty(emptyList)); // true
        System.out.println(CollectionUtils.isEmpty(nullList)); // true
    }

    public static void containsMethods() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 6);
        List<Integer> list2 = Arrays.asList(1, 3, 5);

        boolean any = CollectionUtils.containsAny(list1, list2); // true
        boolean all = CollectionUtils.containsAll(list1, list2); // true
        boolean subCollection = CollectionUtils.isSubCollection(list2, list1); // true
    }

    public static void searchWithPredicate() {
        List<Integer> output = new ArrayList<>();
        List<Integer> rejected = new ArrayList<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Collection<Integer> list = CollectionUtils.select(numbers, number -> number > 3);
        System.out.println(list); // 4, 5
        CollectionUtils.select(numbers, number -> number > 3, output);
        System.out.println(output); // 4, 5
        CollectionUtils.select(numbers, number -> number > 3, output, rejected);
        System.out.println(rejected); // 1, 2, 3
        Collection<Integer> rejectedCollection = CollectionUtils.selectRejected(numbers, number -> number > 3);
        System.out.println(rejectedCollection); // 1, 2, 3
    }

    public static void equalCollection() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(5, 3, 1);
        boolean isEqual = CollectionUtils.isEqualCollection(list1, list2);
        System.out.println(isEqual); // true
    }
}
