package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static <K extends String, V extends Comparable> List<Entry<K, V>> findMostSimilarEntriesWithGivenTwo(
            @NonNull List<Map.Entry<K , V>> entryList, int elementsLimit) throws Throwable {
        if (entryList.isEmpty()) {
            throw new IllegalArgumentException("entry list should not be empty!");
        }
        List<Map.Entry<K, V>> copyList = entryList.stream().collect(Collectors.toList());
        List<Map.Entry<K, V>> returnList = new LinkedList<>();
        for (int i = 1; i <= elementsLimit; i++) {
                Entry<K, V> maxEntry = (Entry<K, V>) copyList.stream().max(Comparator.comparing(Entry::getValue))
                        .orElseThrow(NoSuchElementException::new);//może pozbyć się jakoś wyjątku, szukać tylko w mapach, które mają odpowiednie klucze
                    returnList.add(maxEntry);
                    copyList.remove(maxEntry);
       }
        return returnList;
    }

    /**
     *
     * @param firstNumber
     * @param secondNumber
     * @param list
     * @param <K>
     * @param <V>
     * @return
     * filtruje listę map dwójek po kluczach zawierających firstNumber i secondNumber. zwraca listę
     * entriesów, które spełniają warunek.
     */
    public static <K extends String, V> List<Map.Entry<K, V>> filterListOfMapsByFirstAndSecondNumber(
            String firstNumber,
            String secondNumber,
            List<Map<K, V>> list) {
        List<Map<K, V>> copyList = list.stream().collect(Collectors.toList());
        List<Entry<K, V>> returnList = new LinkedList<>();
        Pattern searched = Pattern.compile(
                "(" + firstNumber + "\\|" + secondNumber + " i [1-9][0-9]?\\|[1-9][0-9]?)|("
                        + secondNumber + "\\|" + firstNumber + " i [1-9][0-9]?\\|[1-9][0-9]?)|([1-9][0-9]?\\|[1-9][0-9]? i "
                        + firstNumber + "\\|" + secondNumber +")|([1-9][0-9]?\\|[1-9][0-9]? i "
                        + secondNumber + "\\|" + firstNumber +")"
        );
        for (Map map : copyList) {
            Set<Entry<K, V>> entrySet = map.entrySet();
            for (Entry<K, V> entry : entrySet) {
                Matcher text = searched.matcher(entry.getKey());
                if (text.matches()) {
                    returnList.add(entry);
                }
            }
        }
        return returnList;//jak nie znajdzie, to zwróci pustą listę
    }

    public static <K extends String, V> List<Map.Entry<K, V>> filterListOfMapsByFirstAndSecondNumber(
            String firstNumber,
            String secondNumber,
            List<List<Map<K, V>>> listOfList,
            List<Entry<K, V>> returnList// sztuczka, żeby kolejne wywołanie tej metody działało na zwracanej liście
    ) {
        Pattern searched = Pattern.compile(
                "(" + firstNumber + "\\|" + secondNumber + " i [1-9][0-9]?\\|[1-9][0-9]?)|("
                        + secondNumber + "\\|" + firstNumber + " i [1-9][0-9]?\\|[1-9][0-9]?)|([1-9][0-9]?\\|[1-9][0-9]? i "
                        + firstNumber + "\\|" + secondNumber +")|([1-9][0-9]?\\|[1-9][0-9]? i "
                        + secondNumber + "\\|" + firstNumber +")"
        );
        entry_found:
        for (List <Map<K, V>> list : listOfList) { //zawsze znajdzie to czego szuka
            for (Map map : list) {
                Set<Entry<K, V>> entrySet = map.entrySet();
                for (Entry<K, V> entry : entrySet) {
                    Matcher text = searched.matcher(entry.getKey());
                    if (text.matches()) {
                        returnList.add(entry);
                        break entry_found;
                    }
                }
            }
        }
        return returnList;
    }
}
