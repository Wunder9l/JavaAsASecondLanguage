package io.github.javaasasecondlanguage.homework01.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalsMerger {
    private boolean isCoalesce(int[] first, int[] second) {
        return first[1] >= second[0];
    }

    private int[] doCoalesce(int[] prev, int[] next) {
        return new int[]{prev[0], Math.max(prev[1], next[1])};
    }

    /**
     * Given array of intervals, merge overlapping intervals and sort them by start
     * in ascending order
     * Interval is defined as [start, end] where start < end
     * <p>
     * Examples:
     * [[1,3][2,4][5,6]] -> [[1,4][5,6]]
     * [[1,2][2,3]] -> [[1,3]]
     * [[1,4][2,3]] -> [[1,4]]
     * [[5,6][1,2]] -> [[1,2][5,6]]
     *
     * @param intervals is a nullable array of pairs [start, end]
     * @return merged intervals
     * @throws IllegalArgumentException if intervals is null
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException();
        }
        var merged = new ArrayList<int[]>();
        Arrays.stream(intervals).sorted((int[] first, int[] second) -> {
            if (first[0] != second[0]) {
                return Integer.compare(first[0], second[0]);
            } else {
                return Integer.compare(first[1], second[1]);
            }
        }).reduce((prev, next) -> {
            if (isCoalesce(prev, next)) {
                return doCoalesce(prev, next);
            } else {
                merged.add(prev);
                return next;
            }
        }).ifPresent(merged::add);
        return merged.toArray(new int[0][]);
    }
}
