package ch.patchcode.study.sorting;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class QuickSortAlgorithmInPlace<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {

        final var length = list.size();
        if (length > 1) {

            var pivIdx = length / 2;
            var lowIdx = 0;
            var higIdx = length - 1;

            final var piv = list.get(pivIdx);
            while (lowIdx < higIdx) {

                T low = list.get(lowIdx);
                T hig = list.get(higIdx);

                var lowToPiv = low.compareTo(piv);
                var pivToHig = piv.compareTo(hig);

                if (lowToPiv < 0) {
                    // low < piv
                    if (pivToHig <= 0) {
                        // low < piv < hig
                        doNothing();
                    } else {
                        // low < piv, hig < piv
                        var lowToHig = low.compareTo(hig);
                        if (lowToHig <= 0) {
                            // low < hig < piv
                            pivIdx = swapPivAndHigh(list, pivIdx, higIdx, piv, hig);
                        } else {
                            // high < low < piv
                            pivIdx = rotateUp(list, pivIdx, lowIdx, higIdx, piv, low, hig);
                        }
                    }
                } else if (lowToPiv == 0) {
                    // low = piv
                    if (pivToHig <= 0) {
                        // low = piv < hig
                        doNothing();
                    } else {
                        // hig < piv = low
                        if (pivIdx == lowIdx) {
                            pivIdx = swapPivAndHigh(list, pivIdx, higIdx, piv, hig);
                        } else {
                            swapLowAndHigh(list, lowIdx, higIdx, low, hig);
                        }
                    }
                } else {
                    // piv < low
                    if (pivToHig < 0) {
                        // piv < low, piv < hig
                        var lowToHig = low.compareTo(hig);
                        if (lowToHig <= 0) {
                            // piv < low < hig
                            pivIdx = SwapPivAndLow(list, pivIdx, lowIdx, piv, low);
                        } else {
                            // piv < hig < low
                            pivIdx = SwapPivAndLow(list, pivIdx, lowIdx, piv, low);
                        }
                    } else if (pivToHig == 0) {
                        // piv = hig < low
                        if (pivIdx == higIdx) {
                            pivIdx = swapPivAndHigh(list, pivIdx, lowIdx, piv, low);
                        } else {
                            swapLowAndHigh((List<T>) list, lowIdx, higIdx, low, hig);
                        }
                    } else {
                        // hig < piv < low
                        swapLowAndHigh(list, lowIdx, higIdx, low, hig);
                    }
                }

                lowIdx = min(lowIdx + 1, pivIdx);
                higIdx = max(higIdx - 1, pivIdx);
            }

            sort(list.subList(0, pivIdx));
            sort(list.subList(pivIdx + 1, length));
        }
    }

    private int rotateUp(List<T> list, int pivIdx, int lowIdx, int higIdx, T piv, T low, T hig) {
        list.set(lowIdx, hig);
        pivIdx = swapPivAndHigh(list, pivIdx, higIdx, piv, low);
        return pivIdx;
    }

    private void swapLowAndHigh(List<T> list, int lowIdx, int higIdx, T low, T hig) {
        list.set(lowIdx, hig);
        list.set(higIdx, low);
    }

    private int SwapPivAndLow(List<T> list, int pivIdx, int lowIdx, T piv, T low) {
        swapLowAndHigh(list, lowIdx, pivIdx, low, piv);
        return lowIdx;
    }

    private int swapPivAndHigh(List<T> list, int pivIdx, int lowIdx, T piv, T low) {
        swapLowAndHigh(list, pivIdx, lowIdx, piv, low);
        return lowIdx;
    }

    private static void doNothing() {
    }
}
