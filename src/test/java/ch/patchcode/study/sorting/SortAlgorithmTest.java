package ch.patchcode.study.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

abstract class SortAlgorithmTest<T extends SortAlgorithm<Integer>> {

    abstract T getAlgorithm();

    @Test
    void sortEmpty_withoutChanging() {

        var list = new ArrayList<>();
        getAlgorithm().sort(emptyList());
        assertIterableEquals(emptyList(), list);
    }

    @Test
    void sortSingleton_withoutChanging() {

        var list = asList(42);
        getAlgorithm().sort(list);
        assertIterableEquals(asList(42), list);
    }

    @Test
    void sortSorted_withoutChanging() {

        var list = asList(1, 3, 5);
        getAlgorithm().sort(list);
        assertIterableEquals(asList(1, 3, 5), list);
    }

    @Test
    void sortEquals_withoutChanging() {

        var list = asList(3, 3, 3);
        getAlgorithm().sort(list);
        assertIterableEquals(asList(3, 3, 3), list);
    }

    @Test
    void sortReversed_succeeds() {

        var list = asList(5, 3, 1);
        getAlgorithm().sort(list);
        assertIterableEquals(asList(1, 3, 5), list);
    }

    @Test
    void sortHighestFirst_succeeds() {

        var list = asList(5, 1, 2, 3, 4);
        getAlgorithm().sort(list);
        assertIterableEquals(asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void sortSmallestLast_succeeds() {

        var list = asList(2, 3, 4, 5, 1);
        getAlgorithm().sort(list);
        assertIterableEquals(asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void sortSet5of7_succeeds() {

        var list = pseudoRandom(5, 7);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortSet7of5_succeeds() {

        var list = pseudoRandom(7, 5);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortSet7of13_succeeds() {

        var list = pseudoRandom(7, 13);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortSet11of5_succeeds() {

        var list = pseudoRandom(11, 5);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortSet11of7_succeeds() {

        var list = pseudoRandom(11, 7);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortSet11of17_succeeds() {

        var list = pseudoRandom(11, 17);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortSet13of5_succeeds() {

        var list = pseudoRandom(13, 5);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    @Test
    void sortLargerSet_succeeds() {

        var list = pseudoRandom(13463, 9967);
        getAlgorithm().sort(list);
        assertIterableEquals(sorted(list), list);
    }

    private List<Integer> pseudoRandom(int size, int increment) {

        var list = new ArrayList<Integer>(size);
        for (var i = 0; i < size; ++i) {
            list.add(0);
        }

        var value = 0;
        for (var i = 0; i < size; ++i) {
            list.set(i, value);
            value = (value + increment) % size;
        }
        return list;
    }

    private List<Integer> sorted(List<Integer> unsorted) {

        return unsorted.stream().sorted().collect(toList());
    }
}
