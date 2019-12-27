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
                    if (pivToHig < 0) {
                        // low < piv < hig
                        doNothing();
                    } else if (pivToHig == 0) {
                        // low < piv = hig
                        doNothing();
                    } else {
                        // low < piv, hig < piv
                        var lowToHig = low.compareTo(hig);
                        if (lowToHig < 0) {
                            // low < hig < piv
                            list.set(pivIdx, hig);
                            list.set(higIdx, piv);
                            pivIdx = higIdx;
                        } else if (lowToHig == 0) {
                            // low = hig < piv
                            list.set(pivIdx, hig);
                            list.set(higIdx, piv);
                            pivIdx = higIdx;
                        } else {
                            // high < low < piv
                            list.set(lowIdx, hig);
                            list.set(pivIdx, low);
                            list.set(higIdx, piv);
                            pivIdx = higIdx;
                        }
                    }
                } else if (lowToPiv == 0) {
                    // low = piv
                    if (pivToHig < 0) {
                        // low = piv < hig
                        doNothing();
                    } else if (pivToHig == 0) {
                        // low = piv = hig
                        doNothing();
                    } else {
                        // hig < piv = low
                        if (pivIdx == lowIdx) {
                            list.set(pivIdx, hig);
                            list.set(higIdx, piv);
                            pivIdx = higIdx;
                        } else {
                            list.set(lowIdx, hig);
                            list.set(higIdx, low);
                        }
                    }
                } else {
                    // piv < low
                    if (pivToHig < 0) {
                        // piv < low, piv < hig
                        var lowToHig = low.compareTo(hig);
                        if (lowToHig < 0) {
                            // piv < low < hig
                            list.set(lowIdx, piv);
                            list.set(pivIdx, low);
                            pivIdx = lowIdx;
                        } else if (lowToHig == 0) {
                            // piv < low = hig
                            list.set(lowIdx, piv);
                            list.set(pivIdx, low);
                            pivIdx = lowIdx;
                        } else {
                            // piv < hig < low
                            list.set(lowIdx, piv);
                            list.set(pivIdx, low);
                            pivIdx = lowIdx;
                        }
                    } else if (pivToHig == 0) {
                        // piv = hig < low
                        if (pivIdx == higIdx) {
                            list.set(pivIdx, low);
                            list.set(lowIdx, piv);
                            pivIdx = lowIdx;
                        } else {
                            list.set(lowIdx, hig);
                            list.set(higIdx, low);
                        }
                    } else {
                        // hig < piv < low
                        list.set(lowIdx, hig);
                        list.set(higIdx, low);
                    }
                }

                lowIdx = min(lowIdx + 1, pivIdx);
                higIdx = max(higIdx - 1, pivIdx);
            }

            sort(list.subList(0, pivIdx));
            sort(list.subList(pivIdx + 1, length));
        }
    }

    private static void doNothing() {
    }
}
