package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.List;

import static miniLotto.utilities.TwoComparator.*;

public final class Sorter {
    private Sorter() {}

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
}
