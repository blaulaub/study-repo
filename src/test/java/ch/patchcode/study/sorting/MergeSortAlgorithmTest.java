package ch.patchcode.study.sorting;

class MergeSortAlgorithmTest extends SortAlgorithmTest<MergeSortAlgorithm<Integer>> {

    @Override
    MergeSortAlgorithm<Integer> getAlgorithm() {
        return new MergeSortAlgorithm<>();
    }
}