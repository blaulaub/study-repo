package ch.patchcode.study.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortAlgorithm<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {

        if (list.size() > 1) {

            var buffer = new ArrayList<>(list);

            var pivIdx = list.size() / 2;
            var piv = list.get(pivIdx);

            var lowIdx = 0;
            var higIdx = list.size() - 1;

            for (var i = 0; i < pivIdx; ++i) {
                var e = list.get(i);
                if (e.compareTo(piv) < 0) {
                    buffer.set(lowIdx++, e);
                } else {
                    buffer.set(higIdx--, e);
                }
            }

            for (var i = pivIdx + 1; i < list.size(); ++i) {
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

            for (var i = 0; i < list.size(); ++i) {
                list.set(i, buffer.get(i));
            }
        }
    }
}
