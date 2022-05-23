package miniLotto.utilities;

import miniLotto.models.Two;

import java.util.Comparator;

public interface TwoComparator {
     Comparator<Two> maxIntervalComparator = Comparator.comparing(Two::getMaxInterval);
     Comparator<Two> minIntervalComparator = Comparator.comparing(Two::getMinInterval);
     Comparator<Two> avgIntervalComparator = Comparator.comparing(Two::getAvgInterval);
     Comparator<Two> medOfintervalsComparator = Comparator.comparing(Two::getMedOfintervals);
     Comparator<Two> q3OfintervalsComparator = Comparator.comparing(Two::getQ3Ofintervals);
     Comparator<Two> lastOccurenceComparator = Comparator.comparing(Two::getLastOccurence);
}
