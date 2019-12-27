package ch.patchcode.study.sorting;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortAlgorithmInPlaceTest extends SortAlgorithmTest<QuickSortAlgorithmInPlace<Integer>> {

    @Override
    QuickSortAlgorithmInPlace<Integer> getAlgorithm() {

        return new QuickSortAlgorithmInPlace<>();
    }
}