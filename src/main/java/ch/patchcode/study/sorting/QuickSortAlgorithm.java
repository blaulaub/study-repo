package ch.patchcode.study.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortAlgorithm<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {

        final var length = list.size();
        if (length > 1) {

            var buffer = new ArrayList<>(list);

            var pivIdx = length / 2;
            var piv = list.get(pivIdx);

            var lowIdx = 0;
            var higIdx = length - 1;

            for (var i = 0; i < pivIdx; ++i) {
                var e = list.get(i);
                if (e.compareTo(piv) < 0) {
                    buffer.set(lowIdx++, e);
                } else {
                    buffer.set(higIdx--, e);
                }
            }

            for (var i = pivIdx + 1; i < length; ++i) {
                var e = list.get(i);
                if (e.compareTo(piv) < 0) {
                    buffer.set(lowIdx++, e);
                } else {
                    buffer.set(higIdx--, e);
                }
            }

            buffer.set(lowIdx, piv);

            sort(buffer.subList(0, lowIdx));
            sort(buffer.subList(lowIdx + 1, higIdx));

            for (var i = 0; i < length; ++i) {
                list.set(i, buffer.get(i));
            }
        }
    }
}
