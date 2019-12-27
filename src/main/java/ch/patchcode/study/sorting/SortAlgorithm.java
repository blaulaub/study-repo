package ch.patchcode.study.sorting;

import java.util.List;

public interface SortAlgorithm<T extends Comparable<T>> {

    /**
     * Sorts the given list in-place.
     *
     * @param list
     */
    void sort(List<T> list);
}
