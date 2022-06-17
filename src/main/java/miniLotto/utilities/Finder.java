package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static miniLotto.interfaces.TwoComparator.*;

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

    public static <K, V extends Comparable<V>> Entry<K, V> findEntryWithHighestSimilarity(Map<K, V> map) {
        Optional<Entry<K , V>> maxEntry = map.entrySet()
                .stream().max(Comparator.comparing(Entry::getValue));
        return maxEntry.get();
    }

    public static <K extends String, V extends Comparable > List<Entry<K, V>> findMostSimilarEntriesWithGivenTwo(
            @NonNull List<Map.Entry<K , V>> entryList, int elementsLimit) throws Throwable{
        List<Map.Entry<K, V>> copyList = entryList.stream().collect(Collectors.toList());
        List<Map.Entry<K, V>> returnList = new LinkedList<>();
        for (int i = 1; i <= elementsLimit; i++) {
                Entry<K, V> maxEntry = (Entry<K, V>) copyList.stream().max(Comparator.comparing(Entry::getValue))
                        .orElseThrow(NoSuchElementException::new);
                    returnList.add(maxEntry);
                    copyList.remove(maxEntry);
       }
        return returnList;
    }

    public static <K extends String, V> List<Map.Entry<K, V>> filterListOfMapsByFirstAndSecondNumber(
            String firstNumber,
            String secondNumber,
            List<Map<K, V>> list) {
        List<Map<K, V>> copyList = list.stream().collect(Collectors.toList());
        List<Entry<K, V>> returnList = new LinkedList<>();
        for (Map map : copyList) {
            Set<Entry<K, V>> entrySet = map.entrySet();
            for (Entry<K, V> entry : entrySet) {
                if (entry.getKey().startsWith(firstNumber + "|" + secondNumber) ||
                        entry.getKey().startsWith(secondNumber + "|" + firstNumber) ||
                        entry.getKey().endsWith(firstNumber + "|" + secondNumber) ||
                        entry.getKey().endsWith(secondNumber + "|" + firstNumber)
                ) {
                    returnList.add(entry);
                }
            }
        }
        return returnList;
    }
}
