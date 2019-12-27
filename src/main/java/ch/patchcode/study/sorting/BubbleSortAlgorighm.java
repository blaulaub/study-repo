package ch.patchcode.study.sorting;

import java.util.List;

public class BubbleSortAlgorighm<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {

        var modified = true;
        var top = list.size();
        while(modified && top > 1) {
            modified = false;
            var a = list.get(0);
            for (var idx = 0; idx < top - 1; ++idx) {
                var b = list.get(idx + 1);
                if (a.compareTo(b) > 0) {
                    list.set(idx, b);
                    list.set(idx + 1, a);
                    modified = true;
                } else {
                    a = b;
                }
            }
            --top;
        };

    }
}
