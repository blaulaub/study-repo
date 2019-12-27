package ch.patchcode.study.sorting;

class QuickSortAlgorithmTest extends SortAlgorithmTest<BubbleSortAlgorighm<Integer>> {

    @Override
    BubbleSortAlgorighm<Integer> getAlgorithm() {

        return new BubbleSortAlgorighm<>();
    }
}
