package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.Comparator;
import java.util.List;

public final class Sorter {
    private Sorter() {}

    private final static Comparator<Two> maxIntervalComparator = Comparator.comparing(Two::getMaxInterval);
    private final static Comparator<Two> minIntervalComparator = Comparator.comparing(Two::getMinInterval);
    private final static Comparator<Two> avgIntervalComparator = Comparator.comparing(Two::getAvgInterval);
    private final static Comparator<Two> medOfintervalsComparator = Comparator.comparing(Two::getMedOfintervals);
    private final static Comparator<Two> q3OfintervalsComparator = Comparator.comparing(Two::getQ3Ofintervals);
    private final static Comparator<Two> lastOccurenceComparator = Comparator.comparing(Two::getLastOccurence);

    public static void sortByMaxInterval(@NonNull List<Two> twoList) {
        twoList.sort(maxIntervalComparator);
    }

    public static void sortByMinIntervalDesc(@NonNull List<Two> twoList) {
        twoList.sort(minIntervalComparator.reversed());
    }

    public static void sortByAvgInterval(@NonNull List<Two> twoList) {
        twoList.sort(avgIntervalComparator);
    }

    public static void sortByMedOfintervals(@NonNull List<Two> twoList) {
        twoList.sort(medOfintervalsComparator);
    }

    public static void sortByQ3Ofintervals(@NonNull List<Two> twoList) {
        twoList.sort(q3OfintervalsComparator);
    }

    public static void sortByLastOccurenceDesc(@NonNull List<Two> twoList) {
        twoList.sort(lastOccurenceComparator.reversed());
    }

//    public static void sortBy

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
}
