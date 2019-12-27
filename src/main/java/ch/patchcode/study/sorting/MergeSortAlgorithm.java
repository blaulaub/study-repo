package ch.patchcode.study.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortAlgorithm<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {

        final var length = list.size();
        if (length > 1) {

            var shelf = new ArrayList<>(list);
            sortListToList(list, shelf);
        }
    }

    private void sortListToList(List<T> list, List<T> shelf) {

        final var length = list.size();
        if (length > 1) {

            final var midIdx = length / 2;
            sortListToShelf(list.subList(0, midIdx), shelf.subList(0, midIdx));
            sortListToShelf(list.subList(midIdx, length), shelf.subList(midIdx, length));
            merge(shelf, list, length, midIdx);
        }

    }

    private void sortListToShelf(List<T> list, List<T> shelf) {

        final var length = list.size();
        if (length > 1) {

            final var midIdx = length / 2;
            sortListToList(list.subList(0, midIdx), shelf.subList(0, midIdx));
            sortListToList(list.subList(midIdx, length), shelf.subList(midIdx, length));
            merge(list, shelf, length, midIdx);
        } else {
            for(var i=0; i<length;i++) {
                shelf.set(i, list.get(i));
            }
        }
    }

    private void merge(List<T> in, List<T> out, int length, int midIdx) {

        var loIdx = 0;
        var hiIdx = midIdx;
        var destIdx = 0;

        var lo = in.get(loIdx);
        var hi = in.get(hiIdx);
        while (loIdx < midIdx && hiIdx < length) {
            if (lo.compareTo(hi) < 0) {
                out.set(destIdx++, lo);
                loIdx++;
                if (loIdx >= midIdx) {
                    out.set(destIdx++, hi);
                    for (var i = hiIdx+1; i < length; i++) {
                        out.set(destIdx++, in.get(i));
                    }
                    break;
                }
                lo = in.get(loIdx);
            } else {
                out.set(destIdx++, hi);
                hiIdx++;
                if (hiIdx >= length) {
                    out.set(destIdx++, lo);
                    for (var i = loIdx + 1; i<midIdx; i++) {
                        out.set(destIdx++, in.get(i));
                    }
                    break;
                }
                hi = in.get(hiIdx);
            }
        }
    }
}
