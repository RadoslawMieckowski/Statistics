package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static miniLotto.utilities.TwoComparator.*;

public final class Finder {
    private Finder() {}


    public static Two findTwoWithMaxInterval(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .max(maxIntervalComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMinInterval(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .min(minIntervalComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMaxAvgInterval(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .max(avgIntervalComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMinAvgInterval(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .min(avgIntervalComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMaxMedOfintervals(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .max(medOfintervalsComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMinMedOfintervals(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .min(medOfintervalsComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMaxQ3Ofintervals(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .max(q3OfintervalsComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMinQ3Ofintervals(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .min(q3OfintervalsComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMaxLastOccurence(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .max(lastOccurenceComparator)
                .orElseThrow();
        return two;
    }

    public static Two findTwoWithMinLastOccurence(@NonNull List<Two> twoList) {
        Two two = twoList.stream()
                .min(lastOccurenceComparator)
                .orElseThrow();
        return two;
    }

//    public static <K, V> Map.Entry<K, V> findEntryWithHighestSimilarity(Map<K, V> map) {
//        return   map.entrySet()
//                .stream()
//
//
//    }
}
