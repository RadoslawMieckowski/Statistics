package miniLotto.utilities;

import miniLotto.models.Two;

import java.util.Comparator;

public final class Sorter {
    private Sorter() {}

    private final static Comparator<Two> maxIntervalComparator = Comparator.comparing(Two::getMaxInterval);
    private final static Comparator<Two> minIntervalComparator = Comparator.comparing(Two::getMinInterval);
    private final static Comparator<Two> avgIntervalComparator = Comparator.comparing(Two::getAvgInterval);
    private final static Comparator<Two> medOfintervalsComparator = Comparator.comparing(Two::getMedOfintervals);
    private final static Comparator<Two> q3OfintervalsComparator = Comparator.comparing(Two::getQ3Ofintervals);
    private final static Comparator<Two> lastOccurenceComparator = Comparator.comparing(Two::getLastOccurence);
}
